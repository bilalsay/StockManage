package org.sample.ytech.stock.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.stock.usecase.CreateStockUseCase;
import org.sample.ytech.stock.usecase.TransferStockUseCase;

@Data
@Builder
public class TransferStockRequest {
    private Long stockId;
    private Long toDepotId;

    public TransferStockUseCase toUseCase() {
        return  TransferStockUseCase.builder()
                .stockId(getStockId())
                .toDepotId(getToDepotId())
                .build();
    }
}
