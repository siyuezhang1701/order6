package com.thoughtworks.ketsu.infrastructure.repository;


import com.thoughtworks.ketsu.infrastructure.core.Product;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductRepository implements com.thoughtworks.ketsu.infrastructure.core.ProductRepository{

    @Inject
    ProductMapper productMapper;
    @Override
    public Product createProduct(Map<String, Object> info) {
        productMapper.save(info);

        return productMapper.findById(Long.valueOf(String.valueOf(info.get("id"))));
    }

    @Override
    public List<Product> getAllProduct() {
        return productMapper.getAll();
    }

    @Override
    public Optional<Product> findProductById(long productId) {
        return Optional.ofNullable(productMapper.findById(productId));
    }
}
