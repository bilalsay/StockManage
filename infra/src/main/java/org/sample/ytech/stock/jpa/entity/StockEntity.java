package org.sample.ytech.stock.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.sample.ytech.common.AbstractEntity;
import org.sample.ytech.depot.jpa.entity.DepotEntity;
import org.sample.ytech.product.jpa.entity.ProductEntity;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.stock.model.Stock;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "stock", schema = "public")
public class StockEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "depotId")
    private DepotEntity depot;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;
    private Integer piece;

    public Stock toModel() {
        return Stock.builder()
                .id(getId())
                .depot(getDepot().toModel())
                .product(getProduct().toModel())
                .piece(getPiece())
                .build();
    }
}
