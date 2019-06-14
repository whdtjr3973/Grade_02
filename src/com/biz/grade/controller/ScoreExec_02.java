package com.biz.grade.controller;

import java.io.FileNotFoundException;

import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceImp_04;

public class ScoreExec_02 {

	public static void main(String[] args) {
		String scoreFile = "src/com/biz/grade/data/score.txt";

		/*
		 * try������ ����� �ϴ� ��ɹ��� ���� ��� try�� �ȿ��� ��ü��, ������ �����ϸ� try�� �ȿ� ��� �ڵ带 ���߽��Ѿ� �Ѵ�.
		 * 
		 * �׷��� ���𹮰� �������� ������ �и��ϴ� ���� ����.
		 */
		ScoreService sService = null; // ����
		try {
			// ������
			sService = new ScoreServiceImp_04(10, scoreFile);

		} catch (FileNotFoundException e) {
		}

		sService.inputScore(0);
		sService.viewList();
		sService.total();
	}

}
