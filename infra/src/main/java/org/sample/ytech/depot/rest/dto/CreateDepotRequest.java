package org.sample.ytech.depot.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.depot.usecase.CreateDepotUseCase;

@Data
@Builder
public class CreateDepotRequest {
    private String depotName;
    private Integer type;
    private String city;
    private String location;
    private Integer status;
    private String costCenter;

    public CreateDepotUseCase toUseCase() {
        return CreateDepotUseCase.builder()
                .depotName(getDepotName())
                .type(getType())
                .city(getCity())
                .location(getLocation())
                .status(getStatus())
                .costCenter(getCostCenter())
                .build();
    }
}
