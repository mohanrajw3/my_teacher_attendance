package app.controller;


import app.constants.ResponseMessage;
import app.entity.User;
import app.facade.UserFacade;
import app.logger.AdminLog;
import app.model.LoginModel;
import app.model.ResponseObject;
import app.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginRest {


    @Autowired
    UserFacade userFacade;


    @PostMapping("authenticate")
    public ResponseObject authenticate(@RequestBody LoginModel login) {

        ResponseObject response = new ResponseObject();
        try {
            UserModel user = userFacade.authenticateUser(login);

            if (user != null) {
                response.setUser(user);
                response.setCode(HttpStatus.OK);
                response.setMessage(ResponseMessage.LOGIN_SUCCESS);
            } else {
                response.setCode(HttpStatus.FORBIDDEN);
                response.setMessage(ResponseMessage.EMAIL_PASSWORD_MISMATCH);
            }

        } catch (Exception e) {
            AdminLog.error(e.getMessage());
        }

        return response;

    }

}
