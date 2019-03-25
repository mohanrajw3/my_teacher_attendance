package app.controller;


import app.entity.User;
import app.facade.UserFacade;
import app.model.LoginModel;
import app.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginRest {


    @Autowired
    UserFacade userFacade;


    @PostMapping("authentiate")
    public ResponseObject authenticate(@RequestBody LoginModel login) {
        ResponseObject response = new ResponseObject();
        userFacade.authenticateUser(login);

        return response;

    }

}
