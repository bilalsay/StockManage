package org.sample.ytech.depot.usecase;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.common.model.UseCase;

@Data
@Builder
public class CreateDepotUseCase implements UseCase {
    private String depotName;
    private Integer type;
    private String city;
    private String location;
    private Integer status;
    private String costCenter;
}
