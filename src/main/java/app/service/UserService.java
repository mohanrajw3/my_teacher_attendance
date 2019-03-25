package app.service;


import app.entity.User;
import app.model.LoginModel;
import app.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String getAllUsers();

    void addUser(User user) throws Exception;

    User getUserByEmail(String email);

    void addUserbyMongo(UserModel requestBody);

    void authenticateUser(LoginModel login);
}
