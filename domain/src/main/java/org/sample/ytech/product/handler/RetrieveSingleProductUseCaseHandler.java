package org.sample.ytech.product.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.sample.ytech.depot.usecase.RetrieveSingleDepotUseCase;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.port.ProductPort;
import org.sample.ytech.product.usecase.RetrieveSingleProductUseCase;

@DomainComponent
public class RetrieveSingleProductUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<Product, RetrieveSingleProductUseCase> {

    private final ProductPort productPort;

    public RetrieveSingleProductUseCaseHandler(ProductPort productPort) {
        this.productPort = productPort;
        register(RetrieveSingleProductUseCase.class, this);
    }

    @Override
    public Product handle(RetrieveSingleProductUseCase useCase) {
        return productPort.retrieveProduct(useCase.getProductId());
    }
}
