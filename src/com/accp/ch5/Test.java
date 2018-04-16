package com.accp.ch5;

import java.util.Scanner;

/**
 * 测试类
 * @author ACCP7.0
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.println("-----------------欢迎来到QuickHit游戏-----------------");
		System.out.println("游戏规则：\n在规定时间内输出与电脑相同的字符，共6关，\n每输正确一次就赢得相应积分，全部输入正确即闯关成功。\n您一共有3次机会。");
		System.out.println("开始闯关吧！");
		long startTime = System.currentTimeMillis();
		while (true) {
			if (System.currentTimeMillis()-startTime >2000) {//程序启动2秒后开始游戏
				Player player = new Player();
				player.play();
				input.next();
				break;
			}
		}
	}
}
