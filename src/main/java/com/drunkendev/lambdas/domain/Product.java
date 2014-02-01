/*
 * Product.java    Feb 1 2014, 16:58
 *
 * Copyright 2014 Drunken Dev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drunkendev.lambdas.domain;

import java.math.BigDecimal;


/**
 * Represents a product entry.
 *
 * @author  Brett Ryan
 */
public class Product {

    private int productID;
    private String productName;
    private String category;
    private BigDecimal unitPrice;
    private int unitsInStock;

    /**
     * Creates a new {@code Product} instance.
     */
    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int ProductID) {
        this.productID = ProductID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.productID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Product other = (Product) obj;
            return this.productID == other.productID;
        }
        return false;
    }

}
