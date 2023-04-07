package org.sample.ytech.stock.usecase;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.common.model.UseCase;

import java.math.BigDecimal;

@Data
@Builder
public class CreateStockUseCase implements UseCase {
    private Long productId;
    private Integer piece;
}
