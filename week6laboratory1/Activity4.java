package week6laboratory1;

import javax.swing.JOptionPane;

public class Activity4 {

	public static void main(String[] args) {
		// made by me Mr.Clyde Allen Yu :D
		
		//creating the array
		int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array (at least 20):"));
		
		//input for the array
		int array[] = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = Integer.parseInt(JOptionPane.showInputDialog("Input integer " + (i + 1) + ":"));
		}
		
		//display the values
		StringBuilder output = new StringBuilder("The array values are: \n");
        for (int i = 0; i < size; i++) {
            output.append(array[i]);
            if (i < size - 1) {
                output.append(", ");
            }
        }
		
        //find duplicates
        output.append("\nDuplicates: \n");
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            int count = 1;
            if (!visited[i]) {
                for (int j = i + 1; j < size; j++) {
                    if (array[i] == array[j]) {
                        count++;
                        visited[j] = true;
                    }
                }
                if (count > 1) {
                    output.append(array[i]).append(" -> ").append(count).append(" times\n");
                }
            }
        }
        
        String finalOutput = ("made by me Mr.Clyde Allen Yu :D\n" + output.toString());

		
        JOptionPane.showMessageDialog(null, finalOutput, "Duplicates in Array", JOptionPane.INFORMATION_MESSAGE);

	}

}
