package app.modelconverter;


import app.entity.Shop;
import app.entity.User;
import app.model.LoginModel;
import app.model.ShopModel;
import app.model.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class ModelConverter {


    public User convertLoginModelToUser(LoginModel loginModel) {

        User user = new User();
        user.setPhone(loginModel.getPhone());
        user.setEmail(loginModel.getEmail());
        return user;
    }


    public UserModel convertUserToUserModel(User user) {

        UserModel userModel = new UserModel();
        userModel.setFname(user.getFname());
        userModel.setEmail(user.getEmail());
        userModel.setUserType(user.getUserType());
        userModel.setPhone(user.getPhone());


        return userModel;
    }

    public Shop convertShopModelToShop(ShopModel shopModel) {

        Shop shop = new Shop();

        shop.setShop_name(shopModel.getShopName());
        shop.setShop_address(shopModel.getShopAddress());
        shop.setShop_city(shopModel.getShopCity());
        shop.setShop_nation(shopModel.getShopNation());
        shop.setShop_phone(shopModel.getShopPhone());
        shop.setShop_state(shopModel.getShopState());
        shop.setUpdate_date(new Date());
        shop.setCreated_date(new Date());
        shop.setShop_email(shopModel.getShopEmail());

        return shop;
    }

    public User convertUserModelToUser(UserModel userModel) {
        User user = new User();
        Shop shop = new Shop();


        user.setCreated_date(new Date());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setPhone(userModel.getPhone());
        user.setLname(userModel.getLname());
        user.setFname(userModel.getFname());
        user.setUserType(userModel.getUserType());
        user.setUpdate_date(new Date());


        if (shop.getShop_phone() != null && !StringUtils.isEmpty(shop.getShop_nation())) {
            shop.setShop_phone(userModel.getShopModel().getShopPhone());
            shop.setShop_state(userModel.getShopModel().getShopState());
            shop.setCreated_date(userModel.getShopModel().getCreated_date());
            shop.setUpdate_date(userModel.getShopModel().getUpdate_date());
            shop.setShop_address(userModel.getShopModel().getShopAddress());
            shop.setShop_city(userModel.getShopModel().getShopCity());
            shop.setShop_name(userModel.getShopModel().getShopName());
            shop.setShop_phone(userModel.getShopModel().getShopPhone());
            shop.setShop_nation(userModel.getShopModel().getShopNation());
            user.setShop(shop);
        }



        return user;
    }
}
