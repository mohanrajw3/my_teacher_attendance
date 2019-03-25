package app.facade;

import app.entity.User;
import app.model.LoginModel;
import app.model.UserModel;
import app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserFacade {

    private final
    UserService userService;

    @Autowired
    public UserFacade(UserService userService) {
        this.userService = userService;
    }


    public String welcomeFacade() {
        String usersList = userService.getAllUsers();
        return "Facade is called";
    }

    public void addUser(User requestBody) throws Exception {
        try {
            userService.addUser(requestBody);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void addUserByMongo(UserModel requestBody) {


        userService.addUserbyMongo(requestBody);


    }

    public void authenticateUser(LoginModel login) {

        if ((!StringUtils.isEmpty(login.getEmail()) || !StringUtils.isEmpty(login.getPhone()))
                && !StringUtils.isEmpty(login.getPassword())) {
            userService.authenticateUser(login);
        }

    }
}
