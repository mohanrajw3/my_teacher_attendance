package app.modelconverter;


import app.entity.Shop;
import app.entity.User;
import app.model.LoginModel;
import app.model.ShopModel;
import app.model.UserModel;
import org.springframework.stereotype.Service;

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
        userModel.setName(user.getFname());
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
        shop.setUpdate_date(shopModel.getUpdate_date());
        shop.setCreated_date(shopModel.getCreated_date());
        shop.setShop_email(shopModel.getShopEmail());

        return shop;
    }
}
