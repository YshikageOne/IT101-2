package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity6 {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		int orig[] = new int[15];
        int copy[] = new int[15];

        // input to the original array
        for (int i = 0; i < 15; i++) {
            orig[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter integer for orig[" + i + "]:"));
        }

        //copy original array to the copied array
        for (int i = 0; i < 15; i++) {
            copy[i] = orig[i];
        }

        //display the original and copied array
        StringBuilder output = new StringBuilder("Elements of orig array: \n");
        for (int i = 0; i < 15; i++) {
            output.append("orig[").append(i).append("]: ").append(orig[i]).append("\n");
        }
        output.append("\nElements of copy array: \n");
        for (int i = 0; i < 15; i++) {
            output.append("copy[").append(i).append("]: ").append(copy[i]).append("\n");
        }

        // display the output
        String finalOutput = ("made by me Mr.Clyde Allen Yu :D\n" + output.toString());

		
        JOptionPane.showMessageDialog(null, finalOutput, "Array Copy", JOptionPane.INFORMATION_MESSAGE);

	}

}
