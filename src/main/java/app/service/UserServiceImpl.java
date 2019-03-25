package app.service;

import app.datamapper.UserDao;
import app.entity.User;
import app.model.LoginModel;
import app.model.UserModel;
import app.modelconverter.ModelConverter;
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

    private final ModelConverter modelConverter;

//    private final UserMongoRep mongoRep;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, ModelConverter modelConverter/*, UserMongoRep mongoRep*/) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.modelConverter = modelConverter;
//        this.mongoRep = mongoRep;
    }

    public String getAllUsers() {
        userDao.findAll();
        return "James";
    }

    @Transactional
    public void addUser(User user) throws DataIntegrityViolationException {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreated_date(new Date());
            user.setUpdate_date(new Date());
            userDao.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
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
    public void authenticateUser(LoginModel loginModel) {
        User userDetails;

        if (!StringUtils.isEmpty(loginModel.getEmail())) {
            userDetails = userDao.findByEmail(loginModel.getEmail());
        } else {
            userDetails = userDao.findUserByPhone(loginModel.getPhone());
        }

        System.out.println(userDetails);

    }
}
















