package org.sample.ytech.stock.jpa.repository;

import org.sample.ytech.stock.jpa.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockJpaRepository extends JpaRepository<StockEntity, Long> {

    public Optional<StockEntity> findById(Long id);
}
