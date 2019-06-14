package com.biz.grade.service;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_02 implements ScoreService {
	ScoreVO[] scArray;
	Random rnd;
	Scanner scan;
	
	/*
	 * �����ڰ� �Ű������� �޸��ؼ�
	 * �ߺ��Ǿ� ��������� �ִ�.
	 * �̷��� �Ǹ�
	 * �����ڿ��� ������ �ڵ����
	 * ���� �ڵ尡 �ݺ��Ǵ� ������ ��Ȳ�� �ȴ�.
	 * 
	 * �Ű������� ���� �����ڿ���
	 * �Ű�����(�迭�� ����)�� �ִ� �����ڸ� ȣ���Ҽ� �ִ� 
	 * ����� ������ ���ڴ�!!
	 */

	public ScoreServiceImp_02() {
//		scArray = new ScoreVO[10];
//		rnd = new Random();
//		scan = new Scanner(System.in);
		
		// �� �ڽſ��� 10�̶�� ���� �����ϴ� �����ڸ� ȣ���϶�
		// �Ű������� �ִ� �����ڸ� ȣ���ϴ� �ڵ�
		this(10);
	}
	
	// �迭�� ������ �Ű������� �޴� ������
	public ScoreServiceImp_02(int arrLen) {
		scArray = new ScoreVO[arrLen];
		for(int i = 0 ; i < scArray.length; i++) {
			scArray[i] = new ScoreVO();
		}
		rnd = new Random();
		scan = new Scanner(System.in);
	}

	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		/*
		 *  Ű���忡�� ������ �Է¹޾Ƽ� scArray�߰�
		 *  --END ���ڿ��� �Է� ������ �Է� ����
		 */
		ScoreVO vo = new ScoreVO();
		
			System.out.print((number+1) + "�� �л��� �������� (���� --END) >");
			String strKor = scan.nextLine();
			if(strKor.equals("--END"))	return true;
			
			int intKor = Integer.valueOf(strKor);
			
			System.out.print((number+1) + "�� �л��� ��������>");
			String strEng = scan.nextLine();
			int intEng = Integer.valueOf(strEng);
			
			System.out.print((number+1) + "�� �л��� ��������");
			String strMath = scan.nextLine();
			int intMath = Integer.valueOf(strMath);
			
			vo.setKor(intKor);
			vo.setEng(intEng);
			vo.setMath(intMath);
			
			scArray[number] = vo;
		
		
		return false;
	}

	@Override
	public void total() {
		for(ScoreVO vo : scArray) {
			int intTotal = vo.getKor();
			intTotal += vo.getEng();
			intTotal += vo.getMath();
			
			vo.setTotal(intTotal);
			vo.setAvg(intTotal/3);
		}
		
	}

	@Override
	public void rank() {
	}

	@Override
	public void viewList() {
		System.out.println("\t\t�����͹� ����ǥ");
		System.out.println("====================================================");
		System.out.println("�й�\t����\t����\t����\t����\t���\t����");
		for (ScoreVO vo : scArray) {
			System.out.print(vo.getNumber() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getTotal() + "\t");
			System.out.print(vo.getAvg() + "\t");
			System.out.print(vo.getRank() + "\n");

		}
		System.out.println("===================================================");
	}

	@Override
	public int deptAvg() {
		int Avgtotal = 0;
		int num = scArray.length;
		// ��ü �л��� ���(�� ���)�� ���
		for (ScoreVO vo : scArray) {
			Avgtotal += vo.getAvg();

		}
		int deptAvg = Avgtotal / num;
		return deptAvg;
	}

	@Override
	public void deptAvgView() {
	}


}
