package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity7 {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//initialize the array
        int[] array = new int[10];

        // input integers
        for (int i = 0; i < 10; i++) {
            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter integer for arr[" + i + "]:"));
        }

        // input search value 
        int searchValue = Integer.parseInt(JOptionPane.showInputDialog("Enter value to search:"));

        // Search for the value in the array
        boolean found = false;
        int index = -1;
        for (int i = 0; i < 10; i++) {
            if (array[i] == searchValue) {
                found = true;
                index = i;
                break;
            }
        }

        // display the result
        String finalOutput = ("made by me Mr.Clyde Allen Yu :D\n" + searchValue);

        
        if (found) {
            JOptionPane.showMessageDialog(null, finalOutput + " is found at index " + index, "Array Search",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, finalOutput  + " is NOT found", "Array Search",
                    JOptionPane.INFORMATION_MESSAGE);
        }

	}

}
