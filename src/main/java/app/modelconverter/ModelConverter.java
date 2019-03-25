package app.modelconverter;


import app.entity.User;
import app.model.LoginModel;
import org.springframework.stereotype.Service;

@Service
public class ModelConverter {


    public User convertLoginModelToUser(LoginModel loginModel) {

        User user = new User();
        user.setPhone(loginModel.getPhone());
        user.setEmail(loginModel.getEmail());
        return user;
    }
}
