package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity8 {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		// declare and initialize
        String[] pet = new String[10];

        // input the pet names into the array
        for (int i = 0; i < 10; i++) {
            pet[i] = JOptionPane.showInputDialog("Enter pet name for pet[" + i + "]:");
        }

        // input for the searched name
        String searchPet = JOptionPane.showInputDialog("Enter pet name to search:").toLowerCase(); 

        // searching the name
        boolean found = false;
        int index = -1;
        for (int i = 0; i < 10; i++) {
            if (pet[i].toLowerCase().equals(searchPet)) { 
                found = true;
                index = i;
                break;
            }
        }

        // display the result
        if (found) {
            JOptionPane.showMessageDialog(null, searchPet + " is found at index " + index, "made by me Mr.Clyde Allen Yu :D",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, searchPet + " is NOT found", "made by me Mr.Clyde Allen Yu :D",
                    JOptionPane.INFORMATION_MESSAGE);
        }

	}

}
