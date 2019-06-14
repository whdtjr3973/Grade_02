package com.biz.grade.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_02 {

	public static void main(String[] args) {

		/*
		 * data.txt������ �о �� ������ �о� Console�� ���̱�
		 */
		String strFile = "src/com/biz/grade/data/data.txt";
		FileReader fileReader;
		BufferedReader buffer;
		
		try {
			fileReader = new FileReader(strFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while(true) {
				reader = buffer.readLine();
				if(reader == null) break;
				System.out.println(reader);
			} 
		} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("data.txt ������ �����ϴ�.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("������ �д��߿� ������ �߻�!");
		}

	}

}
