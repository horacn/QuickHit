package com.accp.ch5;
/**
 * 级别初始化类
 * @author ACCP7.0
 *
 */
public class LevelParam {
	/**
	 * 级别数组
	 */
	public static Level [] levels = new Level[6];
	/**
	 * 静态代码块，初始化数组
	 */
	static{
		levels[0] = new Level(1,2,1,10,2);
		levels[1] = new Level(2,3,2,15,4);
		levels[2] = new Level(3,4,3,25,8);
		levels[3] = new Level(4,5,4,35,10);
		levels[4] = new Level(5,6,5,45,15);
		levels[5] = new Level(6,7,6,55,20);
	}
}
