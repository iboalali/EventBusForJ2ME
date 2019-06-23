package org.bouncycastle.core.main.j2me.java.util;

import java.util.Vector;

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
public class ArrayList extends AbstractList
        implements List {
    Vector m_Vector = null;

    public ArrayList() {
        m_Vector = new Vector();
    }

    public ArrayList(Collection c) {
        m_Vector = new Vector((int) (c.size() * 1.1));
        addAll(c);
    }

    public ArrayList(int initialCapacity) {
        m_Vector = new Vector(initialCapacity);
    }

    public void trimToSize() {
        m_Vector.trimToSize();
    }

    public void ensureCapacity(int minCapacity) {
        m_Vector.ensureCapacity(minCapacity);
    }

    public int size() {
        return m_Vector.size();
    }

    public boolean contains(Object elem) {
        return m_Vector.contains(elem);
    }

    public int indexOf(Object elem) {
        return m_Vector.indexOf(elem);
    }

    public int lastIndexOf(Object elem) {
        return m_Vector.lastIndexOf(elem);
    }

    public Object clone() {
        ArrayList al = new ArrayList(this);

        return al;
    }

    public Object[] toArray() {
        Object[] o = new Object[m_Vector.size()];
        m_Vector.copyInto(o);
        return o;
    }

    public Object get(int index) {
        return m_Vector.elementAt(index);
    }

    public Object set(int index, Object elem) {
        Object o = m_Vector.elementAt(index);
        m_Vector.setElementAt(elem, index);
        return o;
    }

    public boolean add(Object o) {
        m_Vector.addElement(o);
        return true;
    }

    public void add(int index, Object elem) {
        m_Vector.insertElementAt(elem, index);
    }

    public Object remove(int index) {
        Object o = m_Vector.elementAt(index);
        m_Vector.removeElementAt(index);
        return o;
    }

    public void clear() {
        m_Vector.removeAllElements();
    }


}
