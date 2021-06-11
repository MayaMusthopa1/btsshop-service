/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsshop;

import com.btsshop.entity.shopping.Product;
import com.btsshop.enums.Category;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author MODERN 14
 */
@SpringBootApplication
public class ProductBuilder {

    @Bean
    @Scope("prototype")
    public Product productGadget() {
        return Product.builder()
                .category(Category.GADGET)
                .build();
    }

    @Bean
    @Scope("prototype")
    public Product productFashion() {
        return Product.builder()
                .category(Category
                .FASHION).build();
    }
}
