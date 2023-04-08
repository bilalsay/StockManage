package org.sample.ytech.depot.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.sample.ytech.depot.usecase.RetrieveSingleDepotUseCase;
import org.sample.ytech.depot.usecase.RetrieveSingleDepotWithTypeUseCase;

@DomainComponent
public class RetrieveSingleDepotWithTypeUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<Depot, RetrieveSingleDepotWithTypeUseCase> {

    private final DepotPort depotPort;

    public RetrieveSingleDepotWithTypeUseCaseHandler(DepotPort depotPort) {
        this.depotPort = depotPort;
        register(RetrieveSingleDepotWithTypeUseCase.class, this);
    }

    @Override
    public Depot handle(RetrieveSingleDepotWithTypeUseCase useCase) {
        return depotPort.retrieveDepotByType(useCase.getType()).stream()
                .findFirst()
                .orElse(null);
    }
}
