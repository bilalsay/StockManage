package org.sample.ytech.stock.usecase;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.common.model.UseCase;

@Data
@Builder
public class TransferStockUseCase implements UseCase {
    private Long stockId;
    private Long toDepotId;
}
