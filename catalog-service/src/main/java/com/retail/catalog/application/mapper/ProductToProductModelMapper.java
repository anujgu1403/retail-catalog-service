package com.retail.catalog.application.mapper;

import com.retail.catalog.application.model.Product;
import com.retail.catalog.domain.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductModelMapper {
    public ProductModel apply(Product product){
        return ProductModel.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .createdDate(product.getCreatedDate())
                .imageUrl(product.getImageUrl())
                .categoryId(product.getCategoryId())
                .build();

    }
}
