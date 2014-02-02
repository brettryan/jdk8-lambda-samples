/*
 * GroupingOperators.java    Feb 3 2014, 05:55
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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


/**
 *
 * @author  Brett Ryan
 */
public class GroupingOperators {

    private final DomainService ds;

    /**
     * Creates a new {@code GroupingOperators} instance.
     */
    public GroupingOperators() {
        this.ds = new DomainService();
    }

    public static void main(String[] args) {
        GroupingOperators go = new GroupingOperators();
        go.lambda40();
        go.lambda41();
        go.lambda42();
        go.lambda43();
        go.lambda44();
        go.lambda45();
    }

    public void lambda40() {
        int[] numbers = {5, 4, 1, 3, 9, 8, 6, 7, 2, 0};
        Map<Integer, List<Integer>> map = stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(n -> n % 5));
        for (Entry<Integer, List<Integer>> ent : map.entrySet()) {
            System.out.println(String.format(
                    "Numbers with a remainder of %d when divided by 5:", ent.getKey()));
            ent.getValue().stream().forEach(System.out::println);
        }
    }

    public void lambda41() {
    }

    public void lambda42() {
    }

    public void lambda43() {
    }

    public void lambda44() {
    }

    public void lambda45() {
    }

}
