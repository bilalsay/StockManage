package org.sample.ytech.product.usecase;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.common.model.UseCase;

@Data
@Builder
public class RetrieveSingleProductUseCase implements UseCase {
    private Long productId;
}
