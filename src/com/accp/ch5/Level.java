package com.accp.ch5;
/**
 * 游戏级别类
 * @author ACCP7.0
 *
 */
public class Level {
	/**
	 * 当前级别编号
	 */
	private int levelNo;
	/**
	 * 字符长度
	 */
	private int strLength;
	/**
	 * 输入字符次数
	 */
	private int strCount;
	/**
	 * 关卡时间(秒)
	 */
	private int timeLimit;
	/**
	 * 关卡分数
	 */
	private int perScore;
	
	
	public int getLevelNo() {
		return levelNo;
	}
	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}
	public int getStrLength() {
		return strLength;
	}
	public void setStrLength(int strLength) {
		this.strLength = strLength;
	}
	public int getStrCount() {
		return strCount;
	}
	public void setStrCount(int strCount) {
		this.strCount = strCount;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public int getPerScore() {
		return perScore;
	}
	public void setPerScore(int perScore) {
		this.perScore = perScore;
	}
	public Level(){
		
	}
	public Level(int levelNo,int strLength,int strCount,int timeLimit,int perScore){
		setLevelNo(levelNo);
		setStrLength(strLength);
		setStrCount(strCount);
		setTimeLimit(timeLimit);
		setPerScore(perScore);
	}
}
