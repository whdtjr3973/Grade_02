package com.biz.grade.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_04 {

	public static void main(String[] args) {

		String scoreFile = "src/com/biz/grade/data/score.txt";
		FileReader fileReader;
		BufferedReader buffer;

		try {
			fileReader = new FileReader(scoreFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			int intTotal = 0;
			while (true) {
				reader = buffer.readLine();
				if (reader == null)
					break;

				String[] scores = reader.split(":");

				// score.txt ���Ͽ��� ���ڿ��� �о �����κп� ������ ����Ͻÿ�
				int intScore=Integer.valueOf(scores[1]);
				intTotal += intScore;
				System.out.printf("�й�:%s\t����:%s\n", scores[0], scores[1]);
			}
			System.out.println("===========================");
			System.out.println("���� : "+ intTotal);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("������ ����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("������ �д��߿� �����߻�!");
		}

	}

}
