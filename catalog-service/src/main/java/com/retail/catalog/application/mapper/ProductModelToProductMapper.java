package com.retail.catalog.application.mapper;

import com.retail.catalog.application.model.Product;
import com.retail.catalog.domain.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductModelToProductMapper {
    public Product apply(ProductModel productModel){
        return Product.builder()
                .productId(productModel.getProductId())
                .categoryId(productModel.getCategoryId())
                .name(productModel.getName())
                .description(productModel.getDescription())
                .imageUrl(productModel.getImageUrl())
                .createdDate(productModel.getCreatedDate())
                .unitPrice(productModel.getUnitPrice())
                .build();
    }
}
