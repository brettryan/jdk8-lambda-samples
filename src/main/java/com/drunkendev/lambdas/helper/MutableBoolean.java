/*
 * MutableBoolean.java    Feb 3 2014, 04:36
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

package com.drunkendev.lambdas.helper;


/**
 *
 * @author  Brett Ryan
 */
public class MutableBoolean {

    private boolean value;

    /**
     * Creates a new {@code MutableBoolean} instance.
     */
    public MutableBoolean() {
        this(false);
    }

    public MutableBoolean(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean isTrue() {
        return value;
    }

    public void flip() {
        this.value = !this.value;
    }

}
