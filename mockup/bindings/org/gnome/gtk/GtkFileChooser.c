/*
 * GtkFileChooser.c
 *
 * Copyright (c) 2007 Operational Dynamics Consulting Pty Ltd
 * 
 * The code in this file, and the library it is a part of, are made available
 * to you by the authors under the terms of the "GNU General Public Licence,
 * version 2" plus the "Classpath Exception" (you may link to this code as a
 * library into other programs provided you don't make a derivation of it).
 * See the LICENCE file for the terms governing usage and redistribution.
 *
 *                      THIS FILE WILL BE GENERATED CODE!
 *
 * To modify its contents or behaviour, either update the generation program,
 * change the information in the source defs file, or implement an override
 * for this class.
 */

#include <jni.h>
#include <gtk/gtk.h>

#include "org_gnome_gtk_GtkFileChooser.h"

JNIEXPORT jstring JNICALL
Java_org_gnome_gtk_GtkFileChooser_gtk_1file_1chooser_1get_1filename
  (JNIEnv *env, jclass cls, jlong _chooser)
{
	GtkFileChooser* chooser;
	const gchar* result;
	
	// translate arg chooser
	chooser = (GtkFileChooser*) _chooser;
	
	// call constructor
	result = gtk_file_chooser_get_filename(chooser);

	// cleanup arg chooser
	
	// return result
	return (jstring) (*env)->NewStringUTF(env, result);
}

JNIEXPORT jstring JNICALL
Java_org_gnome_gtk_GtkFileChooser_gtk_1file_1chooser_1get_1uri
  (JNIEnv *env, jclass cls, jlong _chooser)
{
	GtkFileChooser* chooser;
	const gchar* result;
	
	// translate arg chooser
	chooser = (GtkFileChooser*) _chooser;
	
	// call constructor
	result = gtk_file_chooser_get_uri(chooser);

	// cleanup arg chooser
	
	// return result
	return (jstring) (*env)->NewStringUTF(env, result);
}
 
JNIEXPORT jstring JNICALL
Java_org_gnome_gtk_GtkFileChooser_gtk_1file_1chooser_1get_1current_1folder
  (JNIEnv *env, jclass cls, jlong _chooser)
{
	GtkFileChooser* chooser;
	const gchar* result;
	
	// translate arg chooser
	chooser = (GtkFileChooser*) _chooser;
	
	// call getter
	result = gtk_file_chooser_get_current_folder(chooser);

	// cleanup arg chooser
	
	// return result
	return (jstring) (*env)->NewStringUTF(env, result);
}

JNIEXPORT jboolean JNICALL
Java_org_gnome_gtk_GtkFileChooser_gtk_1file_1chooser_1set_1current_1folder
  (JNIEnv *env, jclass cls, jlong _chooser, jstring _filename)
{
	GtkFileChooser* chooser;
	gchar* filename;
	gboolean result;
	
	// translate arg chooser
	chooser = (GtkFileChooser*) _chooser;

	// translate arg filename
	filename = (gchar*) (*env)->GetStringUTFChars(env, _filename, NULL);
	if (filename == NULL) {
		return 0; /* OutOfMemoryError already thrown */
	}

	// call function
	result = gtk_file_chooser_set_current_folder(chooser, filename);

	// cleanup arg chooser
	
	// cleanup arg filename
	(*env)->ReleaseStringUTFChars(env, _filename, filename);

	// return result
	return (jboolean) result;
}