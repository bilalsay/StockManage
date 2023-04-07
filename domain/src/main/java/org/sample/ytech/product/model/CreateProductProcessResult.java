package org.sample.ytech.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductProcessResult {

    private String status;
    private String message;
}
