package com.biz.grade.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_05 {

	public static void main(String[] args) {

		String scoreFile = "src/com/biz/grade/data/score.txt";
		FileReader fileReader;
		BufferedReader buffer;

		try {
			fileReader = new FileReader(scoreFile);
			buffer = new BufferedReader(fileReader);
			String reader = "";
			int intTotal = 0;
			System.out.println("�����͹� ����ǥ");
			System.out.println("====================================");
			System.out.println("�й�\t����\t����\t����\t����");
			System.out.println("------------------------------------");
			while (true) {
				reader = buffer.readLine();
				if (reader == null)
					break;

				// score.txt ���Ͽ� ���ٿ� �ݷ��� �������� 4����
				// ���� �����Ƿ� scores�� 4��¥�� �迭�� �����ȴ�.
				String[] scores = reader.split(":");
				String number = scores[0];
				int intKor = Integer.valueOf(scores[1]);
				int intEng = Integer.valueOf(scores[2]);
				int intMath = Integer.valueOf(scores[3]);
				int intSum = intKor + intEng + intMath;

				intTotal += intSum;
				System.out.printf("%s\t%d\t%d\t%d\t%d\n", number, intKor, intEng, intMath, intSum);
			}
			System.out.println("===================================");
			System.out.println("���� : " + intTotal);
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
