package application.service;


import application.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String getAllUsers();

    void addUser(User user);

    User getUserByEmail(String email);

}
