package org.sample.ytech.stock.rest;

import lombok.RequiredArgsConstructor;
import org.sample.ytech.common.BaseController;
import org.sample.ytech.common.Response;
import org.sample.ytech.common.UnknownProjectException;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.product.model.CreateProductProcessResult;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.usecase.CreateProductUseCase;
import org.sample.ytech.product.usecase.RetrieveSingleProductUseCase;
import org.sample.ytech.stock.model.CreateStockProcessResult;
import org.sample.ytech.stock.model.Stock;
import org.sample.ytech.stock.model.TransferStockProcessResult;
import org.sample.ytech.stock.rest.dto.*;
import org.sample.ytech.stock.usecase.CreateStockUseCase;
import org.sample.ytech.stock.usecase.RetrieveSingleStockUseCase;
import org.sample.ytech.stock.usecase.TransferStockUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stocks")
@RequiredArgsConstructor
public class StockController extends BaseController {

    @GetMapping(value = "/{stockId}")
    public Response<StockDto> getProduct(@PathVariable Long stockId) throws UnknownProjectException {
        var retrieveSingleStock = RetrieveSingleStockUseCase.builder()
                .stockId(stockId)
                .build();
        var stock = publish(Stock.class, retrieveSingleStock);
        return respond(StockDto.fromModel(stock));
    }

    @PostMapping
    public Response<CreateStockResponse> createStock(@RequestBody CreateStockRequest createStockRequest) {
        CreateStockUseCase createStockUseCase = createStockRequest.toUseCase();
        var createStockProcessResult = publish(CreateStockProcessResult.class, createStockUseCase);
        return respond(CreateStockResponse.fromModel(createStockProcessResult));
    }

    @PostMapping(value = "/transfer")
    public Response<TransferStockResponse> transferStock(@RequestBody TransferStockRequest transferStockRequest) {
        TransferStockUseCase transferStockUseCase = transferStockRequest.toUseCase();
        var transferStockProcessResult = publish(TransferStockProcessResult.class, transferStockUseCase);
        return respond(TransferStockResponse.fromModel(transferStockProcessResult));
    }
}
