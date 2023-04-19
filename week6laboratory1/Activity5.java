package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity5 {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//create the array and input for the array
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(JOptionPane.showInputDialog("Input integer " + (i + 1) + ":"));
        }

        //display
        StringBuilder output = new StringBuilder("The original array values are: \n");
        for (int i = 0; i < 10; i++) {
            output.append(arr[i]);
            if (i < 9) {
                output.append(", ");
            }
        }

        //reverse the array
        int temp;
        for (int i = 0; i < 5; i++) {
            temp = arr[i];
            arr[i] = arr[9 - i];
            arr[9 - i] = temp;
        }

        //display the reverse
        output.append("\n\nThe reversed array values are: \n");
        for (int i = 0; i < 10; i++) {
            output.append(arr[i]);
            if (i < 9) {
                output.append(", ");
            }
        }

        //output
        String finalOutput = ("made by me Mr.Clyde Allen Yu :D\n" + output.toString());

		
        JOptionPane.showMessageDialog(null, finalOutput, "Reverse Array", JOptionPane.INFORMATION_MESSAGE);

	}

}
