package com.ak.ds.dao.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenerateId {
	
	private GenerateId() {
	}

	public static Long getId(String directoryPath) {
		String filePath = directoryPath + "autoincrement";
		BufferedWriter bufferedWriter = null;
		Long autoincrement = null;
		try {
			autoincrement = getAutoincrement(filePath) + 1;
			bufferedWriter = Files.newBufferedWriter(Paths.get(filePath), Charset.forName("UTF-8"));
			bufferedWriter.write(autoincrement.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return autoincrement;
	}

	private static Long getAutoincrement(String filePath) throws IOException {
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Long autoincrement = Long.valueOf(bufferedReader.readLine());
		bufferedReader.close();
		fileReader.close();
		return autoincrement;
	}
}
