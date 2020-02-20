package com.kony.orpheus.helpers;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class FileHelper {
	public static String getExtension(File file){
		//String[] nameParts = file.getName().split("\.");
		//return nameParts[nameParts.length - 1].trim().toLowerCase();
		return FilenameUtils.getExtension(file.getName());
	}
}
