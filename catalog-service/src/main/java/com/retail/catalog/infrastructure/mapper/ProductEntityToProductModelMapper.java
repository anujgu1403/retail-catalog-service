package com.retail.catalog.infrastructure.mapper;

import com.retail.catalog.domain.ProductModel;
import com.retail.catalog.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToProductModelMapper {
    public ProductModel apply(ProductEntity productEntity){
        return ProductModel.builder()
                .productId(productEntity.getProduct_id())
                .categoryId(productEntity.getCategory_id())
                .name(productEntity.getName())
                .createdDate(productEntity.getCreated_date())
                .description(productEntity.getDescription())
                .imageUrl(productEntity.getImage_url())
                .unitPrice(productEntity.getUnit_price())
                .build();
    }
}
