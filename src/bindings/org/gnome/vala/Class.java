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

import java.util.Collections;

/**
 * Represents a class declaration in the source code.
 * 
 * @author Severin Heiniger
 */
public class Class extends ObjectTypeSymbol
{

    private java.util.List<CodeNode> nodes;

    protected Class(long pointer) {
        super(pointer);
    }

    /**
     * Creates a new class.
     * 
     * @param name
     *            type name
     * @param sourceReference
     *            reference to source code
     * @param comment
     *            class documentation
     * @return newly created class
     */
    public Class(String name, SourceReference sourceReference, Comment comment) {
        super(ValaClass.createClass(name, sourceReference, comment));
    }

    /**
     * Creates a new class with neither a source reference nor a comment.
     * 
     * @param name
     *            type name
     * @return newly created class
     */
    public Class(String name) {
        this(name, null, null);
    }

    /**
     * Returns whether this class is abstract. Abstract classes may not be
     * instantiated.
     */
    public boolean isAbstract() {
        return ValaClass.getIsAbstract(this);
    }

    /**
     * Sets whether this class is abstract. Abstract classes may not be
     * instantiated.
     */
    public void setAbstract(boolean isAbstract) {
        ValaClass.setIsAbstract(this, isAbstract);
    }

    /**
     * Returns a copy of the base type list.
     * 
     * @return list of base types
     */
    @SuppressWarnings("unchecked")
    public List<DataType> getBaseTypes() {
        return ValaClass.getBaseTypes(this);
    }

    /**
     * Returns the default construction method.
     */
    public Method getDefaultConstructionMethod() {
        return ValaClass.getDefaultConstructionMethod(this);
    }

    /**
     * Sets the default construction method.
     */
    public void setDefaultConstructionMethod(Method method) {
        ValaClass.setDefaultConstructionMethod(this, method);
    }

    /**
     * Returns a copy of the list of fields.
     * 
     * @return list of fields
     */
    @SuppressWarnings("unchecked")
    public List<Field> getFields() {
        return ValaClass.getFields(this);
    }

    /**
     * Returns the field with the given name, if any.
     * 
     * @param name
     *            the name of the field
     * @return <code>null</code> if there is no such field
     * @todo the method has a linear rather than a constant complexity
     */
    public Field getField(String name) {
        for (Field field : getFields()) {
            if (field.getName().equals(name)) {
                return field;
            }
        }
        return null;
    }

    /**
     * Returns the list of code nodes in this class, sorted by their location
     * in the source code.
     * 
     * @return the code nodes
     */
    public java.util.List<CodeNode> getNodes() {
        if (nodes == null) {
            nodes = new java.util.ArrayList<CodeNode>();
            nodes.addAll(getFields());
            nodes.addAll(getMethods());
            nodes.addAll(getSignals());
            nodes.addAll(getProperties());
            Collections.sort(nodes, CodeNodeLocationComparator.getInstance());
        }
        return nodes;
    }

    @Override
    public <R> R accept(CodeVisitor<R> visitor) {
        return visitor.visitClass(this);
    }

}
