package week5laboratory1;

import javax.swing.JOptionPane;

public class SumofNSquareOdd {
    public static void main(String[] args) {
    	//made by me Mr.Clyde Allen Yu :D
        // input
        String input = JOptionPane.showInputDialog("Enter the value of N:");
        int n = Integer.parseInt(input);

        //compute the square
        int sum = 0;
        String equation = "";
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            sum += square;
            equation += i + "^2";
            if (i < n) {
                equation += " + ";
            }
        }

        // output
        String output = ("Created By: Clyde Allen Yu :D\n"+ "Value of N: " + n + "\n");
        output += equation + " = " + sum;
        JOptionPane.showMessageDialog(null, output);
    }
}
