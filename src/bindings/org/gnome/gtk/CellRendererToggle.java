/*
 * CellRendererToggle.java
 *
 * Copyright (c) 2007-2008 Operational Dynamics Consulting Pty Ltd, and Others
 *
 * The code in this file, and the library it is a part of, are made available
 * to you by the authors under the terms of the "GNU General Public Licence,
 * version 2" plus the "Classpath Exception" (you may link to this code as a
 * library into other programs provided you don't make a derivation of it).
 * See the LICENCE file for the terms governing usage and redistribution.
 */
package org.gnome.gtk;

/**
 * Renders a Toggle Button into a TreeViewColumn. This CellRenderer may be
 * used to present boolean data to the user. The fundamental mapping method is
 * {@link #setActive(DataColumnBoolean) setActive()} which you use to indicate
 * the particular DataColumnBoolean from the underlying TreeModel which will
 * provide the boolean values.
 * 
 * @author Andreas Kuehntopf
 * @since 4.0.8
 */
public class CellRendererToggle extends CellRenderer
{
    /**
     * Construct a new CellRendererToggle. Specify the TreeViewColumn it will
     * belong to.
     * 
     * @since 4.0.8
     */
    public CellRendererToggle(TreeViewColumn vertical) {
        // FIXME does expand to false actually make sense?
        super(GtkCellRendererToggle.createCellRendererToggle(), vertical, false);
    }

    /**
     * Indicate the appearance of this CellRenderer. If this is set to true a
     * radio button is used instead of the default check box.
     * 
     * @since 4.0.8
     */
    public void setRadio(boolean radio) {
        GtkCellRendererToggle.setRadio(this, true);
    }

    /**
     * Indicate if the CellRenderer's toggle button should be active.
     * 
     * <p>
     * If you want to bind the state of the toggle button to a DataColumn you
     * might want to use the overloaded method
     * {@link #setActive(DataColumnBoolean) setActive()}
     * 
     * @since 4.0.8
     */
    public void setActive(boolean active) {
        GtkCellRendererToggle.setActive(this, active);
    }

    /**
     * Get the current state of the toggle button
     * 
     * @since 4.0.8
     */
    public boolean getActive() {
        return GtkCellRendererToggle.getActive(this);
    }

    /**
     * Indicate the DataColumn the state of the CellRendererBoolean is bound
     * to. This is the mapping method you should use if you want to bind the
     * toggle button's state to a DataColumn's value.
     * 
     * @since 4.0.8
     */
    public void setActive(DataColumnBoolean column) {
        GtkCellLayout.addAttribute(vertical, this, "active", column.getOrdinal());
    }

    /**
     * Signal generated after user toggles the renderered toggle button in a
     * Cell.
     * 
     * <p>
     * Note that the act of toggling the cell does not cause a change in the
     * underlying model.
     * 
     * @author Andreas Kuehntopf
     * @since 4.0.8
     */
    public interface TOGGLED
    {
        public void onToggled(CellRendererToggle source, TreePath path);
    }

    /**
     * Hook up a signal handler to receive "toggled" events on this
     * CellRenderer. A typical example of how this is used is as follows:
     * 
     * <pre>
     * final DataColumnBoolean column;
     * final TreeView view;
     * final ListStore store;
     * final TreeViewColumn visibleColumn 
     * 
     * store = new ListStore(new DataColumn[] {
     *      column = new DataColumnBoolean()
     * });
     *      
     * view = new TreeView(store);
     * visibleColumn = view.appendColumn();
     * CellRendererToggle renderer = new CellRendererToggle(visibleColumn);
     * renderer.setActive(column);
     * renderer.setEditable(true);
     * renderer.connect(new TOGGLED() {
     *       public void onToggled(CellRendererToggle renderer, TreePath path) {       
     *              System.out.println(&quot;Path &quot; + path + &quot; toggled to &quot; + 
     *                  renderer.getActive());
     *       }});
     * </pre>
     * 
     * @since 4.0.8
     */
    public void connect(TOGGLED handler) {
        GtkCellRendererToggle.connect(this, new ToggledHandler(handler));
    }

    /*
     * Helper class to convert second parameter from String to TreePath
     */
    private static class ToggledHandler implements GtkCellRendererToggle.TOGGLED
    {
        private TOGGLED handler;

        public ToggledHandler(TOGGLED handler) {
            this.handler = handler;
        }

        public void onToggled(CellRendererToggle source, String path) {
            handler.onToggled(source, new TreePath(path));
        }
    }
}
