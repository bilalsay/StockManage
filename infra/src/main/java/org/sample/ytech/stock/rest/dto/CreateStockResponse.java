package org.sample.ytech.stock.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.product.model.CreateProductProcessResult;
import org.sample.ytech.stock.model.CreateStockProcessResult;

@Data
@Builder
public class CreateStockResponse {

    private String status;
    private String message;

    public static CreateStockResponse fromModel(CreateStockProcessResult createStockProcessResult) {
        return CreateStockResponse.builder()
                .status(createStockProcessResult.getStatus())
                .message(createStockProcessResult.getMessage())
                .build();
    }
}
