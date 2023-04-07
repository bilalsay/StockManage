package org.sample.ytech.stock.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.stock.model.Stock;
import org.sample.ytech.stock.port.StockPort;
import org.sample.ytech.stock.usecase.RetrieveSingleStockUseCase;

@DomainComponent
public class RetrieveSingleStockUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<Stock, RetrieveSingleStockUseCase> {

    private final BeanAwareUseCasePublisher publisher;

    private final StockPort stockPort;

    public RetrieveSingleStockUseCaseHandler(BeanAwareUseCasePublisher publisher, StockPort stockPort) {
        this.publisher = publisher;
        this.stockPort = stockPort;
        register(RetrieveSingleStockUseCase.class, this);
    }


    @Override
    public Stock handle(RetrieveSingleStockUseCase useCase) {
        return stockPort.retrieveStock(useCase.getStockId());
    }
}
