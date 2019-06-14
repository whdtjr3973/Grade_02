package com.biz.grade.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_03 {

	public static void main(String[] args) {

		String scoreFile = "src/com/biz/grade/data/score.txt";
		FileReader fileReader;
		BufferedReader buffer;
		
		try {
			fileReader = new FileReader(scoreFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			while (true) {
				reader = buffer.readLine();
				if(reader ==null) break;
				
				// ���Ͽ��� ���� ������ ���ڿ��� �ݷ�(:)�� �߽����� �����Ͽ�
				// scores ���ڿ��迭�� ��´�.
				String[] scores =reader.split(":");
				System.out.printf("�й�:%s\t����:%s\n",scores[0],scores[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("������ ����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("������ �д��߿� �����߻�!");
		}
		
		

	}

}
