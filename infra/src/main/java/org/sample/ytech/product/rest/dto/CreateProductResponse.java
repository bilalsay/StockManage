package org.sample.ytech.product.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.depot.model.CreateDepotProcessResult;
import org.sample.ytech.product.model.CreateProductProcessResult;

@Data
@Builder
public class CreateProductResponse {

    private String status;
    private String message;

    public static CreateProductResponse fromModel(CreateProductProcessResult createProductProcessResult) {
        return CreateProductResponse.builder()
                .status(createProductProcessResult.getStatus())
                .message(createProductProcessResult.getMessage())
                .build();
    }
}
