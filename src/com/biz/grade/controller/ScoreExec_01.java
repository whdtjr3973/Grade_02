package com.biz.grade.controller;

import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceImp_03;

public class ScoreExec_01 {

	public static void main(String[] args) {

		int arrLen = 30;

		/*
		 * �������̽��� ���õǾ��ִ� Ŭ������ �����ҋ��� �������̽��� ������ �Ѵ�.
		 */
		// ScoreServiceImt_01 sService = new ScoreServiceImp_01();
		ScoreService sService = new ScoreServiceImp_03(); // 10���� ������ �迭
		//sService = new ScoreServiceImp_03(arrLen); // 30���� ������ �迭

		// Ű���带 ���ؼ� 30���� ������ �Է¹޴� �޼��带 ȣ��
		for (int i = 0; i < arrLen; i++) {
			if (sService.inputScore(i))	break;
		}

		sService.total();
		sService.rank();
		sService.viewList();
		int intDeptAvg = sService.deptAvg();
		System.out.println("��ü��� : " + intDeptAvg);

		sService.deptAvgView();
		
	}
}
