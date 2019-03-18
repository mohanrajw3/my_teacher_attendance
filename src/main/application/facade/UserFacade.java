package application.facade;
import application.entity.User;
import application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    @Autowired
    UserService userService;


    public String welcomeFacade(){
        String usersList = userService.getAllUsers();
        return "Facade is called";
    }

    public User addUser(User requestBody) {
        userService.addUser(requestBody);
        return null;
    }
}
