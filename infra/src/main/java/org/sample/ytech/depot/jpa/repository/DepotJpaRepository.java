package org.sample.ytech.depot.jpa.repository;

import org.sample.ytech.depot.jpa.entity.DepotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepotJpaRepository extends JpaRepository<DepotEntity, Long> {

    public Optional<DepotEntity> findById(Long id);

    public Optional<DepotEntity> findByType(Integer type);
}
