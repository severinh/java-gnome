/*
 * MethodGenerator.java
 *
 * Copyright (c) 2007 Operational Dynamics Consulting Pty Ltd
 * 
 * The code in this file, and the library it is a part of, are made available
 * to you by the authors under the terms of the "GNU General Public Licence,
 * version 2" See the LICENCE file for the terms governing usage and
 * redistribution.
 */
package com.operationaldynamics.codegen;

import com.operationaldynamics.driver.DefsFile;

/**
 * Output the code corresponding to a GObject method definition. See
 * {@link MethodBlock} for an example of a (define-method ...) stanza.
 * 
 * <p>
 * Code generated by this class will be used as:
 * 
 * <pre>
 * public setLabel(String label) {
 *     GtkButton.setLabel(this, label);
 * }
 * </pre>
 * 
 * in the public API wrapper classes to be written by the bindings hackers.
 * 
 * @author Andrew Cowie
 */
public class MethodGenerator extends FunctionGenerator
{
    /**
     * @param gObjectType
     * @param blockName
     * @param gReturnType
     * @param gFunctionName
     * @param gParameters
     */
    public MethodGenerator(final DefsFile data, final String blockName, final String gReturnType,
            final String gFunctionName, final String[][] gParameters, char callerOwnsReturn) {
        super(data, blockName, gReturnType, gFunctionName, gParameters, callerOwnsReturn);
    }
}
