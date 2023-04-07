package org.sample.ytech.stock.port;

import org.sample.ytech.stock.model.Stock;

public interface StockPort {

    public Stock retrieveStock(Long stockId);

    public void saveStock(Stock stock);
}
