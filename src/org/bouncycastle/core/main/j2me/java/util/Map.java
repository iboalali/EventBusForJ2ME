/*
 * Copyright (c) 2000-2019 The Legion of the Bouncy Castle Inc. (http://www.bouncycastle.org)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package org.bouncycastle.core.main.j2me.java.util;

public interface Map {

    public static interface Entry {
        public Object getKey();

        public Object getValue();

        public Object setValue(Object value)
                throws RuntimeException, ClassCastException, IllegalArgumentException, NullPointerException;

        public boolean equals(Object o);

        public int hashCode();
    }

    public int size();

    public boolean isEmpty();

    public boolean containsKey(Object Key)
            throws ClassCastException, NullPointerException;

    public boolean containsValue(Object value);

    public Object get(Object key)
            throws ClassCastException, NullPointerException;

    public Object put(Object key, Object value)
            throws RuntimeException, ClassCastException, IllegalArgumentException, NullPointerException;

    public Object remove(Object key)
            throws RuntimeException;

    public void putAll(Map t)
            throws RuntimeException, ClassCastException, IllegalArgumentException, NullPointerException;

    public void clear()
            throws RuntimeException;

    public Set keySet();

    public Collection values();

    public Set entrySet();

    public boolean equals(Object o);

    public int hashCode();

}
