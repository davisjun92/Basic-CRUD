package com.projectalpha.quickstart.services.impl;

import com.projectalpha.quickstart.Repository.ProductRepository;
import com.projectalpha.quickstart.model.Product;
import com.projectalpha.quickstart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getProductList(int pageNo)
    {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product saveProduct(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
       return  productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
       return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

}
