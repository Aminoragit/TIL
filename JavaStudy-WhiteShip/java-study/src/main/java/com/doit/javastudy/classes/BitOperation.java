package com.doit.javastudy.classes;

public class BitOperation {
	public static void main(String[] args) {
		int num1 = 0B0000_01010;
		int num2 = 0B0000_00101;
		System.out.println(num1 & num2);
		System.out.println(num1 | num2);
		System.out.println(num1 ^ num2); // 1111 7+
	}
}
