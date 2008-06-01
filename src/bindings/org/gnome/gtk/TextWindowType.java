/*
 * TextWindowType.java
 *
 * Copyright (c) 2007-2008 Operational Dynamics Consulting Pty Ltd
 *
 * The code in this file, and the library it is a part of, are made available
 * to you by the authors under the terms of the "GNU General Public Licence,
 * version 2" plus the "Classpath Exception" (you may link to this code as a
 * library into other programs provided you don't make a derivation of it).
 * See the LICENCE file for the terms governing usage and redistribution.
 */
package org.gnome.gtk;

import org.freedesktop.bindings.Constant;

/**
 * Each TextView is actually composed from a number of underlying
 * [org.gnome.gdk] Windows. In addition to the core one where the text entry
 * happens, there are a number of optional Windows which can be used as side
 * panels. This class specifies constants identifying these underlying
 * resources.
 * 
 * <b>These border Windows are an obscure, advanced, and not wholly functional
 * feature of GTK.</b>
 * 
 * <p>
 * The accompanying illustration is a TextView with each border window
 * specified to a width of 50 pixels and a Label placed at <i>window
 * co-ordinates</i> <code>0</code>,<code>0</code> in each one. <img
 * class="snapshot" src="TextView-BorderWindows.png">
 * 
 * Code to create this snapshot consisted of a series of calls like:
 * 
 * <pre>
 * left = new Label(&quot;LEFT&quot;);
 * view.setBorderWindowSize(TextWindowType.LEFT, 50);
 * view.addChildInWindow(left, TextWindowType.LEFT, 0, 0);
 * </pre>
 * 
 * one for each side. Note the positions and relative sizes of the scrollbars
 * added by the ScrolledWindow into which the TextView was placed. As you can
 * see, only the left border window one makes very much sense, as it could be
 * used for things like breakpoint annotations in a programming editor.
 * 
 * <p>
 * <i>By all accounts, this feature is still evolving in GTK; it is entirely
 * possible that it was not completely implemented in the first place, and in
 * any case the interface for using it seems ... unsteady. We have included
 * this in java-gnome largely because we had already gone to all the work of
 * exposing it only to discover that it is exceedingly hard to use and
 * somewhat buggy. Hopefully GTK will improve, but if you use this, expect the
 * behaviour to be somewhat unpredictable.</i>
 * 
 * @author Andrew Cowie
 * @since 4.0.8
 */
public final class TextWindowType extends Constant
{
    private TextWindowType(int ordinal, String nickname) {
        super(ordinal, nickname);
    }

    /**
     * The optional border Window on the left hand side of a TextView. This is
     * the interesting one, as you can use it to place annotations relating to
     * the line of text being shown in the TextView beside it. Tying this to
     * scrolling (if enabled) is <b>very</b> tricky, though. See FIXME for an
     * example.
     * 
     * @since 4.0.8
     */
    public static TextWindowType LEFT = new TextWindowType(GtkTextWindowType.LEFT, "LEFT");

    /**
     * The optional border Window on the left hand side of a TextView.
     * 
     * @since 4.0.8
     */
    public static TextWindowType RIGHT = new TextWindowType(GtkTextWindowType.RIGHT, "RIGHT");

    /**
     * The optional border Window above a TextView.
     * 
     * @since 4.0.8
     */
    public static TextWindowType TOP = new TextWindowType(GtkTextWindowType.TOP, "TOP");

    /**
     * The optional border Window below a TextView.
     * 
     * @since 4.0.8
     */
    public static TextWindowType BOTTOM = new TextWindowType(GtkTextWindowType.BOTTOM, "BOTTOM");

    /*
     * There are several more!
     */
}
