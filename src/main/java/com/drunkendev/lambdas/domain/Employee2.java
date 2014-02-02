/*
 * Employee2.java    Feb 2 2014, 18:48
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
public class Employee2 {

    private final int id;
    private final String lastName;
    private final int level;

    /**
     * Creates a new {@code Employee2} instance.
     *
     * @param   id
     *          Employee ID
     * @param   lastName
     *          Employee last name.
     * @param   level
     *          Level.
     */
    public Employee2(int id, String lastName, int level) {
        this.id = id;
        this.lastName = lastName;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public int getLevel() {
        return level;
    }

}
