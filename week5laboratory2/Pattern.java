package week5laboratory2;

import javax.swing.JOptionPane;

public class Pattern {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		String output  = "";
		        // Pattern 1
		        StringBuilder pattern1 = new StringBuilder("Pattern 1\n");
		        for (int i = 1; i <= 6; i++) {
		            for (int j = 1; j <= i; j++) {
		                pattern1.append("*");
		            }
		            pattern1.append("\n");
		        }
		        output = (output + pattern1.toString());

		        // Pattern 2
		        StringBuilder pattern2 = new StringBuilder("Pattern 2\n");
		        for (int i = 1; i <= 6; i++) {
		            for (int j = 1; j <= 6 - i; j++) {
		                pattern2.append(" ");
		            }
		            for (int j = 1; j <= i; j++) {
		                pattern2.append("*");
		            }
		            for (int j = 1; j <= i - 1; j++) {
		                pattern2.append("*");
		            }
		            pattern2.append("\n");
		        }
		        output = (output +  pattern2.toString());
		        
		        //Pattern 3
		        StringBuilder pattern3 = new StringBuilder("Pattern 3\n");
		        for (int i = 1; i <= 6; i++) {
		            for (int j = 1; j <= i - 1; j++) {
		                pattern3.append(" ");
		            }
		            for (int j = 1; j <= 7 - i; j++) {
		                pattern3.append("*");
		            }
		            pattern3.append("\n");
		        }
		        output = (output + pattern3.toString());
		    
		        
		        JOptionPane.showMessageDialog(null, output, "made by me Mr.Clyde Allen Yu :D", JOptionPane.PLAIN_MESSAGE);
	}
		        
}


