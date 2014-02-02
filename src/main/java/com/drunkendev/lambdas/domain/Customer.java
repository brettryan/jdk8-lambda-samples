/*
 * Customer.java    Feb 1 2014, 17:21
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


/**
 *
 * @author  Brett Ryan
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Customer {

    @XmlElement(name = "id")
    private String customerId;
    @XmlElement(name = "name")
    private String companyName;
    @XmlElement
    private String address;
    @XmlElement
    private String city;
    @XmlElement
    private String region;
    @XmlElement(name = "postalcode")
    private String postalCode;
    @XmlElement
    private String country;
    @XmlElement
    private String phone;
    @XmlElement
    private String fax;
    @XmlElement(name = "orders")
    private CustomerOrders customerOrdersList;

    /**
     * Creates a new {@code Customer} instance.
     */
    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public CustomerOrders getCustomerOrdersList() {
        return customerOrdersList;
    }

    public void setCustomerOrdersList(CustomerOrders customerOrdersList) {
        this.customerOrdersList = customerOrdersList;
    }

    public List<Order> getOrders() {
        return customerOrdersList == null ? Collections.<Order>emptyList() : customerOrdersList.getOrders();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.customerId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Customer other = (Customer) obj;
            return Objects.equals(this.customerId, other.customerId);
        }
        return false;
    }


    public static class CustomerOrders {

        @XmlElement(name = "order")
        private List<Order> orders;

        public List<Order> getOrders() {
            if (orders == null) {
                orders = new ArrayList<Order>();
            }
            return this.orders;
        }

    }

}
