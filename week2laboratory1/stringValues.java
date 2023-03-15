package week2laboratory1;

import javax.swing.JOptionPane;

public class stringValues {
	//made by me Mr.Clyde Allen Yu :D
	public static void main(String[] args) {
		String str1 = "God is real";
		String str2 = "UNLESs";
		
		//First Part
		char task1 = str1.charAt(7);
		int task2 = str2.indexOf('s');
		String task3 = str1.toUpperCase();
		String task4 = str2.toLowerCase();
		String task5 = str1.replaceAll("[aeiou]", "x");
		int str1len = str1.length();
		int str2len = str2.length();
		
		//displaying the 1st part
		String result1 = ("The 8th character of str1 is " + task1 + 
				          "\nThe index of 's' in str2 is " + task2 +
				          "\nstr1 in uppercase: " + task3 +
				          "\nstr2 in lowercase: " + task4 +
				          "\nstr1 with vowels replaced: " + task5 + 
				          "\nLength of str1: " + str1len +
				          "\nLength of str2: " + str2len);
		
		JOptionPane.showMessageDialog(null, result1, "RESULTS ARE IN", JOptionPane.PLAIN_MESSAGE);
		
		//Second Part
		String statement = JOptionPane.showInputDialog(null, "Enter your statement", "Statement?", JOptionPane.QUESTION_MESSAGE);
		
		//number 1
		String sentence = (str1 + " " + str2 + " " + statement);
		//number 2
		int num2 = sentence.length();
		//number 3
		String num3 = "";
		if (sentence.contains("an integer")) {
			num3 = "The word \"an integer\" is present in the sentence.";
		} else {
			num3 = "The word \"an integer\" is not present in the sentence.";
		}
		
		//number 4
		String num4 = "";
		boolean isEqual = sentence.substring(16, 18).equals(str1.substring(5, 7));
        if (isEqual) {
			num4 = ("The word \"is\" is present in str1.");
		} else {
			num4 = ("The word \"is\" is not present in str1.");
		}
        
		//number 5
		StringBuilder sb = new StringBuilder(str2);
		String num5 = sb.reverse().toString();
		
		//displaying the 2nd part
		String result2 = (sentence + 
				          "\nThe length of the sentence is " + num2 +
				          "\n" + num3 + 
				          "\n" + num4 + 
				          "\n" + num5 + 
				          "\nmade by me Mr.Clyde Allen Yu :D");
		
		JOptionPane.showMessageDialog(null, result2, "RESULTS ARE IN", JOptionPane.PLAIN_MESSAGE);            

	}

}
