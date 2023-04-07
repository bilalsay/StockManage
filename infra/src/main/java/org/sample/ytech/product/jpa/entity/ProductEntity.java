package org.sample.ytech.product.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.sample.ytech.common.AbstractEntity;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.usecase.CreateDepotUseCase;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.rest.dto.ProductDto;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "product", schema = "public")
public class ProductEntity extends AbstractEntity {

    private String name;
    private String sku;
    private String barcode;
    private Integer type;
    private Boolean isFrozen;
    private BigDecimal price;
    private String unitType;

    public Product toModel() {
        return Product.builder()
                .id(getId())
                .name(getName())
                .sku(getSku())
                .barcode(getBarcode())
                .type(getType())
                .isFrozen(getIsFrozen())
                .price(getPrice())
                .unitType(getUnitType())
                .build();
    }
}
