package org.sample.ytech.depot.port;

import org.sample.ytech.depot.model.Depot;

import java.util.List;

public interface DepotPort {

    public Depot retrieveDepot(Long depotId);

    public List<Depot> retrieveDepotByType(Integer type);

    public void saveDepot(Depot depot);
}
