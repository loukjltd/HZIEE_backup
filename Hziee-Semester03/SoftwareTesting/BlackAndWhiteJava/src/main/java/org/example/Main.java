package org.example;

public class Main {
	public static void main(String[] args) {
		// 随机在一个字符串列表中输出一个值
		String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		System.out.println(strings[(int) (Math.random() * strings.length)]);
	}
}