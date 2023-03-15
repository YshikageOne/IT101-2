package week2laboratory1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class studentRecord {
	//made by me Mr.Clyde Allen Yu :D
	public static void main(String[] args) {
		//input layout
		JPanel layout1 = new JPanel(new GridLayout(3,2));
		JPanel layout2 = new JPanel(new GridLayout(4,4));
		
		JTextField studentName = new JTextField();
		JTextField program = new JTextField();
		JTextField course = new JTextField();
		
		JTextField firstGrade = new JTextField();
		JTextField secondGrade = new JTextField();
		JTextField thirdGrade = new JTextField();
		JTextField forthGrade = new JTextField(); 
		
		layout1.add(new JLabel("Student's Name     :"));
	    layout1.add(studentName);
	     
	    layout1.add(new JLabel("Program                  :"));
	    layout1.add(program);
	     
	    layout1.add(new JLabel("Course                     :"));
	    layout1.add(course);
	    
	    layout2.add(new JLabel("First           :"));
	    layout2.add(firstGrade);
	    
	    layout2.add(new JLabel("Second     :"));
	    layout2.add(secondGrade);
	    
	    layout2.add(new JLabel("Third          :"));
	    layout2.add(thirdGrade);
	    
	    layout2.add(new JLabel("Forth          :"));
	    layout2.add(forthGrade);
	    
	    //Displaying input prompt
	    
	    int result1 = JOptionPane.showConfirmDialog(null, layout1, "Student Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    
	    if(result1 == JOptionPane.OK_OPTION) {
	    	int result2 = JOptionPane.showConfirmDialog(null, layout2, "Student Grades", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    	
	    	if(result2 == JOptionPane.OK_OPTION) {
	    		//Average Grade and Remarks
	    		float grade1, grade2, grade3, grade4;
	    		grade1 = Float.parseFloat(firstGrade.getText());
	    		grade2 = Float.parseFloat(secondGrade.getText());
	    		grade3 = Float.parseFloat(thirdGrade.getText());
	    		grade4 = Float.parseFloat(forthGrade.getText());
	    		
	    		float average = (grade1 + grade2 + grade3 + grade4) / 4;
	    		
	    		String remarks;
	    		if (average >= 75) {
	    			remarks = "Passed";
	    		} else {
	    			remarks = "Failed";
	    		}
	    		
	    		//Displaying the output
	    		
	    		String output = ("-----------------------------------------------------" + 
	    				         "\nStudent's Name     : " + studentName.getText() +
		                         "\nProgram                  : " + program.getText() +
		                         "\nCourse                     : " + course.getText() + 
		         
		                         "\n\n1st        2nd        3rd       4th" + "\n" +
		                         firstGrade.getText() + "    " +
		                         secondGrade.getText() + "    " +
		                         thirdGrade.getText() + "    " + 
		                         forthGrade.getText() + "    " + 
		                         
		                         "\n\nAverage     : " + String.format("%.2f", average) + 
		                         "\nRemarks     : " + remarks +
		                         "\nmade by me Mr.Clyde Allen Yu :D" +
		                         "\n-----------------------------------------------------" );
	    		
	    		JOptionPane.showMessageDialog(null, output, "Results", JOptionPane.INFORMATION_MESSAGE);
	    		
	    		// Asking if the user wants to store the info in a file
	    		
	    		int answer = JOptionPane.showConfirmDialog(null, "Do you want to store your student's information in a file?", "Answer the questions pls", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    		
	    		if(answer == JOptionPane.YES_OPTION) {
	    			try {
	    				BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"));
	    				writer.write("Name: " + studentName.getText());
	    	            writer.newLine();
	    	            writer.write("Program: " + program.getText());
	    	            writer.newLine();
	    	            writer.write("Course: " + course.getText());
	    	            writer.newLine();
	    	            writer.write("First Grade: " + firstGrade.getText());
	    	            writer.newLine();
	    	            writer.write("Second Grade: " + secondGrade.getText());
	    	            writer.newLine();
	    	            writer.write("Third Grade: " + thirdGrade.getText());
	    	            writer.newLine();
	    	            writer.write("Forth Grade: " + forthGrade.getText());
	    	            writer.newLine();
	    	            writer.write("Average: " + average);
	    	            writer.newLine();
	    	            writer.write("Remarks: " + remarks);
	    	            writer.close();
	    	            JOptionPane.showMessageDialog(null, "Student information saved to file.", "Saved", JOptionPane.PLAIN_MESSAGE);
	    			} catch (IOException e) {
	    				JOptionPane.showMessageDialog(null, "error", "error", JOptionPane.ERROR_MESSAGE);
	    			}
	    		} else if(answer == JOptionPane.NO_OPTION) {
	    			JOptionPane.showMessageDialog(null, "Understandable, have a nice day", "Ok", JOptionPane.PLAIN_MESSAGE);
	    		}
	    	}
	    }

	}

}
