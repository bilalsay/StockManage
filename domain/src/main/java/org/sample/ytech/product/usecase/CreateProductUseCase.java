package org.sample.ytech.product.usecase;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.common.model.UseCase;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductUseCase implements UseCase {
    private String name;
    private String sku;
    private String barcode;
    private Integer type;
    private Boolean isFrozen;
    private BigDecimal price;
    private String unitType;
}
