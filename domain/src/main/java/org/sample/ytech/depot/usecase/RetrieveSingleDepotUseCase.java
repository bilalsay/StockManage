package org.sample.ytech.depot.usecase;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.common.model.UseCase;

@Data
@Builder
public class RetrieveSingleDepotUseCase implements UseCase {
    private Long depotId;
}
