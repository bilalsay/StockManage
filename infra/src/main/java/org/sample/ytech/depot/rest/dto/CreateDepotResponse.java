package org.sample.ytech.depot.rest.dto;

import lombok.Builder;
import lombok.Data;
import org.sample.ytech.depot.model.CreateDepotProcessResult;

@Data
@Builder
public class CreateDepotResponse {

    private String status;
    private String message;

    public static CreateDepotResponse fromModel(CreateDepotProcessResult createDepotProcessStatus) {
        return CreateDepotResponse.builder()
                .status(createDepotProcessStatus.getStatus())
                .message(createDepotProcessStatus.getMessage())
                .build();
    }
}
