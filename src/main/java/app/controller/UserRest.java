package app.controller;

import app.entity.User;
import app.facade.UserFacade;
import app.logger.AdminLog;
import app.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("user")
public class UserRest {


    final
    UserFacade userFacade;

    @Autowired
    public UserRest(UserFacade userFacade) {
        this.userFacade = userFacade;
    }


    @GetMapping
    public String getAllUser() {
        return userFacade.welcomeFacade();
    }


    @PostMapping
    public UserModel addUsersToAccount(@RequestBody User requestBody) {

        UserModel userModel = null;
        try {
            userFacade.addUser(requestBody);
        } catch (Exception e) {
            AdminLog.error(e.getMessage());
        }
        return userModel;
    }

    @PostMapping(path = "/mongo")
    public UserModel addUsersByMongo(@RequestBody UserModel requestBody) {
        UserModel userModel = null;
        try {
            userFacade.addUserByMongo(requestBody);
        } catch (Exception e) {
            AdminLog.error(e.getMessage());
        }
        return userModel;
    }


}
