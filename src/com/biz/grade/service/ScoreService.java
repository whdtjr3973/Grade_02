package com.biz.grade.service;

/*
 * 1. 성적을 입력 : boolean inputScore(int number)
 * 2. 총점을 계산 : void total()
 * 3. 석차를 계산 : void rank()
 * 4. 성적리스트 출력 : void viewList()
 * 5. 전체평균 계산 : int deptAvg() 
 * 6. 전체평균 출력 : void deptAvgView()
 */

public interface ScoreService {

	public boolean inputScore(int number) throws NumberFormatException;
	public void total();
	public void rank();
	public void viewList();
	public int deptAvg();
	public void deptAvgView();
}
