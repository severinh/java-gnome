/*
 * java-gnome, a UI library for writing GTK and GNOME programs from Java!
 *
 * Copyright © 2006-2012 Operational Dynamics Consulting, Pty Ltd and Others
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

#include <string.h>
#include <jni.h>
#include <gtk/gtk.h>
#include <vala-2.0/vala.h>
#include "bindings_java.h"
#include "org_gnome_vala_ValaSourceReference.h"

JNIEXPORT void JNICALL
Java_org_gnome_vala_ValaSourceReferenceOverride_vala_1source_1reference_1get_1begin
(
	JNIEnv* env,
	jclass cls,
	jlong _self,
	jlong _location
)
{
	ValaSourceLocation* location;
	ValaSourceReference* self;

	// convert parameter self
	self = (ValaSourceReference*) _self;

	// call function
	location = (ValaSourceLocation*) _location;
	vala_source_reference_get_begin(self, location);

	// cleanup parameter self
}

JNIEXPORT void JNICALL
Java_org_gnome_vala_ValaSourceReferenceOverride_vala_1source_1reference_1get_1end
(
	JNIEnv* env,
	jclass cls,
	jlong _self,
	jlong _location
)
{
	ValaSourceLocation* location;
	ValaSourceReference* self;

	// convert parameter self
	self = (ValaSourceReference*) _self;

	// call function
	location = (ValaSourceLocation*) _location;
	vala_source_reference_get_end(self, location);

	// cleanup parameter self
}

JNIEXPORT jstring JNICALL
Java_org_gnome_vala_ValaSourceReferenceOverride_vala_1source_1reference_1get_1content
(
	JNIEnv* env,
	jclass cls,
	jlong _self
)
{
	gchar* result;
	jstring _result;
	ValaSourceReference* self;
	ValaSourceLocation begin_source_location;
	ValaSourceLocation end_source_location;
	gchar* begin_pos;
	gchar* end_pos;
	int length;
	
	// convert parameter self
	self = (ValaSourceReference*) _self;

	// call function
	vala_source_reference_get_begin (self, &begin_source_location);
	vala_source_reference_get_end (self, &end_source_location);
	begin_pos = begin_source_location.pos;
	end_pos = end_source_location.pos;
	length = end_pos - begin_pos;
	result = strndup(begin_pos, length);
	
	// cleanup parameter self

	// translate return value to JNI type
	_result = (jstring) bindings_java_newString(env, result);

	// free temporary string
	free (result);

	// and finally
	return _result;
}