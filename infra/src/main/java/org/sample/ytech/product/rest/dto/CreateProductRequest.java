package org.sample.ytech.product.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.depot.usecase.CreateDepotUseCase;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.usecase.CreateProductUseCase;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductRequest {
    private String name;
    private String sku;
    private String barcode;
    private Integer type;
    private Boolean isFrozen;
    private BigDecimal price;
    private String unitType;

    public CreateProductUseCase toUseCase() {
        return  CreateProductUseCase.builder()
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
