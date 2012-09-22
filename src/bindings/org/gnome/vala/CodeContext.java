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
 * The root of the code tree.
 * 
 * @author Severin Heiniger
 */
public class CodeContext extends Proxy
{

    protected CodeContext(long pointer) {
        super(pointer);
        ValaCodeContext.ref(this);
    }

    /**
     * Constructs a new code context.
     */
    public CodeContext() {
        this(ValaCodeContext.createCodeContext());
    }

    @Override
    protected void release() {
        ValaCodeContext.unref(this);
    }

    /**
     * Pushes the specified code context to the code context stack.
     */
    public static void push(CodeContext context) {
        ValaCodeContext.push(context);
    }

    public Namespace getRoot() {
        return ValaCodeContext.getRoot(this);
    }

    /**
     * Returns a copy of the list of source files.
     */
    @SuppressWarnings("unchecked")
    public List<SourceFile> getSourceFiles() {
        return ValaCodeContext.getSourceFiles(this);
    }

    /**
     * Pulls the specified package into the context. The method is tolerant if
     * the package has been already loaded.
     * 
     * @param pkg
     *            a package name
     * @return <code>false</code> if the package could not be loaded
     * 
     */
    public boolean addExternalPackage(String pkg) {
        return ValaCodeContext.addExternalPackage(this, pkg);
    }

    /**
     * Adds the specified source file to the context. Only .vala, .vapi, .gs,
     * and .c extensions are supported.
     * 
     * @param filename
     *            a filename
     * @param isSource
     *            true to force adding the file as .vala or .gs
     * @param cmdline
     *            true if the file came from the command line.
     * @return <code>false</code> if the file is not recognized or the file
     *         does not exist
     */
    public boolean addSourceFilename(String filename, boolean isSource, boolean cmdline) {
        return ValaCodeContext.addSourceFilename(this, filename, isSource, cmdline);
    }

    /**
     * Resolves and analyzes.
     */
    public void check() {
        ValaCodeContext.check(this);
    }

}
