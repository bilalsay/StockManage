package org.sample.ytech.product.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.product.model.Product;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;
    private String sku;
    private String barcode;
    private Integer type;
    private Boolean isFrozen;
    private BigDecimal price;
    private String unitType;

    public static ProductDto fromModel(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .sku(product.getSku())
                .barcode(product.getBarcode())
                .type(product.getType())
                .isFrozen(product.getIsFrozen())
                .price(product.getPrice())
                .unitType(product.getUnitType())
                .build();
    }
}
