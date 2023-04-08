package org.sample.ytech.depot.usecase;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.common.model.UseCase;

@Data
@Builder
public class RetrieveSingleDepotWithTypeUseCase implements UseCase {
    private Integer type;
}
