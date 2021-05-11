package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.exception.ResourcesNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException(id));
        return new ProductDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        return this.productRepository.findAll().stream().map(product -> new ProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = this.dtoEntity(productDto);
        Product saveProduct = this.productRepository.save(product);
        return new ProductDto(saveProduct);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    private Product dtoEntity(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}
