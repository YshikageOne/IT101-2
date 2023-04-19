package week5laboratory1;

import javax.swing.JOptionPane;


public class TableofSquares {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//for loop
		String forOutput = ("Created By: Clyde Allen Yu :D\n" + 
		                    "-----For Loop------\n");
		int square1 = 0;
		for(int i = 1; i <= 20; i++) {
			square1 = i * i ;
			forOutput += ("Number: " + i + " Square: " + square1 +"\n");
		}
		
		JOptionPane.showMessageDialog(null, forOutput, "For Loop Output", JOptionPane.PLAIN_MESSAGE);
		
		//while loop
		String whileOutput = ("=-=-=-=While Loop=-=-=-=\n");
		
		int numbertobeSquared = 1;
		while(numbertobeSquared <= 20) {
			int whileOutputSquare = numbertobeSquared * numbertobeSquared;
			whileOutput += ("Number: " + numbertobeSquared + " Square: " + whileOutputSquare +"\n");
			numbertobeSquared++; 
		}
		
		JOptionPane.showMessageDialog(null, whileOutput, "While Loop Output", JOptionPane.PLAIN_MESSAGE);
		
		//do-while loop 
		String doWhileOutput = ("=-=-=-=Do-While Loop=-=-=-=\n");
		
		int numSquare = 1;
		do {
			int numOutput = numSquare * numSquare;
			doWhileOutput += ("Number: " + numSquare + " Square: " + numOutput +"\n");
			numSquare++;
		
		}while (numSquare <= 20);
		
		JOptionPane.showMessageDialog(null, doWhileOutput, "Do-While Loop Output", JOptionPane.PLAIN_MESSAGE);


	}

}
