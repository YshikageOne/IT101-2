package week5laboratory2;

import javax.swing.JOptionPane;

//made by me Mr.Clyde Allen Yu :D
public class CounterControlledLoop {

	public static void main(String[] args) {
		//initializing variables
		int firstNumber, secondNumber;
		int totalInput = 0;
		int sum = 0;
		double average = 0.0;

		//getting the first input
		firstNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Type the first integer:", "First Number", JOptionPane.QUESTION_MESSAGE));
		
		//getting the second input and checking if its smaller than 1st
		do {
			secondNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Type the second integer:", "Second Number", JOptionPane.QUESTION_MESSAGE));
			if(secondNumber <= firstNumber) {
				String error = ("Sorry! second integer must be greater than " + firstNumber);
				JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE);	
			}
		} while (secondNumber <= firstNumber);
		
		//getting the input for the sum
		for(int i = firstNumber; i <= secondNumber; i++) {
			int inputNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Input integer:", "Input", JOptionPane.QUESTION_MESSAGE));
			sum += inputNum;
			totalInput++;
			
		}
		
		//average calculation
		average = (double) sum / totalInput;
		
		//output
		String output = ("Total Sum: " + sum +
				         "\nTotal Average: " + average +
				         "\nmade by me Mr.Clyde Allen Yu :D");
		JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.PLAIN_MESSAGE);
		
		
  }
}

