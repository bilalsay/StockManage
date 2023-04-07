package org.sample.ytech.stock.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.port.ProductPort;
import org.sample.ytech.stock.model.CreateStockProcessResult;
import org.sample.ytech.stock.model.Stock;
import org.sample.ytech.stock.model.TransferStockProcessResult;
import org.sample.ytech.stock.port.StockPort;
import org.sample.ytech.stock.usecase.CreateStockUseCase;
import org.sample.ytech.stock.usecase.TransferStockUseCase;

@DomainComponent
public class TransferStockUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<TransferStockProcessResult, TransferStockUseCase> {

    private final BeanAwareUseCasePublisher publisher;

    private final StockPort stockPort;

    private final DepotPort depotPort;

    public TransferStockUseCaseHandler(BeanAwareUseCasePublisher publisher,
                                       StockPort stockPort,
                                       DepotPort depotPort,
                                       ProductPort productPort) {
        this.publisher = publisher;
        this.stockPort = stockPort;
        this.depotPort = depotPort;
        register(TransferStockUseCase.class, this);
    }

    @Override
    public TransferStockProcessResult handle(TransferStockUseCase useCase) {
        Stock stock = stockPort.retrieveStock(useCase.getStockId());
        Depot fromDepot = stock.getDepot();
        Depot toDepot = depotPort.retrieveDepot(useCase.getToDepotId());

        if (fromDepot.getType().intValue() != 1) {
            return TransferStockProcessResult.builder()
                    .status("400")
                    .message("Yalnız Ana depodaki stocklar transfer edilebilir.")
                    .build();
        }

        //12.915700, 77.632046, 11.665154, 78.145657
        String[] fromDepotLocationArgs = fromDepot.getLocation().split(",");
        String[] toDepotLocationArgs = toDepot.getLocation().split(",");

        double fromDepotLat = Double.parseDouble(fromDepotLocationArgs[0]);
        double fromDepotLon= Double.parseDouble(fromDepotLocationArgs[1]);
        double toDepotLat = Double.parseDouble(toDepotLocationArgs[0]);
        double toDepotLon= Double.parseDouble(toDepotLocationArgs[1]);

        double dlon = toDepotLon - fromDepotLon;
        double dlat = toDepotLat - fromDepotLat;

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(fromDepotLat) * Math.cos(toDepotLat)
                * Math.pow(Math.sin(dlon / 2),2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;
        double between = c * r;

        if (between > 1000) {
            return TransferStockProcessResult.builder()
                    .status("400")
                    .message("100 KM den fazla transfer yapılamaz.")
                    .build();
        }

        stock.setDepot(toDepot);

        stockPort.saveStock(stock);

        return TransferStockProcessResult.builder()
                .status("200")
                .message("Success")
                .build();
    }
}
