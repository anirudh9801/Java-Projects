package com.java.prog;

import java.util.LinkedList;
public class Ex1
{
	public static void main(String[] args)
	{
		LinkedList <String> book_list = new LinkedList <String> ();
		book_list.add("Java");
		book_list.add("C");
		book_list.add("Cpp");
		book_list.add("Python");
		book_list.add("Php");
		book_list.add("Css");
		book_list.add("Html");
		book_list.add("MySql");
		System.out.println("Linked list : "+book_list);
		System.out.println("Let add the Bootstrap color after the Python Color..");
		book_list.add(4, "Bootstrap");
		System.out.println("Linked list :" + book_list);
	}
}
