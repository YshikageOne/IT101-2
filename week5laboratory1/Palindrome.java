package week5laboratory1;

import javax.swing.JOptionPane;

public class Palindrome {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//input
		String input = JOptionPane.showInputDialog("Enter a string:");
        if (input == null) {
            JOptionPane.showMessageDialog(null, "No input entered. Exiting...");
            System.exit(0);
        }
        
        //removes spaces and case sensitive
        String inputWithoutSpaces = input.replaceAll("\\s+", "").toLowerCase();
        
        //reverses the input
        StringBuilder reversedInput = new StringBuilder(inputWithoutSpaces).reverse();
        
        //check if the input is a palindrome
        
        if(inputWithoutSpaces.equals(reversedInput.toString())) {
        	JOptionPane.showMessageDialog(null, input + " is a palindrome! \nmade by me Mr.Clyde Allen Yu :D");
        } else {
            JOptionPane.showMessageDialog(null, input + " is not a palindrome. \nmade by me Mr.Clyde Allen Yu :D");
        }
	}

}
