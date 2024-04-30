package com.app.service;
import com.app.dao.ProductDao;
import com.app.exception.ProductNotfoundException;
import com.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public List<ProductDetails> getAllProducts() {
        return productDao.getAllProducts();
    }

    //@Transactional
    @Override
    public List<ProductDetails> findByName(String productName) {
       return productDao.findByName(productName);
    }

    @Override
    public List<ProductDetails> findById(int id) throws ProductNotfoundException {
        if(id<=0)
            throw new ProductNotfoundException("Product not found");
        else if(productDao.findById(id)== null)
            throw new ProductNotfoundException("No product with this id");
       return productDao.findById(id);
    }

    @Override
    public void updateProduct(ProductDetails productDetails) {
        if(!productDetails.getName().isEmpty()){
            productDao.updateProduct(productDetails);
        }
        else
            System.out.println("Not found");
    }

    @Override
    public ProductDetails insert(ProductDetails productDetails) {
        if(!productDetails.getName().isEmpty()) {
            productDao.insert(productDetails);
            return productDetails;
        }
        else
            throw new NullPointerException();
    }

//
//    @Override
//    public Product_details showProduct(int id) {
//        return productDao.showProduct(id);
//    }
//
//    @Override
//    public void update(Product_details productDetails) {
//        Product product = productDao.findByProductDetails(productDetails);
//        if (product != null)
//        {
//            productDao.update(productDetails);
//        }
//        else
//            throw new NullPointerException();
//        //return productDetails;
//    }
//
//

//
//    @Override
//    public Product getAllProducts() {
//        return null;
//    }


}
