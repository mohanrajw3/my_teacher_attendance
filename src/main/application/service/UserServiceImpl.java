package application.service;

import application.datamapper.UserDao;
import application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements application.service.UserService {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @Transactional
    public String getAllUsers() {
        userDao.findAll();
        return "James";
    }

    @Transactional
    public void addUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Transactional
    public User getUserByEmail(String email) {
       return userDao.findByEmail(email);
    }
}
