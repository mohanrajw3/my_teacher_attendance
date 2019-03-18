package application.controller;

import application.facade.UserFacade;
import application.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("user")
public class UserRest {


    @Autowired
    UserFacade userFacade;


    @GetMapping
    public String getAllUser() {
        return userFacade.welcomeFacade();
    }


    @PostMapping
    public UserModel addUsersToAccount(@RequestBody UserModel requestBody) {
        System.out.println(requestBody);
        return null;
    }


}
