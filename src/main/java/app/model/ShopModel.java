package app.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ShopModel {

    private String shopName;

    private String shopAddress;

    private String shopNation;

    private String shopState;

    private String shopCity;

    private String shopEmail;

    private String shopPhone;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date created_date;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date update_date;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopNation() {
        return shopNation;
    }

    public void setShopNation(String shopNation) {
        this.shopNation = shopNation;
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState;
    }

    public String getShopCity() {
        return shopCity;
    }

    public void setShopCity(String shopCity) {
        this.shopCity = shopCity;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
}
