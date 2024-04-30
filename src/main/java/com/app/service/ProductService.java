package com.app.service;

import com.app.exception.ProductNotfoundException;
import com.app.model.ProductDetails;

import java.util.List;

public interface ProductService {
     public ProductDetails insert(ProductDetails productDetails);
//
//    public Product_details showProduct(int id);
//
//    public void update(Product_details productDetails);
//
      public void delete(int id);
//
   public List<ProductDetails> getAllProducts();
   List<ProductDetails> findByName(String productName);
    public List<ProductDetails> findById(int id) throws ProductNotfoundException;
    public void updateProduct(ProductDetails productDetails);

}
