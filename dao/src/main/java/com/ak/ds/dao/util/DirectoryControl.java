package com.ak.ds.dao.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryControl {
	
	private DirectoryControl() {
	}
	
	final private static String PATH = "..\\json\\";
	
	public static String getPath(String className) { 
		String stringPath = PATH + className +"\\";
		directoryControl(stringPath);
		return stringPath;
		}
	
	private static void directoryControl(String stringPath) {
		Path path = Paths.get(stringPath);
		BufferedWriter writer = null;
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
				writer = Files.newBufferedWriter(Paths.get(stringPath + "autoincrement"), Charset.forName("UTF-8"));
				writer.write("0");
			} catch (IOException e2) {
				e2.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
