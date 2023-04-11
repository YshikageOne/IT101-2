package week3laboratory1;

import javax.swing.JOptionPane;

public class DevelopmentalTask {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your age", "Age", JOptionPane.QUESTION_MESSAGE));
	
		if(age > 60) {
			JOptionPane.showMessageDialog(null, "You are in Later Maturity\nmade by me Mr.Clyde Allen Yu :D", "Later Maturity", JOptionPane.INFORMATION_MESSAGE);
		}else if(age > 35 && age <= 60) {
			JOptionPane.showMessageDialog(null, "You are in Middle Age\nmade by me Mr.Clyde Allen Yu :D", "Middle Age", JOptionPane.INFORMATION_MESSAGE);
		}else if(age >= 18 && age <= 35) {
			JOptionPane.showMessageDialog(null, "You are in Early Adulthood\nmade by me Mr.Clyde Allen Yu :D", "Early Adulthood", JOptionPane.INFORMATION_MESSAGE);
		}else if(age >= 13 && age <= 17) {
			JOptionPane.showMessageDialog(null, "You are in Adoloscence\nmade by me Mr.Clyde Allen Yu :D", "Adoloscence", JOptionPane.INFORMATION_MESSAGE);
		}else if(age >= 6 && age <= 12){
			JOptionPane.showMessageDialog(null, "You are in Middle Childhood\nmade by me Mr.Clyde Allen Yu :D", "Middle Childhood", JOptionPane.INFORMATION_MESSAGE);
		}else if(age <= 5) {
			JOptionPane.showMessageDialog(null, "You are in Early Childhood\nmade by me Mr.Clyde Allen Yu :D", "Early Childhood", JOptionPane.INFORMATION_MESSAGE);
		}

		
	}

}
