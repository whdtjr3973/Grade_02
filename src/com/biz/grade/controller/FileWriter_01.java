package com.biz.grade.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter_01 {

	public static void main(String[] args) {
		
		String scoreFile = "src/com/biz/grade/data/score_01.txt";
		
		FileWriter fileWriter;
		PrintWriter printer;
		
		try {
			fileWriter = new FileWriter(scoreFile);
			printer = new PrintWriter(fileWriter);
			
			for(int i = 0 ; i < 100; i++) {
				printer.println(i);
			}
			/*
			 * ���Ͼ��� (���)�����
			 * ������ ����ϴ� �ڵ尡 ����Ǵ���
			 * ���� ���Ͽ� ������ �������� �ʴ´�.
			 * 
			 * �׷���
			 * ���� ������ ������ �����ϵ��� �޼��带 ������ �־�� �Ѵ�.
			 */
			printer.flush(); // �ݵ��
			printer.close(); // �ݵ��
			fileWriter.close(); // ������
			System.out.println("---���� ��� �Ϸ�---");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("�˼����� ������ ���� ���� �Ұ�");
		}
		
	}

}
