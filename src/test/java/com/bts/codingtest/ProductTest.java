/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bts.codingtest;

import com.btsshop.entity.shopping.Product;
import org.junit.jupiter.api.Test;

/**
 *
 * @author MODERN 14
 */
public class ProductTest {

    /**
     * Test of builder method, of class Product.
     */
    @Test
    public void testBuilder() {
//        Product iphone = new Product.ProductBuilder().build();
        // atau
        Product iphone = Product.builder().build();
        iphone.setId("xxx");
        iphone.setPrice(20_000_000L);
        iphone.setSku("XXX");
        
        System.out.println(iphone.getPrice());
        System.out.println(iphone.getName());
        System.out.println(iphone.getSku());
    }
    
}
