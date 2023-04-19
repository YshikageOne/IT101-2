package week5laboratory2;

import javax.swing.JOptionPane;

public class HappyMenu {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//initializing the menus and reciept
		int orderNum;
		float totalPayment = 0;
		double payment, change;
		
		String menu = ("Choose Your ORDER:"
				      +"\n[1] Combo Meal 1 - (1 Rice, 2 Viands, 1 glass coke for 75.00 PHP)"
				      +"\n[2] Combo Meal 2 - (1 Rice, 2 Viands for 50.00 PHP)"
				      +"\n[3] Combo Meal 3 - (1 Rice, 1 Viand 30.00 PHP)"
				      +"\n[4] Combo Meal 4 – (1 Rice + Pork Sisig + 1 can of Coke 80.00 PHP)"
				      +"\n[5] Combo Meal 5 – (1 Rice + Sinugbang Bangus 100.00 PHP)"
				      +"\n[6] Combo Meal 6 – (1 Rice + Tinolang Manok 150.00 PHP)" 
				      +"\n[7] Soft drinks 15.00 PHP"
				      +"\n[8] Rice 7.00 PHP"
				      +"\n[9] Pastil 10.00 PHP"
				      +"\n[0] Exit");
		
		String receipt = ("~~~~~~~~~~RECEIPT~~~~~~~~~~\n");
		
		//taking your order
		orderNum = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "PICK YOUR ORDER", JOptionPane.PLAIN_MESSAGE));
		
		if(orderNum == 0) {
			System.exit(0);
		} else {
			while(orderNum != 0) {
				if(orderNum == 1) {
					totalPayment += 75;
					receipt += ("Combo Meal 1 - (1 Rice, 2 Viands, 1 glass coke for 75.00 PHP)\n");
				}else if(orderNum == 2) {
					totalPayment += 50;
					receipt += ("Combo Meal 2 - (1 Rice, 2 Viands for 50.00 PHP)\n");
				}else if(orderNum == 3) {
					totalPayment += 30;
					receipt += ("Combo Meal 3 - (1 Rice, 1 Viand 30.00 PHP)\n");
				}else if(orderNum == 4) {
					totalPayment += 80;
					receipt += ("Combo Meal 4 – (1 Rice + Pork Sisig + 1 can of Coke 80.00 PHP)\n");
				}else if(orderNum == 5) {
					totalPayment += 100;
					receipt += ("Combo Meal 5 – (1 Rice + Sinugbang Bangus 100.00 PHP)\n");
				}else if(orderNum == 6) {
					totalPayment += 150;
					receipt += ("Combo Meal 6 – (1 Rice + Tinolang Manok 150.00 PHP)\n");
				}else if(orderNum == 7) {
					totalPayment += 15;
					receipt += ("Soft drinks 15.00 PHP\n");
				}else if(orderNum == 8) {
					totalPayment += 7;
					receipt += ("Rice 7.00 PHP\n");
				}else if(orderNum == 9) {
					totalPayment += 10;
					receipt += ("Pastil 10.00 PHP\n");
				}
				orderNum = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "PICK YOUR ORDER", JOptionPane.PLAIN_MESSAGE));
			}
			
			//reciept
			String needPayment = String.format("Your total bill is: %.2f PHP" + "\nHow much would you pay? ", totalPayment);
			payment = Double.parseDouble(JOptionPane.showInputDialog(null, needPayment, "Time to pay", JOptionPane.PLAIN_MESSAGE));
			
			//if the payment isn't enough
			while(payment < totalPayment) {
				payment = Double.parseDouble(JOptionPane.showInputDialog(null,  "Payment isn't enough.. please the right amount: "));
			}
			
			change = payment - totalPayment;
			receipt += (String.format("\nTotal: %.2f PHP", totalPayment)) +
					   (String.format("\nPayment: %.2f PHP", payment)) +
					   (String.format("\nChange: %.2f PHP", change)) + 
					   ("\nmade by me Mr.Clyde Allen Yu :D");
			
			String yourChange = (String.format("\nYour change is: %.2f PHP", change));
					   
			JOptionPane.showMessageDialog(null, receipt, "Receipt", JOptionPane.PLAIN_MESSAGE);
			
		}
	}

}
