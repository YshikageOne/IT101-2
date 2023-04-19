package week5laboratory2;

import javax.swing.JOptionPane;

public class FlagControlledLoop {
	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		//initializing the values and the flag
		boolean continueLoop = true;
		
		//loop to ask for the input
		while(continueLoop) {
			String input = JOptionPane.showInputDialog(null, "Type a character:");
			if(input != null && !input.isEmpty()) {
				char charInput = input.charAt(0);
				charInput = Character.toLowerCase(charInput);
				
				if(charInput == 'a' ||
				   charInput == 'e' ||
				   charInput == 'i' ||
				   charInput == 'o' ||
				   charInput == 'u') {
					JOptionPane.showMessageDialog(null, "Found a vowel. Program terminating...made by me Mr.Clyde Allen Yu :D");
					continueLoop = false;
				} else {
					JOptionPane.showMessageDialog(null, "Not that as I am expecting. Try again...made by me Mr.Clyde Allen Yu :D");

				}
			} else {
				JOptionPane.showMessageDialog(null, "Not that as I am expecting. Try again...made by me Mr.Clyde Allen Yu :D");

			}
			
			
		}
 		
		
		
	}

}
