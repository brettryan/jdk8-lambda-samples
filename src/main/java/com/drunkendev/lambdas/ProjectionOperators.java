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
        po.lambda6();
        po.lambda7();
        po.lambda8();
        po.lambda9();
        po.lambda10();
    }

    public void lambda6() {
        System.out.println("\nNumbers + 1:");
        List<Integer> numbers = Arrays.asList(5, 4, 1, 3, 9, 8, 6, 7, 2, 0);
        numbers.stream()
                .map(n -> ++n)
                .forEach(System.out::println);
    }

    public void lambda7() {
        System.out.println("\nProduct Names:");
        ds.getProductList().stream()
                .map(Product::getProductName)
                .forEach(System.out::println);
    }

    public void lambda8() {
        System.out.println("\nNumbers + 1:");
        List<Integer> numbers = Arrays.asList(5, 4, 1, 3, 9, 8, 6, 7, 2, 0);
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        numbers.stream()
                .map(n -> strings[n])
                .forEach(System.out::println);
    }

    public void lambda9() {
        String[] words = {"aPPLE", "BlUeBeRrY", "cHeRry"};
        Arrays.stream(words)
                .forEach(n -> System.out.println(String.format(
                                        "Uppercase: %s, Lowercase: %s",
                                        n.toUpperCase(), n.toLowerCase())));
    }

    public void lambda10() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Arrays.stream(numbers)
                .forEach(n -> System.out.println(String.format(
                                        "The digit %s is %s.",
                                        strings[n], n % 2 == 0 ? "even" : "odd")));
    }

}
