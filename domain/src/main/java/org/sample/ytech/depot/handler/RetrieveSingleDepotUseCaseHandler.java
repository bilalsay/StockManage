package org.sample.ytech.depot.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.sample.ytech.depot.usecase.RetrieveSingleDepotUseCase;

@DomainComponent
public class RetrieveSingleDepotUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<Depot, RetrieveSingleDepotUseCase> {

    private final BeanAwareUseCasePublisher publisher;

    private final DepotPort depotPort;

    public RetrieveSingleDepotUseCaseHandler(BeanAwareUseCasePublisher publisher, DepotPort depotPort) {
        this.publisher = publisher;
        this.depotPort = depotPort;
        register(RetrieveSingleDepotUseCase.class, this);
    }


    @Override
    public Depot handle(RetrieveSingleDepotUseCase useCase) {
        return depotPort.retrieveDepot(useCase.getDepotId());
    }
}
