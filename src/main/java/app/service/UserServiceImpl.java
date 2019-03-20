package app.service;

import app.datamapper.UserDao;
import app.entity.User;
import app.model.UserModel;
import app.mongo.UserMongoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final UserMongoRep mongoRep;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, UserMongoRep mongoRep) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.mongoRep = mongoRep;
    }

    public String getAllUsers() {
        userDao.findAll();
        return "James";
    }

    public void addUser(User user) throws Exception {
        try {

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreated_date(new Date());
            user.setUpdate_date(new Date());
            userDao.save(user);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void addUserbyMongo(UserModel requestBody) {
        mongoRep.save(requestBody);
    }
}
