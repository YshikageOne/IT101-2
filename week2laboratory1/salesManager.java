package week2laboratory1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class salesManager {
	//made by me Mr.Clyde Allen Yu :D
	public static void main(String[] args) {
		//Company Name
		String companyName = "Kanye's Records - Bro Made Graduation.";
		
		//Year
		int year = 2023;
		
		//Name of the file
		String fileName = "Sales.txt";
		
		//Months as a String Array
		String[] months = {"January", "February", "March", "April", "May", "June",
		          "July", "August", "September", "October", "November", "December"};
		
		//Seperator and header for the output
		String header = String.format("%-9s %-19s %-19s %s\n", "Month", "Gross Income", "Total Expenses", "Net Income");
           
        //Input panel
           JPanel inputPanel = new JPanel(new GridLayout(0, 3));
           
           for (int i = 0; i < months.length; i++) {
        	    inputPanel.add(new JLabel(months[i]));
        	    inputPanel.add(new JTextField());  //Gross Income
        	    inputPanel.add(new JTextField());  //Total Expenses
        	}
           
           int result = JOptionPane.showConfirmDialog(null, inputPanel, "Enter Sales Data", JOptionPane.OK_CANCEL_OPTION);
           
           StringBuilder monthOutput = new StringBuilder();
           if(result == JOptionPane.OK_OPTION) {
              //Initializing the total values
              double totalIncome = 0.0;
	          double totalExpenses = 0.0;
	          double totalNetIncome = 0.0;
	          
	          //loop for each month
	          for(int i = 0; i < months.length; i++) {
	        	    String month = months[i];
	                double income = Double.parseDouble(((JTextField) inputPanel.getComponent(i * 3 + 1)).getText());
	                double expenses = Double.parseDouble(((JTextField) inputPanel.getComponent(i * 3 + 2)).getText());
	                double netIncome = income - expenses;
	                
	               //updating the total for each loop
	                totalIncome += income;
	                totalExpenses += expenses;
	                totalNetIncome += netIncome;
	                
	               //add output to the current month
	                String eachMonth = String.format("%-9s $%,15.2f    $%,15.2f      $%,15.2f\n", month, income, expenses, netIncome);
	                monthOutput.append(eachMonth); 
	                
	          }
	          
	          //Total Line output
	          String totalOutput = String.format("%-9s $%,15.2f    $%,15.2f      $%,15.2f\n", "TOTAL", totalIncome, totalExpenses, totalNetIncome);
	          monthOutput.append(totalOutput);
	          monthOutput.insert(0, header);
              
	         //Display the final output 
	         String output = ("*********" + companyName + "***********" + 
	     			 "\nYear : " + year + 
	     			 "\n**********************************************************" + 
	     			 "\n" + monthOutput.toString() + 
	     			 "\n**********************************************************" +
	     			 "\nmade by me Mr.Clyde Allen Yu :D");
	     	JOptionPane.showMessageDialog(null, output, "RESULTS ARE IN", JOptionPane.PLAIN_MESSAGE);  
	     	
	     // Asking if the user wants to store the info in a file
    		
    		int answer = JOptionPane.showConfirmDialog(null, "Do you want to store your information in a file?", "Answer the questions pls", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    		
    		if(answer == JOptionPane.YES_OPTION) {
    			try {
    				BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    				writer.write(output);
    	            writer.close();
    	            JOptionPane.showMessageDialog(null, "Information saved to file.", "Saved", JOptionPane.PLAIN_MESSAGE);
    			} catch (IOException e) {
    				JOptionPane.showMessageDialog(null, "error", "error", JOptionPane.ERROR_MESSAGE);
    			}
    		} else if(answer == JOptionPane.NO_OPTION) {
    			JOptionPane.showMessageDialog(null, "Understandable, have a nice day", "Ok", JOptionPane.PLAIN_MESSAGE);
    		}
           }		

	}

}
