package app.controller;

import app.facade.UserFacade;
import app.logger.AdminLog;
import app.model.ResponseObject;
import app.model.ShopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "shop")
public class ShopRest {


    private final
    UserFacade userFacade;

    @Autowired
    public ShopRest(UserFacade userFacade) {
        this.userFacade = userFacade;
    }



    @PostMapping("/insert/{userId}")
    public ResponseObject addShopToUser(@PathVariable Integer userId,@RequestBody ShopModel shopModel ) {
        ResponseObject responseObject = new ResponseObject();

        try {
            userFacade.addShopToUser(shopModel,userId);
        } catch (Exception e) {
            AdminLog.error(e.getMessage());
        }

        return responseObject;
    }


    @PostMapping("/insert")
    public ResponseObject addShop(@RequestBody ShopModel shopModel) {
        ResponseObject responseObject = new ResponseObject();

        try {
            userFacade.addShop(shopModel);
        } catch (Exception e) {
            AdminLog.error(e.getMessage());
        }

        return responseObject;
    }



}
