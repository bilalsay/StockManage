package org.sample.ytech.product.rest;

import lombok.RequiredArgsConstructor;
import org.sample.ytech.common.BaseController;
import org.sample.ytech.common.Response;
import org.sample.ytech.common.UnknownProjectException;
import org.sample.ytech.common.usecase.BeanAwareUseCasePublisher;
import org.sample.ytech.depot.model.CreateDepotProcessResult;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.usecase.CreateDepotUseCase;
import org.sample.ytech.depot.usecase.RetrieveSingleDepotUseCase;
import org.sample.ytech.product.model.CreateProductProcessResult;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.rest.dto.CreateProductRequest;
import org.sample.ytech.product.rest.dto.CreateProductResponse;
import org.sample.ytech.product.rest.dto.ProductDto;
import org.sample.ytech.product.usecase.CreateProductUseCase;
import org.sample.ytech.product.usecase.RetrieveSingleProductUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

    private final BeanAwareUseCasePublisher publisher;

    @GetMapping(value = "/{productId}")
    public Response<ProductDto> getProduct(@PathVariable Long productId) throws UnknownProjectException {
        var retrieveSingleProduct = RetrieveSingleProductUseCase.builder()
                .productId(productId)
                .build();
        var product = publisher.publish(Product.class, retrieveSingleProduct);
        return respond(ProductDto.fromModel(product));
    }

    @PostMapping
    public Response<CreateProductResponse> createDepot(@RequestBody CreateProductRequest createProductRequest) {
        CreateProductUseCase createProductUseCase = createProductRequest.toUseCase();
        var createProductProcessResult = publisher.publish(CreateProductProcessResult.class, createProductUseCase);
        return respond(CreateProductResponse.fromModel(createProductProcessResult));
    }

}
