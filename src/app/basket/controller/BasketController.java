package app.basket.controller;

import app.basket.services.BasketServices;
import app.product.model.Product;

import java.util.HashMap;

public class BasketController {
    public static HashMap<String, String> addProductToBasket(Product product, Double quantity){
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "error");
        boolean addProduct = BasketServices.addProductToBasketService(product, quantity);

        if(addProduct){
            response.put("status", "OK");
            response.put("code", "200");
            response.put("message", "This product " + product.getProductId() + " Added to basket");
            response.put("product",product.toString());
        }else{
            response.put("status", "KO");
            response.put("code", "409");
            response.put("message", "Invalid structure");
        }
        return response;
    }
}
