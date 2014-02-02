/*
 * ProjectionOperators.java    Feb 2 2014, 04:08
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
import com.drunkendev.lambdas.domain.Product;
import com.drunkendev.lambdas.helper.IndexHolder;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author  Brett Ryan
 */
public class ProjectionOperators {

    private final DomainService ds;

    /**
     * Creates a new {@code ProjectionOperators} instance.
     */
    public ProjectionOperators() {
        this.ds = new DomainService();
    }

    public static void main(String[] args) {
        ProjectionOperators po = new ProjectionOperators();
//        po.lambda6();
//        po.lambda7();
//        po.lambda8();
//        po.lambda9();
//        po.lambda10();
//        po.lambda11();
//        po.lambda12();
//        po.lambda13();
//        po.lambda14();
//        po.lambda15();
//        po.lambda16();
//        po.lambda17();
//        po.lambda18();
        po.lambda19();
    }

    /**
     * This sample uses a map to produce a sequence of ints one higher than
     * those in an existing array of ints
     */
    public void lambda6() {
        System.out.println("\nNumbers + 1:");
        List<Integer> numbers = Arrays.asList(5, 4, 1, 3, 9, 8, 6, 7, 2, 0);
        numbers.stream()
                .map(n -> ++n)
                .forEach(System.out::println);
    }

    /**
     * This sample uses a map to produce a sequence of just the names of a list
     * of products.
     */
    public void lambda7() {
        System.out.println("\nProduct Names:");
        ds.getProductList().stream()
                .map(Product::getProductName)
                .forEach(System.out::println);
    }

    /**
     * This sample uses map to produce a sequence of strings representing the
     * text version of a sequence of ints.
     */
    public void lambda8() {
        System.out.println("\nNumbers + 1:");
        List<Integer> numbers = Arrays.asList(5, 4, 1, 3, 9, 8, 6, 7, 2, 0);
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        numbers.stream()
                .map(n -> strings[n])
                .forEach(System.out::println);
    }

    /**
     * This sample uses forEach to produce a sequence of the uppercase and
     * lowercase versions of each word in the original array.
     */
    public void lambda9() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        Arrays.stream(words)
                .forEach(n -> System.out.println(String.format(
                                        "Uppercase: %s, Lowercase: %s",
                                        n.toUpperCase(), n.toLowerCase())));
    }

    /**
     * This sample uses forEach to produce a sequence containing text
     * representations of digits and whether their length is even or odd.
     */
    public void lambda10() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Arrays.stream(numbers)
                .forEach(n -> System.out.println(String.format(
                                        "The digit %s is %s.",
                                        strings[n], n % 2 == 0 ? "even" : "odd")));
    }

    /**
     * This sample uses forEach to produce a sequence outputting some properties
     * of Products...
     */
    public void lambda11() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("Product Info:");
        ds.getProductList().stream()
                .forEach(p -> {
                    System.out.println(String.format(
                                    "%s is in the category %s and costs %s per unit.",
                                    p.getProductName(),
                                    p.getCategory(),
                                    nf.format(p.getUnitPrice())));
                });
    }

    /**
     * This sample uses an indexed forEach to determine if the value of ints in
     * an array match their position in the array.
     */
    public void lambda12() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        IndexHolder i = new IndexHolder();
        Arrays.stream(numbers)
                .forEach(x -> System.out.println(String.format("%d: %s", x, x == i.postIncrement())));
    }

    /**
     * This sample returns the text form of each digit less than 5.
     */
    public void lambda13() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        System.out.println("Numbers < 5:");
        Arrays.stream(numbers)
                .filter(n -> n < 5)
                .mapToObj(n -> digits[n])
                .forEach(System.out::println);
    }

    /**
     * Given two arrays we find all pairs where a is &lt; b.
     */
    public void lambda14() {
        int[] numbersA = {0, 2, 4, 5, 6, 8, 9};
        int[] numbersB = {1, 3, 5, 7, 8};
        System.out.println("Pairs where a < b:");
        Arrays.stream(numbersA)
                .forEach(a -> Arrays.stream(numbersB)
                        .filter(b -> a < b)
                        .forEach(b -> {
                            System.out.println(String.format("%d is less than %d", a, b));
                        })
                );
    }

    /**
     * A nested forEach to produce all customer/order entries.
     *
     * <p>Note that we can not use a
     * {@link java.util.stream.Stream#flatMap(java.util.function.Function) Stream.flatMap}
     * As we still require a reference to the customer.
     * </p>
     */
    public void lambda15() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        BigDecimal limit = BigDecimal.valueOf(500);
        String x;
        ds.getCustomerList().stream()
                .forEach(c -> {
                    c.getOrders().stream()
                    .filter(o -> limit.compareTo(o.getTotal()) > 0)
                    .forEach(o -> System.out.println(String.format(
                                            "customerId=%s orderId=%d total=%s",
                                            c.getCustomerId(),
                                            o.getOrderId(),
                                            nf.format(o.getTotal())
                                    )));
                });
    }

    /**
     * A nested forEach clause to produce all orders where the order was made in
     * 1998 or later.
     */
    public void lambda16() {
        LocalDateTime ldt = LocalDateTime.of(1998, 1, 1, 0, 0);
        ds.getCustomerList().stream()
                .forEach(c -> {
                    c.getOrders().stream()
                    .filter(o -> o.getOrderDate().isAfter(ldt) || o.getOrderDate().equals(ldt))
                    .forEach(o -> System.out.println(String.format(
                                            "customerId=%s orderId=%d orderDte=%s",
                                            c.getCustomerId(),
                                            o.getOrderId(),
                                            o.getOrderDate().toString()
                                    )));
                });
    }

    /**
     * A nested forEach clause to produce all orders where the order total is
     * greater than 2000.00.
     */
    public void lambda17() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        BigDecimal limit = BigDecimal.valueOf(2000);
        ds.getCustomerList().stream()
                .forEach(c -> {
                    c.getOrders().stream()
                    .filter(o -> limit.compareTo(o.getTotal()) <= 0)
                    .forEach(o -> System.out.println(String.format(
                                            "customerId=%s orderId=%d total=%s",
                                            c.getCustomerId(),
                                            o.getOrderId(),
                                            nf.format(o.getTotal())
                                    )));
                });
    }

    /**
     * A nested forEach clause filtering customers before filtering their orders.
     */
    public void lambda18() {
        LocalDateTime cutoffDate = LocalDateTime.of(1997, 1, 1, 0, 0);
        ds.getCustomerList().stream()
                .filter(c -> "WA".equalsIgnoreCase(c.getRegion()))
                .forEach(c -> {
                    c.getOrders().stream()
                    .filter(o -> o.getOrderDate().isAfter(cutoffDate) || o.getOrderDate().equals(cutoffDate))
                    .forEach(o -> System.out.println(String.format(
                                            "customerId=%s orderId=%d",
                                            c.getCustomerId(),
                                            o.getOrderId()
                                    )));
                });
    }

    /**
     * Uses an index to produce an indexed customer followed by its orders.
     */
    public void lambda19() {
        IndexHolder i = new IndexHolder();
        ds.getCustomerList().stream()
                .forEach(c -> {
                    i.postIncrement();
                    c.getOrders().stream()
                    .forEach(o -> System.out.println(String.format(
                                            "Customer #%d has an order with orderId=%d",
                                            i.getIndex(),
                                            o.getOrderId()
                                    )));
                });
    }

}
