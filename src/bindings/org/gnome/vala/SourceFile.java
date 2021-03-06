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

import org.freedesktop.bindings.Proxy;

/**
 * Represents a Vala source or VAPI package file.
 * 
 * @author Severin Heiniger
 */
public class SourceFile extends Proxy
{

    private java.util.List<Class> classes = null;

    private java.util.List<Interface> interfaces = null;

    private java.util.List<Enum> enums = null;

    private java.util.List<Method> methods = null;

    protected SourceFile(long pointer) {
        super(pointer);
        ValaSourceFile.ref(this);
    }

    public SourceFile(CodeContext context, SourceFileType type, String filename, String content,
            boolean cmdline) {
        this(ValaSourceFile.createSourceFile(context, type, filename, content, cmdline));
    }

    @Override
    protected void release() {
        ValaSourceFile.unref(this);
    }

    /**
     * Returns the name of this source file.
     */
    public String getFilename() {
        return ValaSourceFile.getFilename(this);
    }

    /**
     * Sets the name of this source file.
     */
    public void setFilename(String filename) {
        ValaSourceFile.setFilename(this, filename);
    }

    /**
     * Returns a copy of the list of code nodes.
     */
    @SuppressWarnings("unchecked")
    public java.util.List<CodeNode> getNodes() {
        return ValaSourceFile.getNodes(this);
    }

    /**
     * Returns the list of classes in this source file.
     */
    public java.util.List<Class> getClasses() {
        if (classes == null) {
            classes = new java.util.ArrayList<Class>();
            for (CodeNode codeNode : getNodes()) {
                if (codeNode instanceof Class) {
                    classes.add((Class) codeNode);
                }
            }
        }
        return classes;
    }

    /**
     * Returns an class in this source file, given its name.
     * 
     * @param name
     *            the name of the class
     * @return the class with the given name, or <code>null</code> if no such
     *         class could be found
     */
    public Class getClass(String name) {
        for (Class cls : getClasses()) {
            if (cls.getName().equals(name)) {
                return cls;
            }
        }
        return null;
    }

    /**
     * Returns the list of classes in this source file.
     */
    public java.util.List<Interface> getInterfaces() {
        if (interfaces == null) {
            interfaces = new java.util.ArrayList<Interface>();
            for (CodeNode codeNode : getNodes()) {
                if (codeNode instanceof Interface) {
                    interfaces.add((Interface) codeNode);
                }
            }
        }
        return interfaces;
    }

    /**
     * Returns an interface in this source file, given its name.
     * 
     * @param name
     *            the name of the interface
     * @return the interface with the given name, or <code>null</code> if no
     *         such interface could be found
     */
    public Interface getInterface(String name) {
        for (Interface iface : getInterfaces()) {
            if (iface.getName().equals(name)) {
                return iface;
            }
        }
        return null;
    }

    /**
     * Returns the list of enums in this source file.
     */
    public java.util.List<Enum> getEnums() {
        if (enums == null) {
            enums = new java.util.ArrayList<Enum>();
            for (CodeNode codeNode : getNodes()) {
                if (codeNode instanceof Enum) {
                    enums.add((Enum) codeNode);
                }
            }
        }
        return enums;
    }

    /**
     * Returns an enum in this source file, given its name.
     * 
     * @param name
     *            the name of the enum
     * @return the enum with the given name, or <code>null</code> if no such
     *         enum could be found
     */
    public Enum getEnum(String name) {
        for (Enum enm : getEnums()) {
            if (enm.getName().equals(name)) {
                return enm;
            }
        }
        return null;
    }

    /**
     * Returns the list of methods in this source file.
     */
    public java.util.List<Method> getMethods() {
        if (methods == null) {
            methods = new java.util.ArrayList<Method>();
            for (CodeNode codeNode : getNodes()) {
                if (codeNode instanceof Method) {
                    methods.add((Method) codeNode);
                }
            }
        }
        return methods;
    }

    /**
     * Returns an method in this source file, given its name.
     * 
     * @param name
     *            the name of the method
     * @return the method with the given name, or <code>null</code> if no such
     *         method could be found
     */
    public Method getMethod(String name) {
        for (Method method : getMethods()) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        return null;
    }

    public <R> R accept(CodeVisitor<R> visitor) {
        return visitor.visitSourceFile(this);
    }

    @Override
    public String toString() {
        return "SourceFile[filename=" + getFilename() + "]";
    }

}
