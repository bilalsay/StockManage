package org.sample.ytech.stock.jpa;

import lombok.RequiredArgsConstructor;
import org.sample.ytech.depot.jpa.entity.DepotEntity;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.product.jpa.entity.ProductEntity;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.port.ProductPort;
import org.sample.ytech.stock.jpa.entity.StockEntity;
import org.sample.ytech.stock.jpa.repository.StockJpaRepository;
import org.sample.ytech.stock.model.Stock;
import org.sample.ytech.stock.port.StockPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockDataAdapter implements StockPort {

    private final StockJpaRepository stockJpaRepository;

    @Override
    public Stock retrieveStock(Long stockId) {
        return stockJpaRepository.findById(stockId)
                .orElse(new StockEntity())
                .toModel();
    }

    @Override
    @Transactional
    public void saveStock(Stock stock) {
        Depot depot = stock.getDepot();
        Product product = stock.getProduct();
        StockEntity stockEntity = new StockEntity();

        DepotEntity depotEntity = new DepotEntity();
        depotEntity.setId(depot.getId());
        depotEntity.setDepotName(depot.getDepotName());
        depotEntity.setType(depot.getType());
        depotEntity.setCity(depot.getCity());
        depotEntity.setLocation(depot.getLocation());
        depotEntity.setStatus(depot.getStatus());
        depotEntity.setCostCenter(depot.getCostCenter());

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setSku(product.getSku());
        productEntity.setBarcode(product.getBarcode());
        productEntity.setType(product.getType());
        productEntity.setIsFrozen(product.getIsFrozen());
        productEntity.setPrice(product.getPrice());
        productEntity.setUnitType(product.getUnitType());

        stockEntity.setId(stock.getId());
        stockEntity.setDepot(depotEntity);
        stockEntity.setProduct(productEntity);
        stockEntity.setPiece(stock.getPiece());

        stockJpaRepository.save(stockEntity);
    }
}
