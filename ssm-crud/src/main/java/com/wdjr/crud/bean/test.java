package com.wdjr.crud.bean;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regx = "(^[1-9]\\d{4,10}$)";
		String  str = "1241530289";
		String regx2 = "(^[0-9]{3}$)";
		String str2 = "123";
	
		System.out.println(str.matches(regx));
		System.out.println(str2.matches(regx2));
	
	}

}
