package transactionProcessingSystem;

import java.io.*;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import week10laboratory1.MainDataBase;

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
			new MainDataBase(filename);
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
						row.add(data[i]);
					}
					model.addRow(row);
				}
			}catch(Exception e) {
				errorMessage("Error 102: displayRecords\n"+e.getMessage());
			}
		}
}
