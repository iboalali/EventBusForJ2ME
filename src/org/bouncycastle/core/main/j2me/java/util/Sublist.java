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
public class Sublist
        extends AbstractList {
    AbstractList m_al = null;
    int m_fromIndex = 0;
    int m_toIndex = 0;
    int size = 0;

    public Sublist(AbstractList ali, int fromIndex, int toIndex) {
        m_al = ali;
        m_toIndex = toIndex;
        m_fromIndex = fromIndex;
        size = size();
    }

    public Object set(int index, Object o) {
        if (index < size) {
            o = m_al.set(index + m_fromIndex, o);
            if (o != null) {
                size++;
                m_toIndex++;
            }
            return o;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object get(int index)
            throws IndexOutOfBoundsException {
        if (index < size) {
            return m_al.get(index + m_fromIndex);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(int index, Object o) {

        if (index <= size) {
            m_al.add(index + m_fromIndex, o);
            m_toIndex++;
            size++;

        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public Object remove(int index, Object o) {
        if (index < size) {
            Object ob = m_al.remove(index + m_fromIndex);
            if (ob != null) {
                m_toIndex--;
                size--;
            }
            return ob;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean addAll(int index, Collection c) {
        if (index < size) {
            boolean bool = m_al.addAll(index + m_fromIndex, c);
            if (bool) {
                int lange = c.size();
                m_toIndex = m_toIndex + lange;
                size = size + lange;
            }
            return bool;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean addAll(Collection c) {
        boolean bool = m_al.addAll(m_toIndex, c);
        if (bool) {
            int lange = c.size();
            m_toIndex = m_toIndex + lange;
            size = size + lange;
        }
        return bool;
    }

    public void removeRange(int from, int to) {
        if ((from <= to) && (from <= size) && (to <= size)) {
            m_al.removeRange(from, to);
            int lange = to - from;
            m_toIndex = m_toIndex - lange;
            size = size - lange;
        } else {
            if (from > to) {
                throw new IllegalArgumentException();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public int size() {
        return (m_toIndex - m_fromIndex);
    }
}
