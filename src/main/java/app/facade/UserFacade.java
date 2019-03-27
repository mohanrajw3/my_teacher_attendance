package app.facade;

import app.entity.Shop;
import app.entity.User;
import app.model.LoginModel;
import app.model.ShopModel;
import app.model.UserModel;
import app.modelconverter.ModelConverter;
import app.service.ShopService;
import app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class UserFacade {

    private final
    UserService userService;

    private final
    ModelConverter modelConverter;

    private final
    ShopService shopService;

    @Autowired
    public UserFacade(UserService userService, ModelConverter modelConverter, ShopService shopService) {
        this.userService = userService;
        this.modelConverter = modelConverter;
        this.shopService = shopService;
    }


    public String welcomeFacade() {
        return "Facade is called";
    }

    public void addUser(User requestBody) throws Exception {
        try {
            userService.addUser(requestBody);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void addUserByMongo(UserModel requestBody) throws Exception {
//        userService.addUserbyMongo(requestBody);
    }

    public UserModel authenticateUser(LoginModel login) throws Exception {
        UserModel userModel = null;
        try {
            if ((!StringUtils.isEmpty(login.getEmail()) || !StringUtils.isEmpty(login.getPhone()))
                    && !StringUtils.isEmpty(login.getPassword())) {
                User user = userService.authenticateUser(login);
                return modelConverter.convertUserToUserModel(user);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void addShop(ShopModel shopModel) throws Exception {
        try {
            Shop shop = modelConverter.convertShopModelToShop(shopModel);
            shop.setCreated_date(new Date());
            shop.setUpdate_date(new Date());
            shopService.addShop(shop);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
