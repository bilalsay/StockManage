package org.sample.ytech.depot.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.sample.ytech.common.AbstractEntity;
import org.sample.ytech.depot.model.Depot;


@Getter
@Setter
@Entity
@Table(name = "depot", schema = "public")
public class DepotEntity extends AbstractEntity {

    private String depotName;
    private Integer type;
    private String city;
    private String location;
    private Integer status;
    private String costCenter;

    public Depot toModel() {
        return Depot.builder()
                .id(getId())
                .depotName(getDepotName())
                .type(getType())
                .city(getCity())
                .location(getLocation())
                .status(getStatus())
                .costCenter(getCostCenter())
                .build();
    }
}
