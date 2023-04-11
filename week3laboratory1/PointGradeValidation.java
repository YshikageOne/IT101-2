package week3laboratory1;

import javax.swing.JOptionPane;

public class PointGradeValidation {
	 public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		 
		//inputs yey
		 int studentId  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your Student ID:", "Student ID", JOptionPane.QUESTION_MESSAGE));
		 String name  = JOptionPane.showInputDialog(null, "Enter your name", "Name", JOptionPane.QUESTION_MESSAGE);
		 String department = JOptionPane.showInputDialog(null, "Enter your department", "Department", JOptionPane.QUESTION_MESSAGE);
		 String course  = JOptionPane.showInputDialog(null, "Enter your course", "Course", JOptionPane.QUESTION_MESSAGE);
		 String subject  = JOptionPane.showInputDialog(null, "Enter your subject", "Subject", JOptionPane.QUESTION_MESSAGE);
		 int score1  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your First Examination Score", "First", JOptionPane.QUESTION_MESSAGE));
		 int score2  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your Second Examination Score", "Second", JOptionPane.QUESTION_MESSAGE));
		 int score3  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your Third Examination Score", "Third", JOptionPane.QUESTION_MESSAGE));
		 int score4  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your Forth Examination Score", "Forth", JOptionPane.QUESTION_MESSAGE));
		 
		 //grading system
		 int average = (score1 + score2 + score3 + score4)/4;
		 float pointGrade = ((float)(110-average))/10;
		 
		 //Remarks 
		 String remarks = "";
		 if(average == 100) {
			 remarks = "Passed - Excellent";
		 }else if(average < 100) {
			 remarks = "Passed - Very Good";
		 }else if(average <= 90) {
			 remarks = "Passed - Average";
		 }else if(average <= 85) {
			 remarks = "Passed - Good";
		 }else if(average <= 80) {
			 remarks = "Passed - Satisfactory";
		 }else if(average <= 75) {
			 remarks = "Failed";
		 }else if(average <= 50) {
			 remarks = "Dropped";
		 }else if(average <= 0) {
			 remarks = "No such grade";
		 }
		 
		 //output
		 String output = ("********Student Details********" + 
		                "\nStudent ID         : " + studentId + 
		                "\nName               : " + name + 
		                "\nDepartment         : " + department +
		                "\nCourse             : " + course +
		                "\nSubject            : " + subject +
		                "\n********Grade Details**********" +
		                "\nFirst  Second  Third  Fourth" + "\n" +
		                String.format("%-6d  %-6d  %-6d  %-6d", score1, score2, score3, score4) +
		                "\nAverage            : " + average +
		                "\nPoint Grade        : " + pointGrade +
		                "\nRemarks            : " + remarks + 
		                "\nmade by me Mr.Clyde Allen Yu :D");
		 JOptionPane.showMessageDialog(null, output, "Average Result", JOptionPane.INFORMATION_MESSAGE);
  	
	}

}
