package org.sample.ytech.depot.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.depot.model.CreateDepotProcessResult;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.sample.ytech.depot.usecase.CreateDepotUseCase;

import java.util.List;

@DomainComponent
public class CreateDepotUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<CreateDepotProcessResult, CreateDepotUseCase> {

    private final DepotPort depotPort;

    public CreateDepotUseCaseHandler(DepotPort depotPort) {
        this.depotPort = depotPort;
        register(CreateDepotUseCase.class, this);
    }


    @Override
    public CreateDepotProcessResult handle(CreateDepotUseCase useCase) {
        if (useCase.getType().intValue() == 1) {
            List<Depot> depotList = depotPort.retrieveDepotByType(1);
            if (!depotList.isEmpty()) {
                return CreateDepotProcessResult.builder()
                        .status("400")
                        .message("Birde fazla Ana depo oluşturulamaz.")
                        .build();
            }
        }

        Depot depot = Depot.builder()
                .depotName(useCase.getDepotName())
                .type(useCase.getType())
                .city(useCase.getCity())
                .location(useCase.getLocation())
                .status(useCase.getStatus())
                .costCenter(useCase.getCostCenter())
                .build();
        depotPort.saveDepot(depot);

        return CreateDepotProcessResult.builder()
                .status("200")
                .message("Success")
                .build();
    }
}
