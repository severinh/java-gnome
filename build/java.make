#
# java.make, part of the Equivalence setup used by java-gnome
#
# Copyright (c) 2006-2007 Operational Dynamics Consulting Pty Ltd 
# 
# The code in this file, and the library it is a part of, are made available
# to you by the authors under the terms of the "GNU General Public Licence,
# version 2". See the LICENCE file for the terms governing usage and
# redistribution.
#

#
# This Makefile fragment takes care of building sources; it is separate from 
# the top level Makefile so that it occurs *after* code generation, thus
# allowing the variable setting to find the generated files.
#
# This runs relative to the project root
#

-include .config

all: tmp/gtk-$(APIVERSION).jar

SOURCES_DIST=$(shell find src/bindings -name '*.java') $(shell find generated/bindings -name '*.java' )


# --------------------------------------------------------------------
# Source compilation
# --------------------------------------------------------------------

tmp/gtk-$(APIVERSION).jar: tmp/stamp/classes-dist tmp/stamp/properties-dist
	@echo "$(JAR_CMD) $@"
	cd tmp/bindings ; $(JAR) cf ../../$@ `find . -name '*.class' -o -name '*.properties'`


tmp/stamp/classes-dist: $(SOURCES_DIST)
	@echo "$(JAVAC_CMD) tmp/bindings/*.class"
	$(JAVAC) -d tmp/bindings -classpath tmp/bindings -sourcepath src/bindings:generated/bindings $?
	touch $@


tmp/stamp/properties-dist: tmp/bindings/typeMapping.properties
	touch $@

tmp/bindings/%.properties: mockup/bindings/%.properties
	@echo "CP        $< -> $(@D)"
	cp -p $< $@


# vim: set filetype=make textwidth=78 nowrap:
