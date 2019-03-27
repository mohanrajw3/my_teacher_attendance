package app.service;


import app.datamapper.ShopDao;
import app.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopServiceImpl implements ShopService {


    @Autowired
    ShopDao shopDao;

    @Transactional
    public void addShop(Shop shop) throws Exception{
        try {
            shopDao.save(shop);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
