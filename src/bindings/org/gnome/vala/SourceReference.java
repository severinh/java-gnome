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
 * Represents a reference to a location in a source file.
 * 
 * @author Severin Heiniger
 */
public class SourceReference extends Proxy
{

    protected SourceReference(long pointer) {
        super(pointer);
        ValaSourceReference.ref(this);
    }

    public SourceReference(SourceFile file, SourceLocation begin, SourceLocation end) {
        this(ValaSourceReference.createSourceReference(file, begin, end));
    }

    @Override
    protected void release() {
        ValaSourceReference.unref(this);
    }

    /**
     * Returns the source file to be referenced.
     */
    public SourceFile getSourceFile() {
        return ValaSourceReference.getFile(this);
    }

    private SourceLocation begin;

    /**
     * Returns the begin of the referenced source code.
     */
    public SourceLocation getBegin() {
        if (begin == null) {
            begin = new SourceLocation();
        }
        ValaSourceReferenceOverride.getBegin(this, begin);
        return begin;
    }

    private SourceLocation end;

    /**
     * Returns the end of the referenced source code.
     */
    public SourceLocation getEnd() {
        if (end == null) {
            end = new SourceLocation();
        }
        ValaSourceReferenceOverride.getEnd(this, end);
        return end;
    }

    /**
     * Returns the content between {@link #getBegin()} and {@link #getEnd()}.
     */
    public String getContent() {
        return ValaSourceReferenceOverride.getContent(this);
    }

    @Override
    public String toString() {
        return ValaSourceReference.toString(this);
    }

}
