package com.java.Prog;

public class CountDigit {
	public static void main(String[] args) {
		String str ="ANIR1234UD5H";
		
		int count =0;
		
		for(int i = 0 ; i<str.length();i++) {
			//Inside the loop, 
            //it checks whether the character at the current index i is a digit using the Character.
            //isDigit method. 
           //If the character is a digit, the code inside this if block is executed.
			if(Character.isDigit(str.charAt(i))) { 
				
				//If a digit is found, 
				//the code retrieves the numeric value of the digit using Character.getNumericValue.
				// This method converts a character digit into its integer equivalent and adds it to the count variable.


				count+=Character.getNumericValue(str.charAt(i));
			}
		}
		System.out.println(count);
	}

}
