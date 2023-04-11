package week3laboratory1;

import javax.swing.JOptionPane;

public class PositiveNegative {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//asking for the input
		
		int number  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		
		//checking if the number is positive or negative
		
		String positive = (number + " is a postive number" + "\nmade by me Mr.Clyde Allen Yu :D");
		String negative = (number + " is a negative number" + "\nmade by me Mr.Clyde Allen Yu :D");
		String zero = ("0 is not a positive or a negative number" + "\nmade by me Mr.Clyde Allen Yu :D");
		
		if (number > 0) {
			JOptionPane.showMessageDialog(null, positive, "Average Result", JOptionPane.INFORMATION_MESSAGE);
		} else if (number < 0) {
			JOptionPane.showMessageDialog(null, negative, "Average Result", JOptionPane.INFORMATION_MESSAGE);
		} else if (number == 0) {
			JOptionPane.showMessageDialog(null, zero, "Average Result", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
