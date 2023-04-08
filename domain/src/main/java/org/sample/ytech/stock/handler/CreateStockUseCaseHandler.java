package org.sample.ytech.stock.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.sample.ytech.depot.usecase.RetrieveSingleDepotWithTypeUseCase;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.port.ProductPort;
import org.sample.ytech.product.usecase.RetrieveSingleProductUseCase;
import org.sample.ytech.stock.model.CreateStockProcessResult;
import org.sample.ytech.stock.model.Stock;
import org.sample.ytech.stock.port.StockPort;
import org.sample.ytech.stock.usecase.CreateStockUseCase;

@DomainComponent
public class CreateStockUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<CreateStockProcessResult, CreateStockUseCase> {

    private final StockPort stockPort;

    private final DepotPort depotPort;

    private final ProductPort productPort;

    public CreateStockUseCaseHandler(StockPort stockPort,
                                     DepotPort depotPort,
                                     ProductPort productPort) {
        this.stockPort = stockPort;
        this.depotPort = depotPort;
        this.productPort = productPort;
        register(CreateStockUseCase.class, this);
    }

    @Override
    public CreateStockProcessResult handle(CreateStockUseCase useCase) {
        RetrieveSingleDepotWithTypeUseCase retrieveSingleDepotWithTypeUseCase = RetrieveSingleDepotWithTypeUseCase.builder()
                .type(1)
                .build();

        Depot depot = publish(Depot.class, retrieveSingleDepotWithTypeUseCase);

        if (depot == null) {
            return CreateStockProcessResult.builder()
                    .status("400")
                    .message("Ana depo tanımlanmadan stok girişi yapılamaz.")
                    .build();
        }

        RetrieveSingleProductUseCase retrieveSingleProductUseCase = RetrieveSingleProductUseCase.builder()
                .productId(useCase.getProductId())
                .build();

        Product product = publish(Product.class, retrieveSingleProductUseCase);

        if (product == null) {
            return CreateStockProcessResult.builder()
                    .status("400")
                    .message("Bu id ile eşleşen herhangi bir product bulunamadı.")
                    .build();
        }

        Stock stock = Stock.builder()
                .depot(depot)
                .product(product)
                .piece(useCase.getPiece())
                .build();

        stockPort.saveStock(stock);

        return CreateStockProcessResult.builder()
                .status("200")
                .message("Success")
                .build();
    }
}
