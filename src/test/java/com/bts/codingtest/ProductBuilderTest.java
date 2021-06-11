/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bts.codingtest;

import com.btsshop.ProductBuilder;
import com.btsshop.entity.shopping.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author MODERN 14
 */
@SpringBootTest(classes = ProductBuilder.class)
public class ProductBuilderTest {
    
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Test of productGadget method, of class ProductBuilder.
     */
    @Test
    public void testProductGadget() {
        Product product = applicationContext.getBean("productGadget", Product.class);
        product.setName("Laptop 12 Inch");
        
        System.out.println(product);
    }

    /**
     * Test of productFashion method, of class ProductBuilder.
     */
    @Test
    public void testProductFashion() {
    }
    
}
