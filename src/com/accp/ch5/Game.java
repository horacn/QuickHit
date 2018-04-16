package com.accp.ch5;

import java.util.Random;

/**
 * 游戏类
 * @author ACCP7.0
 *
 */
public class Game {
	private Player player;//当前玩家
	
	public Game(Player p){
		this.player = p;
	}
	
	/**
	 * 生成随机字符
	 * @return
	 */
	public String printStr(){
		//当前玩家级别
		int levelNo = this.player.getLevelNo();
		//要生成的字符长度
		int strLength = LevelParam.levels[levelNo-1].getStrLength();
		String [] strs = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","-","_","=","+",";",":","'","\"",",",".","<",">","/","?","`","~","[","]","{","}","\\","|","!","@","#","$","%","^","&","*","(",")"};
		String gameStr = "";
		//循环生成字符
		for (int i = 0; i < strLength; i++) {
			//随机数
			Random r = new Random();
			int randInt = r.nextInt(strs.length);
			//int randWord = randInt+97;
			//把数字转换成char（a = 97，z = 122）
			//gameStr += (char)randWord;
			gameStr += strs[randInt];
		}
		return gameStr;
	}
	/**
	 * 验证玩家输入
	 * @param out
	 * @param in
	 * @return boolean
	 */
	public boolean printResult(String out,String in){
		//当前玩家级别
		int levelNo = this.player.getLevelNo();
		//当前关卡时间限制
		int timeLimit = LevelParam.levels[levelNo-1].getTimeLimit()*1000;
		//当前关卡开始时间
		long startTime = this.player.getStartTime();
		//已用时间
		long usedTime = System.currentTimeMillis()-startTime;
		this.player.setElapsedTime(usedTime/1000);
		//如果输入正确
		if (out.equals(in)) {
			//如果没超时
			if (usedTime<=timeLimit) {
				//给玩家加分
				this.player.setCurrScore(this.player.getCurrScore()+LevelParam.levels[levelNo-1].getPerScore());
				System.out.println("输入正确，您的级别是"+this.player.getLevelNo()+"，您的积分是"+this.player.getCurrScore()+"，已用时间"+this.player.getElapsedTime()+"秒。");
				return true;
			}else {
			//如果超时
				this.player.setOverCount(this.player.getOverCount()+1);//over次数加1
				//如果超时次数大于2，就退出游戏
				if (this.player.getOverCount()>=2) {
					System.out.print("您输入太慢了，已经超时。游戏结束！");
					//System.exit(1); //退出Java虚拟机
					return false;
				}else {
					System.out.println("您输入太慢了。你还有"+(3-this.player.getOverCount())+"次机会！");
					return true;
				}
				
			}
		}else {
		//如果输入错误
			this.player.setOverCount(this.player.getOverCount()+1);//over次数加1
			//如果输入错误次数大于2，就退出游戏
			if (this.player.getOverCount()>2) {
				System.out.print("不好意思，您的输入有误。游戏结束！");
				//System.exit(1); //退出Java虚拟机
				return false;
			}else {
				System.out.println("您的输入有误。你还有"+(3-this.player.getOverCount())+"次机会！");
				return true;
			}
		}
	}
}
