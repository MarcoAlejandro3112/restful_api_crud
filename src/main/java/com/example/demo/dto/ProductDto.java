package com.example.demo.dto;

import com.example.demo.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String code;
    private String description;

    public ProductoDto(Product product){
        BeanUtils.copyProperties(product, this);
    }
}
