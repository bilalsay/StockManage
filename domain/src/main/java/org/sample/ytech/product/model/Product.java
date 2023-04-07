package org.sample.ytech.product.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private String sku;
    private String barcode;
    private Integer type;
    private Boolean isFrozen;
    private BigDecimal price;
    private String unitType;
}
