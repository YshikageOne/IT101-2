package week5laboratory2.LogIn;

import javax.swing.JOptionPane;

public class CounterControlled {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		//initialize the value and the counter value
		String properUserName = "admin";
		String properPassword = "pwd123";
		int attempts = 0;
		boolean loggedIn = false;
		
		while(attempts < 3 && !loggedIn) {
			String userName = JOptionPane.showInputDialog(null, "Enter username:");
			String passWord = JOptionPane.showInputDialog(null, "Enter password:");
			
			if (userName.equals(properUserName) && passWord.equals(properPassword)) {
				JOptionPane.showMessageDialog(null, "Log-In successful\nmade by me Mr.Clyde Allen Yu :D", "Good Job", JOptionPane.PLAIN_MESSAGE);
				loggedIn = true;
			}else {
				JOptionPane.showMessageDialog(null, "Log-In failed\nmade by me Mr.Clyde Allen Yu :D", "OOPS", JOptionPane.PLAIN_MESSAGE);
				attempts++;
			}
		}
		
		if(!loggedIn) {
			JOptionPane.showMessageDialog(null, "You ran out of attempts. Program is now terminating...\nmade by me Mr.Clyde Allen Yu :D");
		}

	}

}
