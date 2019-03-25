package app.controller;

import app.constants.ResponseMessage;
import app.entity.User;
import app.facade.UserFacade;
import app.logger.AdminLog;
import app.model.ResponseObject;
import app.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserRest {


    private final
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
    public ResponseObject addUsersToAccount(@RequestBody User requestBody) {

        ResponseObject responseObject = new ResponseObject();
        try {
            userFacade.addUser(requestBody);
            responseObject.setCode(HttpStatus.OK);
            responseObject.setMessage(ResponseMessage.USER_ADD_SUCCESS);
        } catch (Exception e) {
            AdminLog.error(e.getMessage());
            return handleErrorMessages(e, responseObject);
        }

        return responseObject;
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

    public ResponseObject handleErrorMessages(Exception e, ResponseObject responseObject) {

        if (e.getMessage().contains("EMAIL_UNIQUE")) {
            responseObject.setCode(HttpStatus.IM_USED);
            responseObject.setMessage(ResponseMessage.USER_EMAIL_EXIST);
        } else {
            responseObject.setCode(HttpStatus.NO_CONTENT);
            responseObject.setMessage(e.getMessage());
        }
        return responseObject;
    }


}
