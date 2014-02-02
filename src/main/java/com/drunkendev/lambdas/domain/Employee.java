/*
 * Employee.java    Feb 2 2014, 18:43
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


/**
 *
 * @author  Brett Ryan
 */
public class Employee {

    private final int id;
    private final String name;
    private final int workLevel;

    /**
     * Creates a new {@code Employee} instance.
     *
     * @param   id
     *          Employee ID
     * @param   name
     *          Employee name.
     * @param   workLevel
     *          Work level.
     */
    public Employee(int id, String name, int workLevel) {
        this.id = id;
        this.name = name;
        this.workLevel = workLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWorkLevel() {
        return workLevel;
    }

}
