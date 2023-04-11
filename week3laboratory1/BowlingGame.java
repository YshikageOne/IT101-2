package week3laboratory1;

import javax.swing.JOptionPane;

public class BowlingGame {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//player1
		int player1score1  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the 1st score", "Player 1", JOptionPane.QUESTION_MESSAGE));
		int player1score2  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the 2nd score", "Player 1", JOptionPane.QUESTION_MESSAGE));
		int player1score3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the 3rd score", "Player 1", JOptionPane.QUESTION_MESSAGE));
		
		int totalPlayer1Score = player1score1 + player1score2 + player1score3;
		
		//player2
        int player2score1  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the 1st score", "Player 2", JOptionPane.QUESTION_MESSAGE));
		int player2score2  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the 2nd score", "Player 2", JOptionPane.QUESTION_MESSAGE));
		int player2score3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the 3rd score", "Player 2", JOptionPane.QUESTION_MESSAGE));
				
		int totalPlayer2Score = player2score1 + player2score2 + player2score3;
		
		//find out who won
		String champion = "";
		
		if(totalPlayer1Score > totalPlayer2Score) {
			champion = "Congratulations, Player 1. You won";
		}else {
			champion = "Congratulations, Player 2. You won";
		}
		
		//total output display
		
		String output = ("Player 1 Total Score : " + totalPlayer1Score +
				         "\nPlayer 2 Total Score : " + totalPlayer2Score + 
				         "\n" + champion + "\nmade by me Mr.Clyde Allen Yu :D");
		
		JOptionPane.showMessageDialog(null, output, "Winner", JOptionPane.INFORMATION_MESSAGE);
		
		

	}

}
