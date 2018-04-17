package com.test;

public class Test {
	
	private static void getMain(String str) {
		str = "welcome";
	}
	
	public static void no1(){
		String str = "1245";
		getMain(str);
		System.out.println(str);
	}
	
	public static void no2(){
		int i=5;
		int j=11;
		int r=i & j;
		System.out.println("r="+r);
		r=i | j;
		System.out.println("r="+r);
	}
	
	public static void no3(){
		Integer a=1024,b=1024;
		System.out.println(a==b);
	}

	public static void main(String[] args) {
		no3();
	}

}
