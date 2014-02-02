/*
 * PartitioningOperators.java    Feb 3 2014, 03:44
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
import com.drunkendev.lambdas.domain.Order;
import com.drunkendev.lambdas.helper.IndexHolder;
import com.drunkendev.lambdas.helper.MutableBoolean;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author  Brett Ryan
 */
public class PartitioningOperators {

    private final DomainService ds;

    /**
     * Creates a new {@code PartitioningOperators} instance.
     */
    public PartitioningOperators() {
        this.ds = new DomainService();
    }

    public static void main(String[] args) {
        PartitioningOperators po = new PartitioningOperators();
        po.lambda20();
        po.lambda21();
        po.lambda22();
        po.lambda23();
        po.lambda24();
        po.lambda25();
        po.lambda26();
        po.lambda27();
    }

    public void lambda20() {
        System.out.println("\nFirst 3 numbers:");
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Arrays.stream(numbers)
                .limit(3)
                .forEach(System.out::println);
    }

    public void lambda21() {
        System.out.println("\nFirst 3 orders in WA:");
        ds.getCustomerList().stream()
                .filter(c -> "WA".equalsIgnoreCase(c.getRegion()))
                .flatMap(c -> c.getOrders().stream()
                        .map(n -> new CustOrder(c.getCustomerId(), n))
                ).limit(3)
                .forEach(System.out::println);
    }

    public void lambda22() {
        System.out.println("\nAll but first 4 numbers:");
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Arrays.stream(numbers)
                .skip(4)
                .forEach(System.out::println);
    }

    public void lambda23() {
        System.out.println("\nAll but first 2 orders in WA:");
        ds.getCustomerList().stream()
                .filter(c -> "WA".equalsIgnoreCase(c.getRegion()))
                .flatMap(c -> c.getOrders().stream()
                        .map(n -> new CustOrder(c.getCustomerId(), n))
                ).skip(2)
                .forEach(System.out::println);
    }

    /**
     * Unfortunately this method will not short circuit and will continue to
     * iterate until the end of the stream. I need to figure out a better way to
     * handle this.
     */
    public void lambda24() {
        System.out.println("\nFirst numbers less than 6:");
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        MutableBoolean mb = new MutableBoolean(true);
        Arrays.stream(numbers)
                .collect(ArrayList<Integer>::new,
                         (output, v) -> {
                             if (mb.isTrue()) {
                                 if (v < 6) {
                                     output.add(v);
                                 } else {
                                     mb.flip();
                                 }
                             }
                         },
                         (c1, c2) -> c1.addAll(c2))
                .forEach(System.out::println);
    }

    public void lambda25() {
        System.out.println("\nFirst numbers not less than their position:");
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        IndexHolder i = new IndexHolder();
        MutableBoolean mb = new MutableBoolean(true);
        Arrays.stream(numbers)
                .collect(ArrayList<Integer>::new,
                         (output, v) -> {
                             if (mb.isTrue()) {
                                 if (v > i.postIncrement()) {
                                     output.add(v);
                                 } else {
                                     mb.flip();
                                 }
                             }
                         },
                         (c1, c2) -> c1.addAll(c2))
                .forEach(System.out::println);
    }

    public void lambda26() {
        System.out.println("\nAll elements starting from first element divisible by 3:");
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        MutableBoolean mb = new MutableBoolean(false);
        Arrays.stream(numbers)
                .collect(ArrayList<Integer>::new,
                         (output, v) -> {
                             if (mb.isTrue()) {
                                 output.add(v);
                             } else if (v % 3 == 0) {
                                 output.add(v);
                                 mb.flip();
                             }
                         },
                         (c1, c2) -> c1.addAll(c2))
                .forEach(System.out::println);
    }

    public void lambda27() {
        System.out.println("\nAll elements starting from first element less than its position:");
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        IndexHolder i = new IndexHolder();
        MutableBoolean mb = new MutableBoolean(false);
        Arrays.stream(numbers)
                .collect(ArrayList<Integer>::new,
                         (output, v) -> {
                             if (mb.isTrue()) {
                                 output.add(v);
                             } else if (v < i.postIncrement()) {
                                 output.add(v);
                                 mb.flip();
                             }
                         },
                         (c1, c2) -> c1.addAll(c2)
                )
                .forEach(System.out::println);
    }


    private static class CustOrder {

        private final String customerId;
        private final Order order;

        public CustOrder(String customerId, Order order) {
            this.customerId = customerId;
            this.order = order;
        }

        public String getCustomerId() {
            return customerId;
        }

        public Order getOrder() {
            return order;
        }

        @Override
        public String toString() {
            return String.format("CustOrder[customerId=%s,orderId=%d,orderDate=%s]",
                                 customerId, order.getOrderId(), order.getOrderDate());
        }

    }

}
