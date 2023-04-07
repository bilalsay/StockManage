package org.sample.ytech.product.jpa.repository;

import org.sample.ytech.product.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    public Optional<ProductEntity> findById(Long id);
}
