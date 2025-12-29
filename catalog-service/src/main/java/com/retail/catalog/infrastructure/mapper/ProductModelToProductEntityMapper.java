package com.retail.catalog.infrastructure.mapper;

import com.retail.catalog.domain.ProductModel;
import com.retail.catalog.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductModelToProductEntityMapper {
    public ProductEntity apply(ProductModel productModel) {
        return ProductEntity.builder()
                .product_id(productModel.getProductId())
                .category_id(productModel.getCategoryId())
                .name(productModel.getName())
                .created_date(productModel.getCreatedDate())
                .description(productModel.getDescription())
                .image_url(productModel.getImageUrl())
                .unit_price(productModel.getUnitPrice())
                .build();
    }
}
