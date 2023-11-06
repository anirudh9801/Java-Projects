package com.java.prog;

import java.util.LinkedList;
public class Ex2
{
	public static void main(String[] args)
	{
		LinkedList <String> fru_list = new LinkedList <String> ();
		fru_list.add("Mulberry");
		fru_list.add("Guava");
		fru_list.add("Papaya");
		fru_list.add("Apple");
		fru_list.add("Banana");
		fru_list.add("Cherry");
		System.out.println("Given linked list:" + fru_list);
		LinkedList <String> new_fru_list = new LinkedList <String> ();
		new_fru_list.add("Watermelon");
		new_fru_list.add("Pineapple");
		fru_list.addAll(3, new_fru_list);
		System.out.println("Linked List :" + fru_list);
	}
}
