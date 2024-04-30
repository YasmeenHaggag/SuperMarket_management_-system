package com.app.controller;

import com.app.exception.ProductNotfoundException;
import com.app.exception.response.ProductErrorResponse;
import com.app.model.ProductDetails;
import com.app.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@Api(tags = "Product Controller")
public class HomeController {
    @Autowired
    ProductService productService;
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "This is a successful response"),
        @ApiResponse(code = 404, message = "Product Not found"),
        @ApiResponse(code = 500, message = "This is a server error")
})


    @DeleteMapping("/products")
    @ApiOperation(value = "API to delete product using id")
    public void deleteProduct(@RequestParam ("productId") int id ){
        productService.delete(id);

        //return "deleted";
    }

    @PostMapping("/products")
    public ProductDetails insertProduct(@RequestBody ProductDetails productDetails){
        return productService.insert(productDetails);
    }

//    @GetMapping("/products")
//    public List<ProductDetails> getProductByName(@RequestParam ("productName") String name) {
//        return productService.findByName(name);
//    }
    // ToDo
    @GetMapping("/products")
    public List<ProductDetails> getProductByID(@RequestParam ("productId") int id) throws ProductNotfoundException {
           return productService.findById(id);

    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody ProductDetails productDetails) {
        productService.updateProduct(productDetails);
    }

    @ApiIgnore
    @GetMapping("/test")
    public String test(@RequestHeader ("language") String lang){
           return lang;
    }




//    @GetMapping("/products")
//    public List<ProductDetails> getProductByName(@RequestParam (value = "productName",
//            required = false)
//            String name,@RequestParam(value = "productId",required = false) int id){
//
//        return
//        productService.findById(id);
//        //productService.findByName(name),
//    }




}
