package week3laboratory1;

import javax.swing.JOptionPane;

public class OwnerValidation {

	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog(null, "What's your name?: ", "NAME?", JOptionPane.QUESTION_MESSAGE);
		
		String lowerCaseName = name.toLowerCase();
		String owner1 = "mart";
		String owner2 = "anne";
		
		if(lowerCaseName.equals(owner1) || lowerCaseName.equals(owner2)) {
			String output = (name + " is the owner.");
		   JOptionPane.showMessageDialog(null, output, "Owner", JOptionPane.PLAIN_MESSAGE);
		}
		else {
			String output = (name + " is not the owner.");
			JOptionPane.showMessageDialog(null, output, "Not Owner", JOptionPane.PLAIN_MESSAGE);
		}

	}

}
