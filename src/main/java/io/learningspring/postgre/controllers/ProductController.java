package io.learningspring.postgre.controllers;

import io.learningspring.postgre.entities.Product;
import io.learningspring.postgre.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService  productService;

    @RequestMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products = productService.getProducts();
        return products;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/expiredwarranty")
    public List<Product> expiredwarranty() {
        return productService.expiredWarranty();
    }

    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getByName(name);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}
