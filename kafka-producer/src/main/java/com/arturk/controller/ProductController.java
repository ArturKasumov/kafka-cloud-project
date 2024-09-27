package com.arturk.controller;

import com.arturk.dto.Product;
import com.arturk.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/v4")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }
}
