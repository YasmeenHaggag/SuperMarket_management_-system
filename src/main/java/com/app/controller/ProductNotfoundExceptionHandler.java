package com.app.controller;

import com.app.exception.ProductNotfoundException;
import com.app.exception.response.ProductErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotfoundExceptionHandler {
    @ExceptionHandler
    ProductErrorResponse handleResponse(ProductNotfoundException exception){
        ProductErrorResponse productErrorResponse=new ProductErrorResponse();
        productErrorResponse.setMessage(exception.getMessage());
        productErrorResponse.setCode(HttpStatus.NOT_FOUND.value());
        productErrorResponse.setTime(System.currentTimeMillis());

        return productErrorResponse;

    }
}
