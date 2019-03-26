package app.controller;

import app.facade.UserFacade;
import app.model.ResponseObject;
import app.model.ShopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shop")
public class ShopRest {


    private final
    UserFacade userFacade;

    @Autowired
    public ShopRest(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    public ResponseObject addShop(ShopModel shopModel) {

        ResponseObject responseObject = new ResponseObject();

        userFacade.addShop(shopModel);



        return responseObject;

    }
}
