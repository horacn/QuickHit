package com.accp.ch5;

import java.util.Scanner;

/**
 * 玩家类
 * @author ACCP7.0
 *
 */
public class Player {
	/**
	 * 当前级别号
	 */
	private int levelNo;
	/**
	 * 玩家积分
	 */
	private int currScore;
	/**
	 * 当前关卡开始时间
	 */
	private long startTime;
	/**
	 * 当前关卡已用时间
	 */
	private long elapsedTime;
	/**
	 * 输了几次，错误或超时的次数大于2次就退出游戏
	 */
	private int overCount ;
	
	public int getOverCount() {
		return overCount;
	}
	public void setOverCount(int overCount) {
		this.overCount = overCount;
	}
	public int getLevelNo() {
		return levelNo;
	}
	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}
	public int getCurrScore() {
		return currScore;
	}
	public void setCurrScore(int currScore) {
		this.currScore = currScore;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	/**
	 * 玩家玩游戏
	 */
	public void play(){
		//初始化，将关卡定为1，开始时间为当前时间
		this.levelNo = 1;
		long startTime =  System.currentTimeMillis();
		this.startTime =startTime;
		Game game = new Game(this);//游戏对象
		Scanner input = new Scanner(System.in); 
		//外层控制玩几关
		for (int i = 1; i <= LevelParam.levels.length; i++) {
			//将开始时间更新
			this.startTime = System.currentTimeMillis();
			//当前关卡玩几次
			int count = LevelParam.levels[this.levelNo-1].getStrCount();
			//内层控制当前关卡出几题
			for (int j = 1; j <= count; j++) {
				//玩游戏
				String out = game.printStr();
				System.out.println(out);
				String in = input.next();
				if(!game.printResult(out, in)){
					long endTime = System.currentTimeMillis();//结束时间
					System.out.println("您的积分是"+this.currScore+",您坚持了"+((endTime-startTime)/1000)+"秒。");
					return;
				}
			}
			this.levelNo++;
		}
		long endTime = System.currentTimeMillis();//结束时间
		System.out.println("恭喜，闯关成功！！！您的积分是"+this.currScore+",您共用"+((endTime-startTime)/1000)+"秒。");
	}
}
