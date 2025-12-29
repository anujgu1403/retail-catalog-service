
package com.retail.catalog.application.services;

import com.retail.catalog.application.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(int id);

    List<Product> getByIds(List<Integer> ids);

    Product add(Product product);

    Product update(Product product);

    void delete(int id);
}
