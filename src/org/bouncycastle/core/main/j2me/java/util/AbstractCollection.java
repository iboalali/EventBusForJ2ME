package org.bouncycastle.core.main.j2me.java.util;

/**
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
public abstract class AbstractCollection
        implements Collection {
    protected AbstractCollection() {
    }

    public abstract Iterator iterator();

    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Object e = it.next();
            if (o == null) {
                if (e == null) {
                    return true;
                }
            } else {
                if (o.equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object[] toArray() {
        Object[] arObjects = new Object[size()];
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            arObjects[i++] = it.next();
        }
        return arObjects;
    }

    public Object[] toArray(Object[] a)
            throws NullPointerException, ArrayStoreException
    //TODO: Check if this is realy compatible to SUN!!!
    {
        if (a == null) {
            throw new NullPointerException();
        }

        if (isEmpty()) {
            return a;
        }
        Object[] arObjects = null;
        int size = size();
        if (a.length < size) {
            Iterator it = iterator();
            Object o = it.next();
            if (o == null) //no object or object is null
            {
                throw new ArrayStoreException(); //correct ?
            }
            throw new ArrayStoreException("please pass array of correct size");
        } else {
            arObjects = a;
            if (a.length > size) {
                arObjects[size] = null;
            }

        }

        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object o = it.next();
            arObjects[i++] = o;
        }
        return arObjects;
    }

    public boolean add(Object o)
            throws RuntimeException, NullPointerException, ClassCastException, IllegalArgumentException {
        throw new RuntimeException();
    }

    public boolean remove(Object o)
            throws RuntimeException {
        Iterator it = iterator();
        while (it.hasNext()) {
            Object e = it.next();
            if (o == null) {
                if (e == null) {
                    try {
                        it.remove();
                    } catch (RuntimeException ue) {
                        throw ue;
                    }
                    return true;
                }
            } else {
                if (o.equals(e)) {
                    try {
                        it.remove();
                    } catch (RuntimeException ue) {
                        throw ue;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsAll(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection c)
            throws RuntimeException {
        Iterator it = c.iterator();
        boolean ret = false;
        while (it.hasNext()) {
            try {
                ret |= add(it.next());
            } catch (RuntimeException ue) {
                throw ue;
            }
        }
        return ret;
    }

    public boolean removeAll(Collection c)
            throws RuntimeException {
        Iterator it = iterator();
        boolean ret = false;
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                try {
                    it.remove();
                    ret = true;
                } catch (RuntimeException ue) {
                    throw ue;
                }
            }
        }
        return ret;
    }

    public boolean retainAll(Collection c)
            throws RuntimeException {
        Iterator it = iterator();
        boolean ret = false;
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                try {
                    it.remove();
                    ret = true;
                } catch (RuntimeException ue) {
                    throw ue;
                }
            }
        }
        return ret;
    }

    public void clear()
            throws RuntimeException {
        Iterator it = iterator();
        while (it.hasNext()) {
            try {
                it.next();
                it.remove();
            } catch (RuntimeException ue) {
                throw ue;
            }
        }
    }

    public String toString() {
        StringBuffer ret = new StringBuffer("[");
        Iterator it = iterator();
        if (it.hasNext()) {
            ret.append(String.valueOf(it.next()));
        }
        while (it.hasNext()) {
            ret.append(", ");
            ret.append(String.valueOf(it.next()));

        }
        ret.append("]");
        return ret.toString();
    }

}
