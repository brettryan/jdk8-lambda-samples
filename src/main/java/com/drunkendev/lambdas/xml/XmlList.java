/*
 * XmlList.java    Feb 2 2014, 02:00
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;


/**
 * Helper class for collections to be serialized with JAXB.
 *
 * <p>Implementors of this class should use the following pattern.</p>
 *
 * <pre>
 *
 *     &#64;XmlRootElement(name = "myDataList")
 *     public static final class MyDataXmlList
 *             extends XmlList&lt;MyData&gt; {
 *
 *         &#64;XmlElement(name = "myData")
 *         public List&lt;MyData&gt; getMyDataList() {
 *             return getList();
 *         }
 *
 *     }
 * </pre>
 *
 * @param   <T>
 *          Type for encapsulated list.
 * @author  Brett Ryan
 */
@XmlTransient
public class XmlList<T> {

    private List<T> list;

    /**
     * Creates a new {@code XmlList} instance.
     */
    public XmlList() {
    }

    public XmlList(Collection<T> list) {
        this.list = new ArrayList<>(list);
    }

    public static <ListType extends XmlList<EntType>, EntType> ListType newInstance(
            Class<ListType> clazz,
            Collection<EntType> elms) {
        try {
            ListType lt = (ListType) clazz.newInstance();
            lt.getList().addAll(elms);
            return lt;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected List<T> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

}
