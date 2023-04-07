package org.sample.ytech.depot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateDepotProcessResult {

    private String status;
    private String message;
}
