package week7laboratory1;

import javax.swing.JOptionPane;

public class sumDouble {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//input
		try {
			int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number: " , "Input", JOptionPane.QUESTION_MESSAGE));
			int input2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a second number: " , "Input", JOptionPane.QUESTION_MESSAGE));
			//output
			String output = ("Created by me Mr.Clyde Allen Yu :D\n" +
					         "sumDouble(" + input + ", " + input2 + ") → " + sumDouble(input, input2));
			
			JOptionPane.showMessageDialog(null, output);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.");
		}
	}
	
	public static int sumDouble(int x, int y) {
		int output = 0;
		if(x == y) {
			output = x + y;
			output = output * 2;
		}else {
			output = x + y;
		}
		
		return output;
	}

}
