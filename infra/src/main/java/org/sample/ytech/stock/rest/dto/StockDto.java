package org.sample.ytech.stock.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sample.ytech.depot.model.Depot;
import org.sample.ytech.depot.rest.dto.DepotDto;
import org.sample.ytech.product.model.Product;
import org.sample.ytech.product.rest.dto.ProductDto;
import org.sample.ytech.stock.model.Stock;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private DepotDto depot;
    private ProductDto product;
    private Integer piece;

    public static StockDto fromModel(Stock stock) {
        return StockDto.builder()
                .depot(DepotDto.fromModel(stock.getDepot()))
                .product(ProductDto.fromModel(stock.getProduct()))
                .piece(stock.getPiece())
                .build();
    }
}
