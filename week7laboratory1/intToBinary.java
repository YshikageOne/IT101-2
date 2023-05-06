package week7laboratory1;

import javax.swing.JOptionPane;

public class intToBinary {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		try {
			int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number: " , "Input", JOptionPane.QUESTION_MESSAGE));
			
			//output
			String output = ("Created by me Mr.Clyde Allen Yu :D\n" + 
			                 "Integer : " + input + "\n" +
					         "Binary : " + binary(input));
			
			JOptionPane.showMessageDialog(null, output);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.");
		}

	}
	
	public static String binary (int num) {
		String binary = "";
		
		while(num > 0) {
			int rem = num % 2;
			binary = rem + binary;
			num /= 2;
		}
		
		return binary;
	}

}
