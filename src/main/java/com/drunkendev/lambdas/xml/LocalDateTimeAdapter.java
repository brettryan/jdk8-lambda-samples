/*
 * LocalDateTimeAdapter.java    Feb 2 2014, 02:48
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

package com.drunkendev.lambdas.xml;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 *
 * @author  Brett Ryan
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public String marshal(LocalDateTime value) throws Exception {
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    @Override
    public LocalDateTime unmarshal(String s) throws Exception {
        return s == null || s.length() == 0 ? null : LocalDateTime.parse(s);
    }

}
