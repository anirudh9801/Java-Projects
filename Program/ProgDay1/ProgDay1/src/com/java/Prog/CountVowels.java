package com.java.Prog;

public class CountVowels {
	public static void main(String[] args) {
		String str = "anirudh";
		int count=0;
		char[] ch = str.toCharArray();
		for(int i =0;i<str.length();i++) {
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') {
				count++;
			}
//		System.out.print("");
	  }
		System.out.print(count);
	}
}


