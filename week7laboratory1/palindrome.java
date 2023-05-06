package week7laboratory1;

import javax.swing.JOptionPane;

public class palindrome {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//input
		
		String input = JOptionPane.showInputDialog(null, "Enter your word : ");
		
		//output
		String output = ("Created by me Mr.Clyde Allen Yu :D\n" +
		                 "Word : " + input +
		                 "\nReversed Word : " + reversed(input) +
		                 "\nPalindrome? : " + isPalindrome(input));
		JOptionPane.showMessageDialog(null, output);

	}
	
	public static String reversed(String word) {
		char ch;
		String reversedWord = "";
		for(int i = 0; i < word.length(); i++) {
			ch = word.charAt(i);
			reversedWord = ch + reversedWord;
		}
		
		return reversedWord;
	}
	
	public static boolean isPalindrome(String word) {
		boolean isPalindrome = false;
		String reversedWord = reversed(word);
		
		if(word.equals(reversedWord)) {
			isPalindrome = true;
		}else {
			isPalindrome = false;
		}
		
		return isPalindrome;
	}	
		
}


