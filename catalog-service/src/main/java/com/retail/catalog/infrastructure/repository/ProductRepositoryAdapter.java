package com.retail.catalog.infrastructure.repository;

import com.retail.catalog.domain.ProductModel;
import com.retail.catalog.infrastructure.entity.ProductEntity;
import com.retail.catalog.infrastructure.mapper.ProductEntityToProductModelMapper;
import com.retail.catalog.infrastructure.mapper.ProductModelToProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductRepositoryAdapter implements ProductRepository {

    @Autowired
    ProductJpaRepository productJpaRepository;

    @Autowired
    ProductEntityToProductModelMapper productEntityToProductModelMapper;

    @Autowired
    ProductModelToProductEntityMapper productModelToProductEntityMapper;

    @Override
    public List<ProductModel> getAll() {
        List<ProductEntity> productEntities = productJpaRepository.findAll();
        return productEntities.stream()
                .map(productEntity -> productEntityToProductModelMapper.apply(productEntity))
                .toList();
    }

    @Override
    public ProductModel getById(int id) {
        ProductEntity productEntity = productJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productEntityToProductModelMapper.apply(productEntity);
    }

    @Override
    public List<ProductModel> getByIds(List<Integer> ids) {
        List<ProductEntity> productEntities = productJpaRepository.findAllById(ids).stream().toList();
        return productEntities.stream()
                .map(productEntity -> productEntityToProductModelMapper.apply(productEntity))
                .toList();
    }

    @Override
    public ProductModel add(ProductModel productModel) {
        ProductEntity productEntity = productModelToProductEntityMapper.apply(productModel);
        // ensure id is null so JPA will insert
        productEntity.setProduct_id(null);
        ProductEntity productEntityResp = productJpaRepository.save(productEntity);
        return productEntityToProductModelMapper.apply(productEntityResp);
    }

    @Override
    public ProductModel update(ProductModel productModel) {
        if (productModel.getProductId() == null) {
            throw new IllegalArgumentException("Product id must be provided for update");
        }
        ProductEntity productEntity = productModelToProductEntityMapper.apply(productModel);
        Optional<ProductEntity> existing = productJpaRepository.findById(productEntity.getProduct_id());
        if (existing.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        // copy fields (in simple case overwrite)
        var existingEntity = existing.get();
        existingEntity.setName(Optional.ofNullable(productEntity.getName()).orElse(existingEntity.getName()));
        existingEntity.setUnit_price(Optional.ofNullable(productEntity.getUnit_price()).orElse(existingEntity.getUnit_price()));
        existingEntity.setDescription(Optional.ofNullable(productEntity.getDescription()).orElse(existingEntity.getDescription()));
        existingEntity.setCreated_date(OffsetDateTime.now());
        existingEntity.setCategory_id(Optional.ofNullable(productEntity.getCategory_id()).orElse(existingEntity.getCategory_id()));
        existingEntity.setImage_url(Optional.ofNullable(productEntity.getImage_url()).orElse(existingEntity.getImage_url()));

        ProductEntity productEntityResp = productJpaRepository.save(existingEntity);
        return productEntityToProductModelMapper.apply(productEntityResp);
    }

    @Override
    public void delete(int id) {
        productJpaRepository.deleteById(id);
    }
}
