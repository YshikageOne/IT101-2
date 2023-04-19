package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity1 {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		int num[] = new int[10];
		
		int first = 0, last = 0, atIndex = 0;
		String all = "";
		
		//a. Loop to store 10 numbers to array
		for(int i = 0; i < num.length; i++) {
			int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number: "));
			
			num[i] = input;
					
		}
		
		//b. Loop to display values from Array
		for(int j = 0; j < num.length; j++) {
			all += num[j] + " ";
		}
		JOptionPane.showMessageDialog(null,"made by me Mr.Clyde Allen Yu :D\nArray Elements are\t: "+ all);
		
		//first value
		first = num[0];
		 JOptionPane.showMessageDialog(null, "made by me Mr.Clyde Allen Yu :D\nThe first value is:\t" + first);
		  
		//last value 
		last = num[num.length - 1];
		JOptionPane.showMessageDialog(null, "made by me Mr.Clyde Allen Yu :D\nThe last value is:\t" + last);
		
		//find the value at a specific index
		int searchInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the index to search: "));
		JOptionPane.showMessageDialog(null,"The value at index " + searchInput + " is " + num[searchInput]);

		//changing the value of the arrays
		int indexNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the index to search: "));
		int newValue = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new value: "));
		
		num[indexNum] = newValue;
		JOptionPane.showMessageDialog(null,"made by me Mr.Clyde Allen Yu :D\nThe value at index "+atIndex+" is\t:" +num[atIndex]);
		

	}

}
