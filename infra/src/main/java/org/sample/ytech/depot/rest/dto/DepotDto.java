package org.sample.ytech.depot.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sample.ytech.depot.model.Depot;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepotDto {

    private String depotName;
    private Integer type;
    private String city;
    private String location;
    private Integer status;
    private String costCenter;

    public static DepotDto fromModel(Depot depot) {
        return DepotDto.builder()
                .depotName(depot.getDepotName())
                .type(depot.getType())
                .city(depot.getCity())
                .location(depot.getLocation())
                .status(depot.getStatus())
                .costCenter(depot.getCostCenter())
                .build();
    }
}
