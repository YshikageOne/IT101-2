package week5laboratory1;

import javax.swing.JOptionPane;

public class SumOfNOdd {
    public static void main(String[] args) {
    	//made by me Mr.Clyde Allen Yu :D
        // get input from user
        String input = JOptionPane.showInputDialog("Enter the value of N:");
        int n = Integer.parseInt(input);

        // compute sum
        int sum = 0;
        int odd = 1;
        String equation = "";
        for (int i = 1; i <= n; i++) {
            sum += odd;
            equation += odd;
            if (i < n) {
                equation += " + ";
            }
            odd += 2;
        }

        // display output
        String output = ("Created By: Clyde Allen Yu :D\n" +"Value of N: " + n + "\n");
        output += equation + " = " + sum;
        JOptionPane.showMessageDialog(null, output);
    }
}
