package week3laboratory1;

import javax.swing.JOptionPane;

public class TopNotcher {

	public static void main(String[] args) {
	    //made by me Mr.Clyde Allen Yu :D
		
		//the inputs
		int highestGrade = 0;
		
		int grade1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade1 > highestGrade) {
			highestGrade = grade1;
		}
		
		int grade2   = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade2 > highestGrade) {
			highestGrade = grade2;
		}
		
		int grade3  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade3 > highestGrade) {
			highestGrade = grade3;
		}
		
		int grade4  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade4 > highestGrade) {
			highestGrade = grade4;
		}
		
		int grade5  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade5 > highestGrade) {
			highestGrade = grade5;
		}
		
		int grade6  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade6 > highestGrade) {
			highestGrade = grade6;
		}
		
		int grade7  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade7 > highestGrade) {
			highestGrade = grade7;
		}
		
		int grade8 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade8 > highestGrade) {
			highestGrade = grade8;
		}
		
		int grade9  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade9 > highestGrade) {
			highestGrade = grade9;
		}
		
		int grade10 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your number", "hmmmm", JOptionPane.QUESTION_MESSAGE));
		if(grade10 > highestGrade) {
			highestGrade = grade10;
		}
		//output
			String output = ("The highest score is " + highestGrade + "\nmade by me Mr.Clyde Allen Yu :D");
			
			JOptionPane.showMessageDialog(null, output, "RESULT", JOptionPane.INFORMATION_MESSAGE);

	}

}
