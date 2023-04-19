package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity2 {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//input
		int matrix[] = new int[10];
		
		for(int i = 0; i < matrix.length; i++) {
	       int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number: "));
			
		   matrix[i] = input;
		}
		
		//All odds and even
        String oddOutput = ("All odds are: ");
        String evenOutput = ("All even are: ");
		
		for(int j = 0; j < matrix.length;j++) {
			if(matrix[j] % 2 != 0) {
				oddOutput += matrix[j] + " ";
			}else {
				evenOutput += matrix[j] + " ";
			}
		}
		
		//All positive and negative
		String positiveOutput = ("All positive integers are: ");
		String negativeOutput = ("All negative integers are: ");
		
		for(int a = 0; a < matrix.length;a++) {
			if(matrix[a] > 0) {
				positiveOutput += matrix[a] + " ";
			}else {
				negativeOutput += matrix[a] + " ";
			}
		}
		
		//final output
		String finalOutput = ("made by me Mr.Clyde Allen Yu :D \n" + oddOutput + "\n" + evenOutput + "\n" + positiveOutput + "\n" + negativeOutput);
		
		JOptionPane.showMessageDialog(null, finalOutput);
	}

}
