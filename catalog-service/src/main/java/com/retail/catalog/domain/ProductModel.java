package com.retail.catalog.domain;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private Integer productId;
    private String name;
    private String description;
    private Double unitPrice;
    private String imageUrl;
    private Integer categoryId;
    private OffsetDateTime createdDate;
}
