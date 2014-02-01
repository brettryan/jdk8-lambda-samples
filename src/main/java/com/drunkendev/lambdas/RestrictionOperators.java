/*
 * RestrictionOperators.java    Feb 2 2014, 03:01
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

package com.drunkendev.lambdas;

import com.drunkendev.lambdas.domain.DomainService;
import com.drunkendev.lambdas.helper.IndexHolder;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author  Brett Ryan
 */
public class RestrictionOperators {

    private final DomainService ds;

    /**
     * Creates a new {@code RestrictionOperators} instance.
     */
    public RestrictionOperators() {
        this.ds = new DomainService();
    }

    public static void main(String[] args) {
        RestrictionOperators ro = new RestrictionOperators();
        ro.lambda1();
        ro.lambda2();
        ro.lambda3();
        ro.lambda4();
        ro.lambda5();
    }

    /**
     * This sample uses a filter to find all elements of a list with a value
     * less than 5.
     */
    public void lambda1() {
        System.out.println("\nNumbers < 5:");
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Arrays.stream(numbers)
                .filter(n -> n < 5)
                .forEach(System.out::println);
    }

    /**
     * This sample uses a filter to find all products that are out of stock.
     */
    public void lambda2() {
        System.out.println("\nSold out products:");
        ds.getProductList().stream()
                .filter(x -> x.getUnitsInStock() == 0)
                .forEach(x -> {
                    System.out.println(String.format("%s is sold out!",
                                                     x.getProductName()));
                });
    }

    /**
     * This sample uses a filter to find all products that are in stock and cost
     * more than 3.00 per unit.
     */
    public void lambda3() {
        System.out.println("\nIn-stock products that cost more than 3.00:");
        ds.getProductList().stream()
                .filter(x -> x.getUnitsInStock() > 0)
                .filter(x -> x.getUnitPrice().compareTo(BigDecimal.valueOf(3)) > 0)
                .forEach(x -> {
                    System.out.println(String.format(
                                    "%s is in stock and costs more than 3.00.",
                                    x.getProductName()));
                });
    }

    /**
     * This sample uses a filter to find all customers in Washington and then it
     * uses a forEach to iterate over the orders collection that belongs to each
     * customer.
     *
     */
    public void lambda4() {
        System.out.println("\nCustomers from Washington and their orders:");
        ds.getCustomerList().stream()
                .filter(c -> "WA".equalsIgnoreCase(c.getRegion()))
                .forEach(c -> {
                    System.out.println(String.format("Customer %s: %s", c.getCustomerId(), c.getCompanyName()));
                    c.getOrders().getOrders().stream().forEach(o -> {
                        System.out.println(String.format(
                                        "  Order %d: %s",
                                        o.getOrderId(), o.getOrderDate().format(DateTimeFormatter.ISO_DATE)));

                    });
                });
    }

    /**
     * This sample demonstrates an indexed filter that returns digits whose name is
     * shorter than their value.

     * <strong>NOTE</strong>: Needs full conversion.
     */
    public void lambda5() {
        System.out.println("\nShort digits:");
        List<String> digits = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        IndexHolder i = new IndexHolder();
        digits.stream()
                .filter(x -> x.length() < i.postIncrement())
                .forEach(x -> System.out.println(x));
    }

}
