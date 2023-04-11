package week3laboratory1;

import javax.swing.JOptionPane;

public class MenuCalculatorIf {
//made by me Mr.Clyde Allen Yu :D
	public static void main(String[] args) {
		//getting the numbers
		
		int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number: ", "First Number", JOptionPane.QUESTION_MESSAGE));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number: ", "Second Number", JOptionPane.QUESTION_MESSAGE));
		
		//selecting the operations
		
		String menu = "[A]dd    [S]ubtract    [M]ultiply    [D]ivision    [Q]uit";
		
		String selection  = JOptionPane.showInputDialog(null, menu, "Choose your operation", JOptionPane.QUESTION_MESSAGE);
		char ch = selection.charAt(0);
		
		if(ch == 'A' || ch == 'a') {
			String output = (num1 + " + " + num2 + " = " + add(num1,num2) + "\nmade by me Mr.Clyde Allen Yu :D");
			JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
		}else if(ch == 'S' || ch == 's'){
			String output = (num1 + " - " + num2 + " = " + subtract(num1,num2) + "\nmade by me Mr.Clyde Allen Yu :D");
			JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
		}else if(ch == 'M' || ch == 'm'){
			String output = (num1 + " x " + num2 + " = " + multiply(num1,num2) + "\nmade by me Mr.Clyde Allen Yu :D");
			JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
		}else if(ch == 'D' || ch == 'd'){
			String output = (num1 + " / " + num2 + " = " + divide(num1,num2) + "\nmade by me Mr.Clyde Allen Yu :D");
			JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
		}else if(ch == 'Q' || ch == 'q'){
			//does nothing lol
		}


	}
	
	//operations

	public static int add(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	
	public static int subtract(int num1, int num2) {
		int difference = num1 - num2;
		return difference;
	}
	
	public static int multiply(int num1, int num2) {
		int product = num1 * num2;
		return product;
	}
	
	public static double divide(int num1, int num2) {
		double quotient = num1 / num2;
		return quotient;
	}
}
