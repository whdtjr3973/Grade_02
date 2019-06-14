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
	 * 생성자가 매개변수를 달리해서
	 * 중복되어 만들어지고 있다.
	 * 이렇게 되면
	 * 생성자에서 실행할 코드들이
	 * 같은 코드가 반복되는 불편한 상황이 된다.
	 * 
	 * 매개변수가 없는 생성자에서
	 * 매개변수(배열의 개수)가 있는 생성자를 호출할수 있는 
	 * 방법이 있으면 좋겠다!!
	 */

	public ScoreServiceImp_02() {
//		scArray = new ScoreVO[10];
//		rnd = new Random();
//		scan = new Scanner(System.in);
		
		// 나 자신에게 10이라는 값을 전달하는 생성자를 호출하라
		// 매개변수가 있는 생성자를 호출하는 코드
		this(10);
	}
	
	// 배열의 개수를 매개변수로 받는 생성자
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
		 *  키보드에서 성적을 입력받아서 scArray추가
		 *  --END 문자열을 입력 받으면 입력 종료
		 */
		ScoreVO vo = new ScoreVO();
		
			System.out.print((number+1) + "번 학생의 국어점수 (종료 --END) >");
			String strKor = scan.nextLine();
			if(strKor.equals("--END"))	return true;
			
			int intKor = Integer.valueOf(strKor);
			
			System.out.print((number+1) + "번 학생의 영어점수>");
			String strEng = scan.nextLine();
			int intEng = Integer.valueOf(strEng);
			
			System.out.print((number+1) + "번 학생의 수학점수");
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
