package org.sample.ytech.stock.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStockProcessResult {

    private String status;
    private String message;
}
