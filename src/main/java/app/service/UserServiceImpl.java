package app.service;

import app.datamapper.UserDao;
import app.entity.Shop;
import app.entity.User;
import app.model.LoginModel;
import app.model.UserModel;
import app.modelconverter.ModelConverter;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;


//    private final UserMongoRep mongoRep;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder/*, UserMongoRep mongoRep*/) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
//        this.mongoRep = mongoRep;
    }

    public String getAllUsers() {
        userDao.findAll();
        return "James";
    }

    @Transactional
    public void addUser(User user) throws HibernateException {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreated_date(new Date());
            user.setUpdate_date(new Date());
            userDao.save(user);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void addUserbyMongo(UserModel requestBody) {
//        mongoRep.save(requestBody);
    }

    @Override
    public User authenticateUser(LoginModel loginModel) throws Exception {
        try {
            User userDetails;

            if (!StringUtils.isEmpty(loginModel.getEmail())) {
                userDetails = userDao.findByEmail(loginModel.getEmail());
            } else {
                userDetails = userDao.findUserByPhone(loginModel.getPhone());
            }

            return userDetails;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Override
    @Transactional
    public void addShopToUser(Shop shop, Integer userId) throws Exception{
        try {
            User user = userDao.findUserById(userId);
            user.setShop(shop);
            userDao.saveAndFlush(user);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
















