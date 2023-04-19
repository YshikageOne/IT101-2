package week5laboratory1;

import javax.swing.JOptionPane;

public class EvenNum {
	
	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//for loop
		String loopOutput = ("Created by Mr.Clyde Allen Yu :D" +
				             "\nEven Numbers from 1 to 50\n" + 
				             "-----For Loop-----\n");
		for(int i = 2; i <= 50; i += 2 ) {
			loopOutput += i + " ";
		}
		//while loop
		loopOutput += ("\n-----While Loop-----\n");
		int evenNum = 2;
		while(evenNum <= 50) {
			loopOutput += evenNum + " ";
			evenNum += 2;
		}
		//do-while loop
		loopOutput += ("\n-----Do-While Loop-----\n");
		int evenNumber = 2;
		do {
			loopOutput += evenNumber + " ";
			evenNumber += 2;
		}while(evenNumber <= 50);
		
		
		//display
		 
		JOptionPane.showMessageDialog(null, loopOutput, "Output", JOptionPane.PLAIN_MESSAGE);

  }
}