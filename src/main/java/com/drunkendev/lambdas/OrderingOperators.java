/*
 * OrderingOperators.java    Feb 3 2014, 04:53
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.reverse;
import static java.util.stream.Collectors.toList;


/**
 *
 * @author  Brett Ryan
 */
public class OrderingOperators {

    private final DomainService ds;

    /**
     * Creates a new {@code OrderingOperators} instance.
     */
    public OrderingOperators() {
        this.ds = new DomainService();
    }

    public static void main(String[] args) {
        OrderingOperators oo = new OrderingOperators();
        oo.lambda28();
        oo.lambda29();
        oo.lambda30();
        oo.lambda31();
        oo.lambda32();
        oo.lambda33();
        oo.lambda34();
        oo.lambda35();
        oo.lambda36();
        oo.lambda37();
        oo.lambda38();
        oo.lambda39();
    }

    public void lambda28() {
        System.out.println("\nThe sorted list of words:");
        String[] words = {"cherry", "apple", "blueberry"};
        Arrays.stream(words)
                .sorted()
                .forEach(System.out::println);
    }

    public void lambda29() {
        System.out.println("\nThe sorted list of words (by length):");
        String[] words = {"cherry", "apple", "blueberry"};
        Arrays.stream(words)
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }

    public void lambda30() {
        System.out.println("\nProducts ordered by name.");
        ds.getProductList().stream()
                .sorted(Comparator.comparing(Product::getProductName))
                .forEach(System.out::println);
    }

    public void lambda31() {
        System.out.println("\nThe sorted list of words (case insensitive):");
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        Arrays.stream(words)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);
    }

    public void lambda32() {
        System.out.println("\nThe doubles from highest to lowest:");
        double[] doubles = {1.7, 2.3, 1.9, 4.1, 2.9};
        Arrays.stream(doubles)
                .boxed()
                .sorted((d1, d2) -> -Double.compare(d1, d2))
                .forEach(System.out::println);
    }

    public void lambda33() {
        System.out.println("\nProducts sorted by units in stock:");
        ds.getProductList().stream()
                .sorted(Comparator.comparing(Product::getUnitsInStock))
                .forEach(System.out::println);
    }

    public void lambda34() {
        System.out.println("\nSorts words descending case insensitively:");
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        stream(words)
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .forEach(System.out::println);
    }

    public void lambda35() {
        System.out.println("\nSorts words by length then natural order.");
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        stream(digits)
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }

    public void lambda36() {
        System.out.println("\nSorts words by length then natural order ignoring case.");
        String[] words = {"aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry"};
        stream(words)
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    public void lambda37() {
        System.out.println("\nSorts product by category then descending unit price.");
        ds.getProductList().stream()
                .sorted(Comparator
                        .comparing(Product::getCategory)
                        .thenComparing(Product::getUnitPrice,
                                       (n1, n2) -> -n1.compareTo(n2))
                )
                .forEach(System.out::println);
    }

    public void lambda38() {
        System.out.println("\nSorts words by length then reverse case insensitive order.");
        String[] words = { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };
        stream(words)
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing((n1, n2) -> -String.CASE_INSENSITIVE_ORDER.compare(n1, n2)))
                .forEach(System.out::println);
    }

    public void lambda39() {
        System.out.println("\nA backwards list of the digits with a second character of 'i':");
        String[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        List<String> strings = stream(digits)
                .filter(d -> d.charAt(1) == 'i')
                .collect(toList());
        reverse(strings);
        strings.stream().forEach(System.out::println);
    }

}
