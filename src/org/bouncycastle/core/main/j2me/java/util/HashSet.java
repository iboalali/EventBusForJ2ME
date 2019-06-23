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
public class HashSet
        extends AbstractSet {
    private HashMap m_HashMap = null;

    public HashSet() {
        m_HashMap = new HashMap();
    }

    public HashSet(Collection c) {
        m_HashMap = new HashMap(Math.max(11, c.size() * 2));
        addAll(c);
    }

    public HashSet(int initialCapacity) {
        m_HashMap = new HashMap(initialCapacity);

    }

    public Iterator iterator() {
        return (m_HashMap.keySet()).iterator();
    }

    public int size() {
        return m_HashMap.size();
    }

    public boolean contains(Object o) {
        return m_HashMap.containsKey(o);
    }

    public boolean add(Object o) {
        if (!m_HashMap.containsValue(o)) {
            m_HashMap.put((Object) o, (Object) o);

            return true;

        }

        return false;
    }

    public boolean remove(Object o) {
        return (m_HashMap.remove(o) != null);
    }

    public void clear() {
        m_HashMap.clear();
    }


    public Object clone() {
        HashSet hs = new HashSet();
        hs.m_HashMap = (HashMap) m_HashMap.clone();
        return hs;
    }

}
