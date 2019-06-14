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
		// 난수를 만들어서 3개의 성적을 생성
		// scArray[number] = new ScoreVO();
		// 1번 방법
		// vo를 하나 생성하고, 값을 setting 한다음
		// 배열의 number 번째에 대입하는 방법
		ScoreVO vo = new ScoreVO();

		int intKor = rnd.nextInt(50) + 51;
		int intEng = rnd.nextInt(50) + 51;
		int intMath = rnd.nextInt(50) + 51;

		vo.setNumber(number + 1);
		vo.setKor(intKor);
		vo.setEng(intEng);
		vo.setMath(intMath);

		scArray[number] = vo;
		// 2번 방법
		// number번째 배열을 ScoreVO로 초기화 하고
		// 각 요소를 setting 하는 방법
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
		// 총점을 기준으로 내림차순 정렬을 수행

		for (int i = 0; i < scArray.length; i++) {
			for (int j = i + 1; j < scArray.length; j++) {
				if (scArray[i].getTotal() < scArray[j].getTotal()) {

					ScoreVO _score = scArray[i];
					scArray[i] = scArray[j];
					scArray[j] = _score;
				}
			}
		}
		// rank 값을 대입해준다.
		for (int i = 0; i < scArray.length; i++) {
			scArray[i].setRank(i + 1);
		}
	}

	@Override
	public void viewList() {
		System.out.println("\t\t빅데이터반 성적표");
		System.out.println("====================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		for (ScoreVO vo : scArray) {
			System.out.print(vo.getNumber() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getTotal() + "\t");
			System.out.print(vo.getAvg() + "\t");
			// 한줄을 표시한 마지막 출력문은 끝에 \n을 붙이거나 println을 사용
			System.out.print(vo.getRank() + "\n");

		}
		System.out.println("===================================================");
	}

	@Override
	public int deptAvg() {
		int Avgtotal = 0;
		int num = scArray.length;
		// 전체 학생의 평균(반 평균)을 계산
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
