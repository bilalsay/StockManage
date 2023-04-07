package org.sample.ytech.product.jpa;

import lombok.RequiredArgsConstructor;
import org.sample.ytech.depot.jpa.entity.DepotEntity;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.product.jpa.entity.ProductEntity;
import org.sample.ytech.product.jpa.repository.ProductJpaRepository;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.port.ProductPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductDataAdapter implements ProductPort {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product retrieveProduct(Long productId) {
        return productJpaRepository.findById(productId)
                .orElse(new ProductEntity())
                .toModel();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setSku(product.getSku());
        productEntity.setBarcode(product.getBarcode());
        productEntity.setType(product.getType());
        productEntity.setIsFrozen(product.getIsFrozen());
        productEntity.setPrice(product.getPrice());
        productEntity.setUnitType(product.getUnitType());
        productJpaRepository.save(productEntity);
    }
}
