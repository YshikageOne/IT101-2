package week7laboratory1;

import javax.swing.JOptionPane;

public class numberManipulation {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//taking the input
		//error catching
		
		try {
			int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number: " , "Input", JOptionPane.QUESTION_MESSAGE));
			
			//output
			String output = ("Created by me Mr.Clyde Allen Yu :D\n" + "isNegative : " + isNegative(input) + "\n" +
			                 "isPositive : " + isPositive(input) + "\n" + 
					         "Odd : " + Odd(input) + "\n" +
			                 "Even : " + Even(input));
			
			JOptionPane.showMessageDialog(null, output);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.");
		}
		

	}
	
	//isNegative
	
	public static boolean isNegative(int num) {
		boolean isNegative = false;
		
		if(num > 0) {
			isNegative = false;
		}else {
			isNegative = true;
		}
		
		return isNegative;
	}
	
	public static boolean isPositive(int num) {
		boolean isPositive = false;
		
		if(num > 0) {
			isPositive = true;
		}else {
			isPositive = false;
		}
		
		return isPositive;
	}
	
	public static String Odd(int num) {
		String isOdd = "";
		
		if((num % 2) != 0) {
			isOdd = "Yes";
		}else {
			isOdd = "No";
		}
		
		return isOdd;
	}
	
	public static String Even(int num) {
		String isEven = "";
		
		if((num % 2) == 0) {
			isEven = "Yes";
		}else {
			isEven = "No";
		}
		
		return isEven;
	}

}
