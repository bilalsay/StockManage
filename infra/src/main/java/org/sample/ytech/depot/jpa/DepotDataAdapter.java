package org.sample.ytech.depot.jpa;

import lombok.RequiredArgsConstructor;
import org.sample.ytech.depot.jpa.entity.DepotEntity;
import org.sample.ytech.depot.jpa.repository.DepotJpaRepository;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepotDataAdapter implements DepotPort {

    private final DepotJpaRepository depotJpaRepository;

    @Override
    public Depot retrieveDepot(Long depotId) {
        return depotJpaRepository.findById(depotId)
                .orElse(new DepotEntity())
                .toModel();
    }

    @Override
    public List<Depot> retrieveDepotByType(Integer type) {
        return depotJpaRepository.findByType(type).stream()
                .map(depotEntity -> depotEntity.toModel())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveDepot(Depot depot) {
        DepotEntity depotEntity = new DepotEntity();
        depotEntity.setDepotName(depot.getDepotName());
        depotEntity.setType(depot.getType());
        depotEntity.setCity(depot.getCity());
        depotEntity.setLocation(depot.getLocation());
        depotEntity.setStatus(depot.getStatus());
        depotEntity.setCostCenter(depot.getCostCenter());
        depotJpaRepository.save(depotEntity);
    }
}
