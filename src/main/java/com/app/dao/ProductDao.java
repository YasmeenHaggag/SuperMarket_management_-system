package com.app.dao;

import com.app.model.Product;
import com.app.model.ProductDetails;

import java.util.List;

public interface ProductDao {
      public Product insert(ProductDetails productDetails);
//    public void update(Product_details productDetails);
//
     public void delete(int id);
//
//    public Product_details showProduct(int id);
      public List<ProductDetails> findByName(String productName);
      public List<ProductDetails> findById(int id);
      public void updateProduct(ProductDetails productDetails);



    public List<ProductDetails> getAllProducts();


}
