package com.biz.grade.service;

/*
 * 1. ������ �Է� : boolean inputScore(int number)
 * 2. ������ ��� : void total()
 * 3. ������ ��� : void rank()
 * 4. ��������Ʈ ��� : void viewList()
 * 5. ��ü��� ��� : int deptAvg() 
 * 6. ��ü��� ��� : void deptAvgView()
 */

public interface ScoreService {

	public boolean inputScore(int number) throws NumberFormatException;
	public void total();
	public void rank();
	public void viewList();
	public int deptAvg();
	public void deptAvgView();
}
