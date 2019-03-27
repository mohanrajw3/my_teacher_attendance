package app.service;

import app.entity.Shop;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {

    void addShop(Shop shop) throws Exception;
}
