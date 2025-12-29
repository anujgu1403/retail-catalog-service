
package com.retail.catalog.application.services.impl;

import com.retail.catalog.application.mapper.ProductModelToProductMapper;
import com.retail.catalog.application.mapper.ProductToProductModelMapper;
import com.retail.catalog.domain.ProductModel;
import com.retail.catalog.application.services.ProductService;
import com.retail.catalog.application.model.Product;
import com.retail.catalog.infrastructure.repository.ProductRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryAdapter productRepositoryAdapter;

    @Autowired
    private ProductModelToProductMapper productModelToProductMapper;

    @Autowired
    private ProductToProductModelMapper productToProductModelMapper;

    @Override
    public List<Product> getAll() {
        List<ProductModel> productModels = productRepositoryAdapter.getAll();
        return productModels.stream()
                .map(productModel -> productModelToProductMapper.apply(productModel))
                .toList();
    }

    @Override
    public Product getById(int id) {
        ProductModel productModel = productRepositoryAdapter.getById(id);
        return productModelToProductMapper.apply(productModel);
    }

    @Override
    public List<Product> getByIds(List<Integer> ids) {
        List<ProductModel> productModels = productRepositoryAdapter.getByIds(ids);
        return productModels.stream()
                .map(productModel -> productModelToProductMapper.apply(productModel))
                .toList();
    }

    @Override
    public Product add(Product product) {
        ProductModel productModel = productRepositoryAdapter.add(productToProductModelMapper.apply(product));
        return productModelToProductMapper.apply(productModel);
    }

    @Override
    public Product update(Product product) {
        ProductModel productModel = productRepositoryAdapter.update(productToProductModelMapper.apply(product));
        return productModelToProductMapper.apply(productModel);
    }

    @Override
    public void delete(int id) {
        productRepositoryAdapter.delete(id);
    }
}
