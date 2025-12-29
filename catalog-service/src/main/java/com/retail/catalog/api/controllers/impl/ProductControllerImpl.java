
package com.retail.catalog.api.controllers.impl;

import com.retail.catalog.api.controllers.ProductController;
import com.retail.catalog.application.model.Product;
import com.retail.catalog.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productAppService;

    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productAppService.getAll());
    }
}
