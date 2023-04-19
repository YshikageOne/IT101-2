package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity3 {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//input for the array length
		int maxValue = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter max capacity: "));
		
		int array[] = new int[maxValue];
		
		//input for the array
		for(int i = 0; i < maxValue; i++) {
			int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter input: "));
			
			array[i] = input;
		}
		
		//lowest and highest value 
		int lowest = array[0];
		int highest = array[0];
		
		for(int a = 0; a < maxValue; a++) {
			
			if(array[a] < lowest) {
				lowest = array[a];
			}
			
			if(array[a] > highest) {
				highest = array[a];
			}  
		}
		
		//final output
		String output = ("made by me Mr.Clyde Allen Yu :D\n" + 
		                 "The lowest is " + lowest + 
		                 "\nThe highest is " + highest);
		
		JOptionPane.showMessageDialog(null, output);

	}

}
