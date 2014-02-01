/*
 * Order.java    Feb 1 2014, 17:11
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

import com.drunkendev.lambdas.xml.BigDecimalAdapter;
import com.drunkendev.lambdas.xml.LocalDateTimeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Represents a sales order.
 *
 * @author  Brett Ryan
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Order {

    @XmlElement(name = "id")
    private int orderId;
    @XmlElement(name = "orderdate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime orderDate;
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal total;

    /**
     * Creates a new {@code Order} instance.
     */
    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.orderId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Order other = (Order) obj;
            return this.orderId == other.orderId;
        }
        return false;
    }

}
