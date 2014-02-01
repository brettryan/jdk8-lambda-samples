/*
 * CustomerList.java    Feb 2 2014, 01:59
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

import com.drunkendev.lambdas.xml.XmlList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author  Brett Ryan
 */
@XmlRootElement(name = "customers")
public class CustomerList extends XmlList<Customer> {

    @XmlElement(name = "customer")
    public List<Customer> getCustomers() {
        return getList();
    }

}
