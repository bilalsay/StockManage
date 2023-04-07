package org.sample.ytech.stock.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.product.usecase.CreateProductUseCase;
import org.sample.ytech.stock.usecase.CreateStockUseCase;

import java.math.BigDecimal;

@Data
@Builder
public class CreateStockRequest {
    private Long productId;
    private Integer piece;

    public CreateStockUseCase toUseCase() {
        return  CreateStockUseCase.builder()
                .productId(getProductId())
                .piece(getPiece())
                .build();
    }
}
