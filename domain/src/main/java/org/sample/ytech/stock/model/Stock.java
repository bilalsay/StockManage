package org.sample.ytech.stock.model;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.product.model.Product;

import java.math.BigDecimal;

@Data
@Builder
public class Stock {
    private Long id;
    private Depot depot;
    private Product product;
    private Integer piece;
}
