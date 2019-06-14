package com.biz.grade.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_03 implements ScoreService {

	List<ScoreVO> scList;
	Random rnd;
	
	public ScoreServiceImp_03() {
		scList = new ArrayList<ScoreVO>();
		rnd = new Random();
	}
	/*
	 *  난수를 발생하여 과목점수를 생성하고
	 *  scList에 추가
	 */
	
	
	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		
		int intKor = rnd.nextInt(50)+51;
		int intEng = rnd.nextInt(50)+51;
		int intMath = rnd.nextInt(50)+51;
		
		ScoreVO vo = new ScoreVO();
		vo.setNumber(number+1);
		vo.setKor(intKor);
		vo.setEng(intEng);
		vo.setMath(intMath);
		
		scList.add(vo);
		
		
		return false;
	}

	@Override
	public void total() {

		int listLen = scList.size();
		for(ScoreVO vo : scList) {
			int intTotal = vo.getKor();
			intTotal += vo.getEng();
			intTotal += vo.getMath();
			
			vo.setTotal(intTotal);
			vo.setAvg(intTotal/3);
		}
	}

	@Override
	public void rank() {
		Collections.sort(scList, new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO first, ScoreVO second) {
				// TODO Auto-generated method stub
				return second.getTotal()-first.getTotal();
			}
		});
		
		int rank = 0;
		for(ScoreVO vo : scList) {
			vo.setRank(++rank);
		}
		
		
		Collections.sort(scList, new Comparator<ScoreVO>() {
			
			// first가 앞에오면 오름
			// second가 앞에오면 내림
			@Override
			public int compare(ScoreVO first, ScoreVO second) {
				// TODO Auto-generated method stub
				return first.getNumber()-second.getNumber();
			}
		});
		
	}

	@Override
	public void viewList() {
		System.out.println("\t\t빅데이터반 성적표");
		System.out.println("====================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		for (ScoreVO vo : scList) {
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
		int num = scList.size();
		// 전체 학생의 평균(반 평균)을 계산
		for (ScoreVO vo : scList) {
			Avgtotal += vo.getAvg();

		}
		int deptAvg = Avgtotal / num;
		return deptAvg;
	}

	@Override
	public void deptAvgView() {
	}

}
