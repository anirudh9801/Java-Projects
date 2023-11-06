package com.java.prog;

import java.util.*;
public class LinkedList_ArrayList
{
	public static void main(String[] args)
	{
		LinkedList <String> linked_list = new LinkedList <String> ();
		linked_list.add("Java");
		linked_list.add("C");
		linked_list.add("Cpp");
		linked_list.add("Python");
		linked_list.add("Php");
		linked_list.add("Css");
		linked_list.add("Html");
		linked_list.add("MySql");
		System.out.println("Given linked list: " + linked_list);
 
		List<String> array_list = new ArrayList<String>(linked_list);
 
		for (String s : array_list)
		{
			System.out.println(s);
		}
	}
}