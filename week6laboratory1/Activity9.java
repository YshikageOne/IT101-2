package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity9 {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		// declare and initialize
        String[] pet = {"Carl", "Rick", "Edith", "Daryl", "Carol"};

        //input search pet name 
        String searchPet = JOptionPane.showInputDialog("Enter pet name to search:");

        // Search for the pet name in the array
        boolean found = false;
        int index = -1;
        for (int i = 0; i < pet.length; i++) {
            if (pet[i].equals(searchPet)) {
                found = true;
                index = i;
                break;
            }
        }

        // if pet name is found assign a unique name to the pet
        if (found) {
            String newPetName = JOptionPane.showInputDialog("Enter new name for " + searchPet + ":");
            pet[index] = newPetName;
            JOptionPane.showMessageDialog(null, searchPet + " is changed to " + newPetName, "Modify Array Values",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, searchPet + " is NOT found", "Modify Array Values",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        // Display all pets 
        StringBuilder sb = new StringBuilder();
        for (String petName : pet) {
            sb.append(petName).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); 
        JOptionPane.showMessageDialog(null, "Pets: " + sb.toString(), "made by me Mr.Clyde Allen Yu :D",
                JOptionPane.INFORMATION_MESSAGE);
    
		
	}
}
