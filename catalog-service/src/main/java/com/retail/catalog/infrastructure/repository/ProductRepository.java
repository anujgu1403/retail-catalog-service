package com.retail.catalog.infrastructure.repository;

import com.retail.catalog.domain.ProductModel;
import java.util.List;

public interface ProductRepository {
    List<ProductModel> getAll();

    ProductModel getById(int id);

    List<ProductModel> getByIds(List<Integer> ids);

    ProductModel add(ProductModel productModel);

    ProductModel update(ProductModel productModel);

    void delete(int id);
}
