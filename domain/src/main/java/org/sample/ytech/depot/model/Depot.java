package org.sample.ytech.depot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Depot {
    private Long id;
    private String depotName;
    private Integer type;
    private String city;
    private String location;
    private Integer status;
    private String costCenter;
}
