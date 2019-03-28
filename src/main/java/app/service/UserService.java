package app.service;


import app.entity.Shop;
import app.entity.User;
import app.model.LoginModel;
import app.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String getAllUsers();

    void addUser(User user) throws Exception;

    User getUserByEmail(String email) throws Exception;

    void addUserbyMongo(UserModel requestBody) throws Exception;

    User authenticateUser(LoginModel login) throws Exception;

    void addShopToUser(Shop shop, Integer userId) throws Exception;
}
