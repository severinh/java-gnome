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

/**
 * Represents a runtime data type for objects and interfaces. This data type
 * may be defined in Vala source code or imported from an external library
 * with a Vala API file.
 * 
 * @author Severin Heiniger
 */
public abstract class ObjectTypeSymbol extends TypeSymbol
{

    protected ObjectTypeSymbol(long pointer) {
        super(pointer);
    }

    /**
     * Returns a copy of the list of methods.
     * 
     * @return list of methods
     */
    @SuppressWarnings("unchecked")
    public List<Method> getMethods() {
        return ValaObjectTypeSymbol.getMethods(this);
    }

    /**
     * Returns the method with the given name, if any.
     * 
     * @param name
     *            the name of the method
     * @return <code>null</code> if there is no such method
     * @todo the method has a linear rather than a constant complexity
     */
    public Method getMethod(String name) {
        for (Method method : getMethods()) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        return null;
    }

    /**
     * Returns a copy of the list of signals.
     * 
     * @return list of signals
     */
    @SuppressWarnings("unchecked")
    public List<Signal> getSignals() {
        return ValaObjectTypeSymbol.getSignals(this);
    }

    /**
     * Returns the signal with the given name, if any.
     * 
     * @param name
     *            the name of the signal
     * @return <code>null</code> if there is no such signal
     * @todo the method has a linear rather than a constant complexity
     */
    public Signal getSignal(String name) {
        for (Signal signal : getSignals()) {
            if (signal.getName().equals(name)) {
                return signal;
            }
        }
        return null;
    }

    /**
     * Returns a copy of the list of properties.
     * 
     * @return list of properties
     */
    @SuppressWarnings("unchecked")
    public List<Property> getProperties() {
        return ValaObjectTypeSymbol.getProperties(this);
    }

    /**
     * Returns the property with the given name, if any.
     * 
     * @param name
     *            the name of the property
     * @return <code>null</code> if there is no such property
     * @todo the method has a linear rather than a constant complexity
     */
    public Property getProperty(String name) {
        for (Property property : getProperties()) {
            if (property.getName().equals(name)) {
                return property;
            }
        }
        return null;
    }

}
