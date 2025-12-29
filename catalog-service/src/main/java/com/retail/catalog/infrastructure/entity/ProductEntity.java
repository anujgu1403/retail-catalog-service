
package com.retail.catalog.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double unit_price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image_url;

    @Column(nullable = false)
    private Integer category_id;

    @Column(nullable = false)
    private OffsetDateTime created_date;
}
