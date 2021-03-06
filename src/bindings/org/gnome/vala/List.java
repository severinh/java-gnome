/*
 * java-gnome, a UI library for writing GTK and GNOME programs from Java!
 *
 * Copyright © 2008-2010 Operational Dynamics Consulting, Pty Ltd
 *
 * The code in this file, and the program it is a part of, is made available
 * to you by its authors as open source software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License version
 * 2 ("GPL") as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GPL for more details.
 *
 * You should have received a copy of the GPL along with this program. If not,
 * see http://www.gnu.org/licenses/. The authors of this program may be
 * contacted through http://java-gnome.sourceforge.net/.
 *
 * Linking this library statically or dynamically with other modules is making
 * a combined work based on this library. Thus, the terms and conditions of
 * the GPL cover the whole combination. As a special exception (the
 * "Classpath Exception"), the copyright holders of this library give you
 * permission to link this library with independent modules to produce an
 * executable, regardless of the license terms of these independent modules,
 * and to copy and distribute the resulting executable under terms of your
 * choice, provided that you also meet, for each linked independent module,
 * the terms and conditions of the license of that module. An independent
 * module is a module which is not derived from or based on this library. If
 * you modify this library, you may extend the Classpath Exception to your
 * version of the library, but you are not obligated to do so. If you do not
 * wish to do so, delete this exception statement from your version.
 */
package org.gnome.vala;

import java.util.ListIterator;

import org.freedesktop.bindings.Proxy;

/**
 * Represents a collection of items in a well-defined order.
 * 
 * @author Severin Heiniger
 */
public abstract class List<T extends Proxy> extends Collection<T> implements java.util.List<T>
{

    protected List(long pointer) {
        super(pointer);
    }

    public void add(int arg0, T arg1) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public boolean addAll(java.util.Collection<? extends T> arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public boolean addAll(int arg0, java.util.Collection<? extends T> arg1) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public boolean containsAll(java.util.Collection<?> arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public T get(int index) {
        return ValaListOverride.get(this, index);
    }

    public int indexOf(Object arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int lastIndexOf(Object arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public ListIterator<T> listIterator(int arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public T remove(int arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public boolean removeAll(java.util.Collection<?> arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public boolean retainAll(java.util.Collection<?> arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public T set(int arg0, T arg1) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public java.util.List<T> subList(int arg0, int arg1) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public Object[] toArray() {
        Object[] result = new Object[size()];
        for (int index = 0; index < size(); index++) {
            result[index] = get(index);
        }
        return result;
    }

    public <S> S[] toArray(S[] arg0) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String toString() {
        java.util.List<T> javaList = new java.util.ArrayList<T>(this);
        return javaList.toString();
    }

}
