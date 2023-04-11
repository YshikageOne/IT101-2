package week3laboratory1;

import javax.swing.JOptionPane;

public class Payroll {

	public static void main(String[] args) {
		
		double basePay = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the base Pay (in USD):", "Base Pay", JOptionPane.QUESTION_MESSAGE));
		double hoursWorked = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the hours worked in a week:", "Hours Worked", JOptionPane.QUESTION_MESSAGE));
		
		//check if the hours worked is greater than 60
		if (hoursWorked > 60) {
			JOptionPane.showMessageDialog(null, "Nah, It shouldn't go past 60 hours :|", "Oops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//calculating regular and overtime payyy im brokeT^T
		
		double regularPay;
		double overtimePay;
		
		if (hoursWorked <= 40) {
			regularPay = hoursWorked * basePay;
			overtimePay = 0.0;
		} 
		else {
			regularPay = 40 * basePay;
			overtimePay= (hoursWorked - 40) * (basePay * 1.5);
		}
		
		//checking the base Pay
		
		if (basePay > 8.0) {
			JOptionPane.showMessageDialog(null, "Nah, It shouldn't go past 8 dollars :|", "Oops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//total pay
		
		double totalPay = regularPay + overtimePay;
		String output = ("Your total pay for the week is $" + totalPay);
		
		JOptionPane.showMessageDialog(null, output, "PAYUP", JOptionPane.PLAIN_MESSAGE);
		

	}

}
