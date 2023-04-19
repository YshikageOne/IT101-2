package week5laboratory2;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FriendList {

	public static void main(String[] args) throws IOException {
		//made by me Mr.Clyde Allen Yu :D
		//user's choice]
		int userChoice;
		
		do {
			String choiceDialog = ("-----Friend's List-----" + 
                                   "\n[1] - Add Contacts" +
		                           "\n[2] - Display Friends over 18" + 
                                   "\n[3] - Display Friends" +
		                           "\n[4] - Exit");
            userChoice = (Integer.parseInt(JOptionPane.showInputDialog(null, choiceDialog, "Contact Book", JOptionPane.PLAIN_MESSAGE)));
            
            switch(userChoice) {
                case 1:
                	addContact();
                	break;
                case 2:
                	display18();
                	break;
                case 3:
                	display();
                	break;
                case 4:
                	System.exit(0);
                	break;
                default:
                	JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
           
		}while(userChoice != 4);

	}

	//methods for choices
	public static void addContact() throws IOException {
		//initialize the contact details
		
		JPanel panel1 = new JPanel(new GridLayout(6,2));
		
		JTextField newName = new JTextField();
		JTextField newAge = new JTextField();
		JTextField newBirthdate = new JTextField();
		JTextField newGender = new JTextField();
		JTextField newContactNum = new JTextField();
		JTextField newRemarks = new JTextField();
		
		panel1.add(new JLabel("Enter name:"));
	    panel1.add(newName);
	    
	    panel1.add(new JLabel("Enter age:"));
	    panel1.add(newAge);
	    
	    panel1.add(new JLabel("Enter birthdate:"));
	    panel1.add(newBirthdate);
	    
	    panel1.add(new JLabel("Enter Gender:"));
	    panel1.add(newGender);
	    
	    panel1.add(new JLabel("Enter Contact Number:"));
	    panel1.add(newContactNum);
	    
	    panel1.add(new JLabel("Enter Remarks:"));
	    panel1.add(newRemarks);
	    
	    //displaying the input
	    int input = JOptionPane.showConfirmDialog(null, panel1, "Contact Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    
	    if(input == JOptionPane.OK_OPTION) {
	    	//adding them into the text file
	    	String name, birthdate, gender, contactNum, remarks;
	    	byte age;
	    	
	    	name = newName.getText();
	    	birthdate = newBirthdate.getText();
	    	gender = newGender.getText();
	    	contactNum = newContactNum.getText();
	    	remarks = newRemarks.getText();
	    	age = Byte.parseByte(newAge.getText());
	    	
	            String contactInfo = String.format("%-10s%-20s%-10s%-10d%-15s%-10s", name, birthdate, gender, age, contactNum,
	                remarks);
	    	    try {
	    	        FileWriter fileWriter = new FileWriter("phonebook.txt", true);	
	    	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    	        PrintWriter printWriter = new PrintWriter(bufferedWriter);

	    	        printWriter.println(contactInfo);
	    	        printWriter.close();
	    	        JOptionPane.showMessageDialog(null, "Contact added successfully!");
	    	    } catch (IOException e) {
	    	        JOptionPane.showMessageDialog(null, "Error adding contact: " + e.getMessage());
	    	    }
	    }
	}
	
	public static void display() throws IOException {
		// read and display all contacts
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("phonebook.txt"));
			String line;
			boolean found = false;
			StringBuilder contacts = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				contacts.append(line).append("\n");
				found = true;
			}
			bufferedReader.close();

			if (found) {
				JOptionPane.showMessageDialog(null, "All Contacts:\n" + contacts.toString());
			} else {
				JOptionPane.showMessageDialog(null, "No friends found.");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading file. Please try again.");
		}
	}
	public static void display18() throws IOException {
		// read and display contacts over 18 years old
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("phonebook.txt"));
			String line;
			boolean found = false;
			StringBuilder contacts = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split("\\s+");
				if (parts.length > 3 && parts[3].matches("\\d+")) { // check if age is a number
					int age = Integer.parseInt(parts[3]);
					if (age > 18) {
						contacts.append(line).append("\n");
						found = true;
					}
				}
			}
			bufferedReader.close();
			if (found) {
				JOptionPane.showMessageDialog(null, "Contacts over 18 years old:\n" + contacts.toString());
			} else {
				JOptionPane.showMessageDialog(null, "No friends found over 18 years old.");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading file. Please try again.");
		}
	}
}
	
	

