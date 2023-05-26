package transactionProcessingSystem;

import java.io.*;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Database {
	private File file=null;
	private FileWriter fWrite=null;
	private FileReader fRead=null;
	private Scanner scan=null;
	private Vector<String> row, column;
	
	//parameterized constructor w/c sets the filename of a textfile
	public Database(String filename) {
		file=new File(filename);
		}
	
	//another option for setting a filename
	public void setFilename(String filename) {
		new Database(filename);
		}
	
	//when you want to read or get the name of the file
	public String getFilename(String filename) {
		return file.getName();
	}
	
	//error message
	public void errorMessage(String msg) {
		JOptionPane.showMessageDialog(null,msg,"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	//Storing the info to a file
	public void storeToFile(String records) {
		try {
			fWrite = new FileWriter(file);
			fWrite.write(records);
			fWrite.flush();
		}catch(Exception e) {
			errorMessage("Error 101: storeToFile\n"+e.getMessage());
		}

	}
	
	public void displayRecords(DefaultTableModel model) {
		try {
			fRead = new FileReader(file);
			scan = new Scanner(fRead);
			
			//array object use to extract data
			String data[];
			while(scan.hasNext()) {
				//extract each value via the delimter
				data = scan.nextLine().split("#");
				row = new Vector<String>();
				for(int i = 0; i < model.getColumnCount(); i++) {
					//read each record based column count of the table store to a vector
					 if (i < data.length) {
					        row.add(data[i]);
					    } else {
					        row.add(""); // or handle the case where data is missing or incomplete
					    }
				}
				model.addRow(row);
			}
		}catch(Exception e) {
			errorMessage("Error 102: displayRecords\n"+e.getMessage());
		}
	}

	//Loading the values from the txt files to your comboBox
	public void fillToComboBox(JComboBox<String> combo) {
		try {
			fRead = new FileReader(file);
			scan = new Scanner(fRead);
			while(scan.hasNext()) {
				combo.addItem(scan.nextLine());
			}
			
		}catch(Exception e) {
			errorMessage("Error 103: filltoComboBox\n"+e.getMessage());
		}
	}
}
