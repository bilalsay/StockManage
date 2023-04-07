
package org.sample.ytech.stock.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.stock.model.CreateStockProcessResult;
import org.sample.ytech.stock.model.TransferStockProcessResult;

@Data
@Builder
public class TransferStockResponse {

    private String status;
    private String message;

    public static TransferStockResponse fromModel(TransferStockProcessResult transferStockProcessResult) {
        return TransferStockResponse.builder()
                .status(transferStockProcessResult.getStatus())
                .message(transferStockProcessResult.getMessage())
                .build();
    }
}
