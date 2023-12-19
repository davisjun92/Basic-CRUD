package com.projectalpha.quickstart.services;

import com.projectalpha.quickstart.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<Product> getProductList(int pageNo);

    Product saveProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Product product);

    void deleteProductById(Long id);

}
