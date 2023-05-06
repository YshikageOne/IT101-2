package week9laboratory1;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Customer {

	public static void main(String[] args) {
		String menu [] = {"[A]dd Customer",
				          "[V]iew Customer",
				          "[S]earch Customer",
				          "[E]dit Customer",
				          "[D]elete Customer",
				          "[E]xit"};
		
		int MAX = 10, index = 0;
		int customer_id[] = new int[MAX];
		String customer_name[] = new String[MAX];
		String customer_gender[] = new String[MAX];
		int customer_age[] = new int[MAX];
		String choice = "";
		
		do {
			choice = JOptionPane.showInputDialog(null, "Please Select\nmade by me Mr.Clyde Allen Yu :D", "Menu", 1, null, menu, menu[0]).toString();
			
			switch(choice) {
			case "[A]dd Customer":
				customer_id[index] = Integer.parseInt(JOptionPane.showInputDialog("Customer Id: "));
				customer_name[index] = JOptionPane.showInputDialog("Customer Name: ");
				customer_age[index] = Integer.parseInt(JOptionPane.showInputDialog("Customer Age: "));
				customer_gender[index] = JOptionPane.showInputDialog("Customer Gender: ");
				
				JOptionPane.showMessageDialog(null, "Added new customer successfully");
				index++;
				break;
				
			case "[V]iew Customer":
				String all = "Customer's Info\nID\tName\tAge\tGender\n";
				
				for(int x = 0; x < index; x++) {
					all = all + customer_id[x] + "\t" + customer_name[x] + "\t" + customer_age[x]+ "\t" + customer_gender[x]+ "\n";
						
				}
				
				JOptionPane.showMessageDialog(null, new JTextArea(all));
				break;
				
			case "[S]earch Customer":
				int searchID = Integer.parseInt(JOptionPane.showInputDialog("Search the customer's ID: "));
				boolean found = false;
				String result = "No customer is linked with this ID";
				
				for(int i = 0; i < index; i++) {
					if(customer_id[i] == searchID) {
						found = true;
						result = "Customer Found:\nID: " + customer_id[i] +
		                         "\nName: " + customer_name[i] +
		                         "\nAge: " + customer_age[i] +
		                         "\nGender: " + customer_gender[i];
						break;
					}
				}
				
				JOptionPane.showMessageDialog(null, result);
				
				if(!found) {
					JOptionPane.showMessageDialog(null, "No customer is linked with this ID");
				}
				break;
				
			case "[E]dit Customer":
				int editID = Integer.parseInt(JOptionPane.showInputDialog("Search the customer's ID to edit: "));
				boolean editFound = false;
				
				for(int i = 0; i < index; i++) {
					if(customer_id[i] == editID) {
						editFound = true;
						String editOption = JOptionPane.showInputDialog(null, "Enter the field to edit:\n[N]ame\n[A]ge\n[G]ender", "Edit", JOptionPane.PLAIN_MESSAGE);
						
						editOption.toLowerCase();
						switch(editOption) {
						case "n":
							customer_name[i] = JOptionPane.showInputDialog("Enter new name:");
							break;
						case "a":
							customer_age[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter new age:"));
							break;
						case "g":
							customer_gender[i] = JOptionPane.showInputDialog("Enter new gender:");
							break;
						default:
							JOptionPane.showMessageDialog(null, "Invalid edit Option" , "Please Try again", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					
					if(!editFound) {
						 JOptionPane.showMessageDialog(null, "No customer found with ID " + editID);
					}
				}
				break;
				
			case "[D]elete Customer":
				 int deleteId = Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID to delete: "));
				    found = false;
				    
				    for (int i = 0; i < index; i++) {
				        if (customer_id[i] == deleteId) {
				            found = true;
				            for (int j = i; j < index - 1; j++) {
				                customer_id[j] = customer_id[j+1];
				                customer_name[j] = customer_name[j+1];
				                customer_age[j] = customer_age[j+1];
				                customer_gender[j] = customer_gender[j+1];
				            }
				            index--;
				            JOptionPane.showMessageDialog(null, "Customer record deleted");
				        }				
				  }
				    if (!found) {
				        JOptionPane.showMessageDialog(null, "No customer found with ID " + deleteId);
				    }
				    break;
			}
			
		}while(!choice.equals("[E]xit"));

	}

}