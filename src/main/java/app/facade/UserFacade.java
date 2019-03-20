package app.facade;
import app.entity.User;
import app.model.UserModel;
import app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    private final
    UserService userService;

    @Autowired
    public UserFacade(UserService userService) {
        this.userService = userService;
    }


    public String welcomeFacade(){
        String usersList = userService.getAllUsers();
        return "Facade is called";
    }

    public User addUser(User requestBody) throws Exception {
        try {
            userService.addUser(requestBody);
            return null;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void addUserByMongo(UserModel requestBody) {


        userService.addUserbyMongo(requestBody);


    }
}
