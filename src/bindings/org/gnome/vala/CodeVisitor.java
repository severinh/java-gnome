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
 * Abstract code node visitor for traversing source code tree.
 * 
 * @author Severin Heiniger
 */
public interface CodeVisitor<R>
{

    /**
     * Visit operation called for source files.
     * 
     * @param sourceFile
     *            a source file
     */
    public R visitSourceFile(SourceFile sourceFile);

    /**
     * Visit operation called for namespaces.
     * 
     * @param namespace
     *            a namespace
     */
    public R visitNamespace(Namespace namespace);

    /**
     * Visit operation called for classes.
     * 
     * @param cls
     *            a class
     */
    public R visitClass(Class cls);

    /**
     * Visit operation called for structs.
     * 
     * @param struct
     *            a struct
     */
    public R visitStruct(Struct struct);

    /**
     * Visit operation called for interfaces.
     * 
     * @param iface
     *            an interface
     */
    public R visitInterface(Interface iface);

    /**
     * Visit operation called for enums.
     * 
     * @param enm
     *            an enum
     */
    public R visitEnum(Enum enm);

    /**
     * Visit operation called for enum values.
     * 
     * @param enumValue
     *            an enum value
     */
    public R visitEnumValue(EnumValue enumValue);

    /**
     * Visit operation called for delegates.
     * 
     * @param delegate
     *            a delegate
     */
    public R visitDelegate(Delegate delegate);

    /**
     * Visit operation called for constants.
     * 
     * @param constant
     *            a constant
     */
    public R visitConstant(Constant constant);

    /**
     * Visit operation called for fields.
     * 
     * @param field
     *            a field
     */
    public R visitField(Field field);

    /**
     * Visit operation called for methods.
     * 
     * @param method
     *            a method
     */
    public R visitMethod(Method method);

    /**
     * Visit operation called for creation methods.
     * 
     * @param method
     *            a method
     */
    public R visitCreationMethod(CreationMethod method);

    /**
     * Visit operation called for formal parameters.
     * 
     * @param parameter
     *            a formal parameter
     */
    public R visitParameter(Parameter parameter);

    /**
     * Visit operation called for properties.
     * 
     * @param property
     *            a property
     */
    public R visitProperty(Property property);

    /**
     * Visit operation called for signals.
     * 
     * @param signal
     *            a signal
     */
    public R visitSignal(Signal signal);

    /**
     * Visit operation called for type references.
     * 
     * @param dataType
     *            a type reference
     */
    public R visitDataType(DataType dataType);

    /**
     * Visit operation called for variables.
     * 
     * @param variable
     *            a variable
     */
    public R visitVariable(Variable variable);

    /**
     * Visit operation called for local variables.
     * 
     * @param localVariable
     *            a local variable
     */
    public R visitLocalVariable(LocalVariable localVariable);

    /**
     * Visit operations called for expressions.
     * 
     * @param expression
     *            an expression
     */
    public R visitExpression(Expression expression);

}
