package com.biz.grade.service;

import java.util.Collections;
import java.util.Random;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {

	ScoreVO[] scArray;
	Random rnd;

	public ScoreServiceImp_01() {
		scArray = new ScoreVO[10];
		Random rnd = new Random();
	}

	public ScoreServiceImp_01(int arrLen) {
		scArray = new ScoreVO[arrLen];
		rnd = new Random();
	}

	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		// ������ ���� 3���� ������ ����
		// scArray[number] = new ScoreVO();
		// 1�� ���
		// vo�� �ϳ� �����ϰ�, ���� setting �Ѵ���
		// �迭�� number ��°�� �����ϴ� ���
		ScoreVO vo = new ScoreVO();

		int intKor = rnd.nextInt(50) + 51;
		int intEng = rnd.nextInt(50) + 51;
		int intMath = rnd.nextInt(50) + 51;

		vo.setNumber(number + 1);
		vo.setKor(intKor);
		vo.setEng(intEng);
		vo.setMath(intMath);

		scArray[number] = vo;
		// 2�� ���
		// number��° �迭�� ScoreVO�� �ʱ�ȭ �ϰ�
		// �� ��Ҹ� setting �ϴ� ���
		/*
		 * scArray[number] = new ScoreVO(); scArray[number].setNumber(number+1);
		 * scArray[number].setKor(intKor); scArray[number].setEng(intEng);
		 * scArray[number].setMath(intMath);
		 */

		return false;
	}

	@Override
	public void total() {
		for (ScoreVO vo : scArray) {
			int intTotal = vo.getKor();
			intTotal += vo.getEng();
			intTotal += vo.getMath();

			vo.setTotal(intTotal);
			vo.setAvg(intTotal / 3);
		}
	}

	@Override
	public void rank() {
		// ������ �������� �������� ������ ����

		for (int i = 0; i < scArray.length; i++) {
			for (int j = i + 1; j < scArray.length; j++) {
				if (scArray[i].getTotal() < scArray[j].getTotal()) {

					ScoreVO _score = scArray[i];
					scArray[i] = scArray[j];
					scArray[j] = _score;
				}
			}
		}
		// rank ���� �������ش�.
		for (int i = 0; i < scArray.length; i++) {
			scArray[i].setRank(i + 1);
		}
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
			// ������ ǥ���� ������ ��¹��� ���� \n�� ���̰ų� println�� ���
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
