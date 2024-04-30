package com.app.dao;

import com.app.model.Product;
import com.app.model.ProductDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Product insert(ProductDetails productDetails) {
        try {
            Session session = sessionFactory.getCurrentSession();
            productDetails.setExpiration(productDetails.getExpiration());

            Product product = new Product(productDetails.getName());
            product.setProductDetails(productDetails);
            session.persist(product);
            return product;
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    public void delete(int theid) {

        try {
            Session session = sessionFactory.getCurrentSession();
            //Product product = session.get(Product.class , theid);

            //to delete the product
            Query query = session.createQuery("delete from Product  where id=:productId");
            query.setParameter("productId" , theid);
            query.executeUpdate();

            //to delete the product details
            query = session.createQuery("delete from ProductDetails  where id=:productDetailsId");
            query.setParameter("productDetailsId" , theid);
            query.executeUpdate();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public List<ProductDetails> findByName(String searchProductName) {
            Session session=sessionFactory.getCurrentSession();
            Query query=session.createQuery("from ProductDetails where name=:productName");
            query.setParameter("productName",searchProductName);
            return query.list();
    }

    @Override
    public List<ProductDetails> findById(int id) {
        Session session= sessionFactory.getCurrentSession();
        Query query=session.createQuery("from ProductDetails where id=:productId");
        query.setParameter("productId",id);
        return query.list();
    }

    @Override
    public void updateProduct(ProductDetails newProduct) {
      try{
          Session session=sessionFactory.getCurrentSession();
          ProductDetails oldProductDetails = session.get(ProductDetails.class ,
                  newProduct.getId());
          Product oldProduct=newProduct.getProduct();
          oldProduct.setName(newProduct.getName());

          oldProductDetails.setName(newProduct.getName());
          oldProductDetails.setPrice(newProduct.getPrice());
          oldProductDetails.setManufacturer(newProduct.getManufacturer());
          oldProductDetails.setExpiration(newProduct.getExpiration());
          oldProductDetails.setAvailablility(newProduct.isAvailablility());
          oldProductDetails.setProduct(newProduct.getProduct());

          oldProduct.setProductDetails(oldProductDetails);
          session.update(oldProduct);
      }
      catch (Exception exception){
          exception.printStackTrace();
      }


    }


    @Override
    public List<ProductDetails> getAllProducts() {
        try{
            Session session= sessionFactory.getCurrentSession();
            Query query=session.createQuery("FROM ProductDetails ");
            return (List<ProductDetails>) query.list();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }
}

//    @Override
//    public Product insert(Product_details productDetails) {
//        //Product_details productDetails;
//        try {
//            Session session = sessionFactory.getCurrentSession();
//            productDetails.setExpiration(productDetails.getExpiration());
//            //productDetails.setName(productDetails.getName());
//            //productDetails.setExpiration(productDetails.getExpiration());
//            //productDetails.setManufacturer(productDetails.getManufacturer());
//            //productDetails.setPrice(productDetails.getPrice());
//           // productDetails.setAvailability(productDetails.isAvailability());
//            Product product=new Product(productDetails.getName());
//            product.setProductDetails(productDetails);
//            //productDetails.setProduct(productDetails.getProduct());
//
//            //product.setProductDetails(productDetails);
//            //product.setName(productDetails.getName());
//            session.persist(product);
//            return product;
//        }
//        catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return null;
////        productDetails.getProduct().setProductName(productDetails.getProductName());
////        productDetails.setProductName(productDetails.getProductName());
//
//    }
//    @Override
//    public Product insert(Product_details productDetails) {
//        try {
//            Session session = sessionFactory.getCurrentSession();
//            productDetails.setExpiration(productDetails.getExpiration());
//
//            Product product = new Product(productDetails.getName());
//            product.setProductDetails(productDetails);
//            session.persist(product);
//            return product;
//        }catch (Exception exception)
//        {
//            exception.printStackTrace();
//        }
//        return null;
//    }


//    public <List> ProductDetails getAllProducts() {
//        try{
//            Session session= sessionFactory.getCurrentSession();
//            Query query=session.createQuery("FROM ProductDetails ");
//            return (ProductDetails) query.list();
//        }
//        catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return null;
//    }
//
//
//
//    @Override
//    public void update(Product_details newProduct) {
//       try {
//           Session session=sessionFactory.getCurrentSession();
//           Product_details oldProductDetails = session.get(Product_details.class , newProduct.getId());
//           Product product=oldProductDetails.getProduct();
//
//           // update product
//           product.setProductName(newProduct.getProductName());
//           product.setProductDetails(newProduct);
//
//           //update product details
//           oldProductDetails.setProductName(newProduct.getProductName());
//           oldProductDetails.setProductPrice(newProduct.getProductPrice());
//           oldProductDetails.setAvailability(newProduct.isAvailability());
//           oldProductDetails.setExpDate(newProduct.getExpDate());
//           oldProductDetails.setManufacturer(newProduct.getManufacturer());
//
//           session.update(product);
//       }
//       catch (Exception exception){
//           exception.printStackTrace();
//       }
//
//    }
//
//    @Override

//
//    @Override
//    public Product_details showProduct(int id) {
//            try {
//                Session session = sessionFactory.getCurrentSession();
//                return session.get(Product_details.class , id);
//            }catch (Exception exception)
//            {
//                exception.printStackTrace();
//            }
//            return null;
//    }
//
//    @Override
//    public Product findByProductDetails(Product_details productDetails) {
//        return null;
//    }



