package com.retail.catalog.api.controllers;

import com.retail.catalog.application.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("")
public interface ProductController {

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAll();
}
