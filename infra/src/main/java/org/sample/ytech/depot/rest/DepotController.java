package org.sample.ytech.depot.rest;

import lombok.RequiredArgsConstructor;
import org.sample.ytech.common.BaseController;
import org.sample.ytech.common.Response;
import org.sample.ytech.common.UnknownProjectException;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.depot.model.CreateDepotProcessResult;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.rest.dto.CreateDepotRequest;
import org.sample.ytech.depot.rest.dto.CreateDepotResponse;
import org.sample.ytech.depot.rest.dto.DepotDto;
import org.sample.ytech.depot.usecase.CreateDepotUseCase;
import org.sample.ytech.depot.usecase.RetrieveSingleDepotUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/depots")
@RequiredArgsConstructor
public class DepotController extends BaseController {

    private final BeanAwareUseCasePublisher publisher;

    @GetMapping(value = "/{depotId}")
    public Response<DepotDto> getDepot(@PathVariable Long depotId) throws UnknownProjectException {
        var retrieveSingleDepot = RetrieveSingleDepotUseCase.builder()
                .depotId(depotId)
                .build();
        var depot = publisher.publish(Depot.class, retrieveSingleDepot);
        return respond(DepotDto.fromModel(depot));
    }

    @PostMapping
    public Response<CreateDepotResponse> createDepot(@RequestBody CreateDepotRequest createDepotRequest) {
        CreateDepotUseCase createDepotUseCase = createDepotRequest.toUseCase();
        var createDepotProcessResult = publisher.publish(CreateDepotProcessResult.class, createDepotUseCase);
        return respond(CreateDepotResponse.fromModel(createDepotProcessResult));
    }

}
