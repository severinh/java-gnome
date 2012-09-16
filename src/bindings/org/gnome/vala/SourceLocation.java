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

import org.gnome.glib.Boxed;

/**
 * Represents a location in a Vala source or VAPI package file.
 * 
 * @author Severin Heiniger
 */
public class SourceLocation extends Boxed
{

    protected SourceLocation(long pointer) {
        super(pointer);
    }

    /**
     * Constructs a new source location given a line and a column number.
     * 
     * @param line
     *            the line number, starting at 0
     * @param column
     *            the column number, starting at 0
     */
    public SourceLocation(int line, int column) {
        super(ValaSourceLocationOverride.createSourceLocation(line, column));
        if (line < 0) {
            throw new IllegalArgumentException("line cannot be negative, got " + line);
        }
        if (column < 0) {
            throw new IllegalArgumentException("column cannot be negative, got " + column);
        }
    }

    public SourceLocation() {
        this(0, 0);
    }

    @Override
    protected void release() {
        ValaSourceLocationOverride.free(this);
    }

    /**
     * Returns the line number in the source file.
     */
    public int getLine() {
        return ValaSourceLocation.getLine(this);
    }

    /**
     * Returns the column number in the source file.
     */
    public int getColumn() {
        return ValaSourceLocation.getColumn(this);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + getLine();
        hash = hash * 31 + getColumn();
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!(other instanceof SourceLocation)) {
            return false;
        }
        SourceLocation otherLocation = (SourceLocation) other;
        boolean result = getLine() == otherLocation.getLine()
                && getColumn() == otherLocation.getColumn();
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + getLine() + " : " + getColumn();
    }

}
