package com.java.Day2;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(0);
        nums.add(4);
        nums.add(2);
        nums.add(5);
        nums.add(0);
        nums.add(3);

        numQuest(nums);

        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void numQuest(List<Integer> nums) {
        int k = nums.size() - 1; // Start from the end of the list
        Integer zero = new Integer(0);

        while (k >= 0) { // Iterate in reverse order
            if (nums.get(k).equals(zero)) {
                nums.remove(k);
            }
            k--; // Decrement k to move to the previous index
        }
    }
}


//
//public void numQuest()
//
//{
//
//  int k = 0;
//
//  Integer zero = new Integer(0);
//
//  while (k < nums.size())
//
//  {
//
//   if (nums.get(k).equals(zero))
//
//     nums.remove(k);
//
//   else
//
//      k++;
//
//  }
//
//}

 