package org.sample.ytech.product.port;

import org.sample.ytech.product.model.Product;

import java.util.List;

public interface ProductPort {

    public Product retrieveProduct(Long productId);

    public void saveProduct(Product product);
}
