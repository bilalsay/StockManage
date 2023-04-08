package org.sample.ytech.product.handler;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.common.usecase.ObservableUseCasePublisher;
import org.sample.ytech.common.usecase.UseCaseHandler;
import org.sample.ytech.depot.model.CreateDepotProcessResult;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.port.DepotPort;
import org.sample.ytech.depot.usecase.CreateDepotUseCase;
import org.sample.ytech.product.model.CreateProductProcessResult;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.port.ProductPort;
import org.sample.ytech.product.usecase.CreateProductUseCase;

import java.util.List;

@DomainComponent
public class CreateProductUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<CreateProductProcessResult, CreateProductUseCase> {

    private final ProductPort productPort;

    public CreateProductUseCaseHandler(ProductPort productPort) {
        this.productPort = productPort;
        register(CreateProductUseCase.class, this);
    }

    @Override
    public CreateProductProcessResult handle(CreateProductUseCase useCase) {
        Product product = Product.builder()
                .name(useCase.getName())
                .sku(useCase.getSku())
                .barcode(useCase.getBarcode())
                .type(useCase.getType())
                .isFrozen(useCase.getIsFrozen())
                .price(useCase.getPrice())
                .unitType(useCase.getUnitType())
                .build();
        productPort.saveProduct(product);

        return CreateProductProcessResult.builder()
                .status("200")
                .message("Success")
                .build();
    }
}
