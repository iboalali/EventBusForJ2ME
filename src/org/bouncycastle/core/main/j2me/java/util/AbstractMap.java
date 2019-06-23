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

public abstract class AbstractMap
        implements Map {

    protected AbstractMap() {
    }

    public int size() {
        return entrySet().size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsValue(Object value) {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry v = (Map.Entry) it.next();
            if (value == null) {
                if (v.getValue() == null) {
                    return true;
                }
            } else {
                if (value.equals(v.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsKey(Object key)
            throws ClassCastException, NullPointerException {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry v = (Map.Entry) it.next();
            if (key == null) {
                if (v.getKey() == null) {
                    return true;
                }
            } else {
                if (key.equals(v.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object get(Object key)
            throws ClassCastException, NullPointerException {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry v = (Map.Entry) it.next();
            if (key == null) {
                if (v.getKey() == null) {
                    return v.getValue();
                }
            } else {
                if (key.equals(v.getKey())) {
                    return v.getValue();
                }
            }
        }
        return null;
    }

    public Object put(Object key, Object value)
            throws RuntimeException {
        throw new RuntimeException();
    }

    public Object remove(Object key) {
        Iterator it = entrySet().iterator();
        Object o = null;
        while (it.hasNext()) {
            Map.Entry v = (Map.Entry) it.next();
            if (key == null) {
                if (v.getKey() == null) {
                    o = v.getValue();
                    it.remove();
                    return o;
                }
            } else {
                if (key.equals(v.getKey())) {
                    o = v.getValue();
                    it.remove();
                    return o;
                }
            }
        }
        return null;
    }

    public void putAll(Map t) {
        Iterator it = t.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry v = (Map.Entry) it.next();
            put(v.getKey(), v.getValue());
        }
    }

    public void clear() {
        entrySet().clear();
    }

    public Set keySet() {
        throw new RuntimeException("no keySet in AbstractMap()");
    }

    public Collection values() {
        throw new RuntimeException("no values in AbstractMap()");
    }

    public abstract Set entrySet();

    public boolean equals(Object o) {
        throw new RuntimeException("no equals in AbstractMap()");
    }

    public int hashCode() {
        throw new RuntimeException("no hashCode in AbstractMap()");
    }

    public String toString() {
        throw new RuntimeException("no toString in AbstractMap()");
    }


}
