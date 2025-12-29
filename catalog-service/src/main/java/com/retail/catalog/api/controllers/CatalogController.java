package com.retail.catalog.api.controllers;

import com.retail.catalog.application.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/catalog")
public interface CatalogController {

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAll();

    @GetMapping("/product/{productId}")
    ResponseEntity<?> get(@PathVariable int productId);

    @PostMapping("/productbyids")
    ResponseEntity<List<Product>> getByIds(@RequestBody List<Integer> productIds);

    @PostMapping("/product/add")
    ResponseEntity<Product> add(@RequestBody Product product);

    @PatchMapping("/product/update")
    ResponseEntity<Product> update(@RequestBody Product product);

    @DeleteMapping("/product/delete/{productId}")
    void  delete(@PathVariable int product_id);
}
