package com.yedam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileTest {

	//@Test
	public void list() {
		
		File file = new File("C:\\temp");
		String[] list = file.list();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	//@Test
	public void delete() {
		File file =  new File("C:/temp/original3.png");
		file.renameTo(new File("C:/temp/이름재지정.png"));
	}
	
	@Test
	public void copy() throws IOException {
		FileInputStream fi =  new FileInputStream(new File("C:/temp","이름재지정.png"));  //복사할 원본파일
		FileOutputStream fo = new FileOutputStream(new File("C:/temp","복사test.png"));  //복사된 결과물 
		
		int temp;
		while ( (temp = fi.read() ) != -1) {
			fo.write(temp);
		}
		fi.close();
		fo.close();
	}
}
