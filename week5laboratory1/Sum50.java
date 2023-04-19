package week5laboratory1;

import javax.swing.JOptionPane;

public class Sum50 {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		//intializing the variables
		int sum = 0;
		for(int i = 1; i <= 50; i++) {
			sum += i; 
		}
		String output = ("Created by Mr.Clyde Allen Yu :D\n" + 
                "The sum of numbers from 1 to 50 is " + sum);

		JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);

	}

}
