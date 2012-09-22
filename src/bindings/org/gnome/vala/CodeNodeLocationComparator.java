/**
 * Copyright (C) 2012  Severin Heiniger <severinheiniger@gmail.com>
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.gnome.vala;

import java.util.Comparator;

/**
 * Compares two code nodes in the same source file and orders then by their
 * location in the source code.
 * 
 * This class is a singleton.
 */
public class CodeNodeLocationComparator implements Comparator<CodeNode>
{

    private static final CodeNodeLocationComparator instance;

    static {
        instance = new CodeNodeLocationComparator();
    }

    /**
     * Returns the shared, state-less instance of this comparator.
     * 
     * @return the comparator
     */
    public static CodeNodeLocationComparator getInstance() {
        return instance;
    }

    public int compare(CodeNode firstNode, CodeNode secondNode) {
        SourceReference firstReference = firstNode.getSourceReference();
        SourceReference secondReference = secondNode.getSourceReference();
        SourceLocation firstLocation = firstReference.getBegin();
        SourceLocation secondLocation = secondReference.getBegin();
        SourceFile firstSourceFile = firstReference.getSourceFile();
        SourceFile secondSourceFile = secondReference.getSourceFile();

        if (firstSourceFile != secondSourceFile) {
            throw new IllegalArgumentException("symbols must be in the same source file");
        }

        int firstLine = firstLocation.getLine();
        int secondLine = secondLocation.getLine();
        if (firstLine < secondLine) {
            return -1;
        } else if (firstLine > secondLine) {
            return 1;
        }

        int firstColumn = firstLocation.getColumn();
        int secondColumn = secondLocation.getColumn();

        if (firstColumn < secondColumn) {
            return -1;
        } else if (firstColumn > secondColumn) {
            return 1;
        } else {
            return 0;
        }
    }

}
