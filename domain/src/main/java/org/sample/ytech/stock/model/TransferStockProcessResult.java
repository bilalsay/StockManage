package org.sample.ytech.stock.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferStockProcessResult {

    private String status;
    private String message;
}
