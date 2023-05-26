package betterTPS;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class HotelReservationMethod {
	
	private static Database db = new Database("Reserve.txt");
	
	//Method that would get set the dates to the current Date
		public JPanel reservationDatesAndPrice(JPanel panel, JComboBox CheckInDay, JComboBox CheckInMonth,
	            JComboBox CheckInYear, JComboBox CheckOutDay, JComboBox CheckOutMonth, JComboBox CheckOutYear,
	            JTextField finalPrice, JComboBox roomType) {
			
			//Get current date
		    Calendar calendar = Calendar.getInstance();
		    int currentYear = calendar.get(Calendar.YEAR);
		    int currentMonth = calendar.get(Calendar.MONTH);
		    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
			
		    //Populate check-in month choice box
		    String[] monthNames = new DateFormatSymbols().getMonths();
		    
		    for (int i = 0; i < monthNames.length - 1; i++) {
		        CheckInMonth.addItem(monthNames[i]);
		    }
		    
		    //Populate check-in day choice box
		    for (int i = 1; i <= 31; i++) {
		        CheckInDay.addItem(String.valueOf(i));
		    }
		    
		    //Populate check-in year choice box
		    for (int i = currentYear; i <= currentYear + 1; i++) {
		        CheckInYear.addItem(String.valueOf(i));
		    }
		    
		    //Setting the default values to the current date
		    CheckInMonth.setSelectedIndex(currentMonth);
		    CheckInDay.setSelectedItem(String.valueOf(currentDay));
		    CheckInYear.setSelectedItem(String.valueOf(currentYear));
		    
		    
		    CheckInMonth.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    CheckInDay.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    CheckInYear.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    
		    for (int i = 0; i < monthNames.length - 1; i++) {
		        CheckInMonth.addItem(monthNames[i]);
		    }
		    
		    //Populate check-in day choice box
		    for (int i = 1; i <= 31; i++) {
		        CheckInDay.addItem(String.valueOf(i));
		    }
		    
		    //Populate check-in year choice box
		    for (int i = currentYear; i <= currentYear + 1; i++) {
		        CheckInYear.addItem(String.valueOf(i));
		    }
		    
		    //Setting the default values to the current date
		    CheckInMonth.setSelectedIndex(currentMonth);
		    CheckInDay.setSelectedItem(String.valueOf(currentDay));
		    CheckInYear.setSelectedItem(String.valueOf(currentYear));
		    
		    
		    CheckInMonth.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    CheckInDay.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    CheckInYear.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    
		    
		    //Check out
		    for (int i = 0; i < monthNames.length - 1; i++) {
		        CheckOutMonth.addItem(monthNames[i]);
		    }
		    
		    //Populate check-in day choice box
		    for (int i = 1; i <= 31; i++) {
		        CheckOutDay.addItem(String.valueOf(i));
		    }
		    
		    //Populate check-in year choice box
		    for (int i = currentYear; i <= currentYear + 1; i++) {
		        CheckOutYear.addItem(String.valueOf(i));
		    }
		    
		    //Setting the default values to the current date
		    CheckOutMonth.setSelectedIndex(currentMonth);
		    CheckOutDay.setSelectedItem(String.valueOf(currentDay));
		    CheckOutYear.setSelectedItem(String.valueOf(currentYear));
		    
		    CheckOutMonth.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear, roomType));
		    CheckOutDay.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    CheckOutYear.addItemListener(e -> updateFinalRoomPrice(finalPrice, CheckInDay, CheckInMonth, CheckInYear, CheckOutDay, CheckOutMonth, CheckOutYear,roomType));
		    
			return panel;
		}

	//Method that would update the price based on the room type and the date between check-in and check out
		public void updateFinalRoomPrice(JTextField finalPrice, JComboBox CheckInDay, JComboBox CheckInMonth, 
	            JComboBox CheckInYear, JComboBox CheckOutDay, JComboBox CheckOutMonth , JComboBox CheckOutYear, JComboBox roomType) {
			
			//Getting the room type
			String chosenRoomType = roomType.getSelectedItem().toString();
			int finalRoomPrice = 0;
			
			switch(chosenRoomType) {
			case "Single":
			 finalRoomPrice = 50;
	   		 break;
	   	    case "Double":
	   	     finalRoomPrice = 100;
	   		 break;
	   	    case "Suite":
	   	     finalRoomPrice = 150;
	   		 break;
			}
			
			//Get the check-in and check-out dates
	    	int checkInMonthIndex = CheckInMonth.getSelectedIndex();
	    	int checkInDayIndex = Integer.parseInt(CheckInDay.getSelectedItem().toString());
	    	int checkInYearIndex = Integer.parseInt(CheckInYear.getSelectedItem().toString());
	    	int checkOutMonthIndex = CheckOutMonth.getSelectedIndex();
	        int checkOutDayIndex = Integer.parseInt(CheckOutDay.getSelectedItem().toString());
	    	int checkOutYearIndex = Integer.parseInt(CheckOutYear.getSelectedItem().toString());
	    	
	    	//Calculate the number of days between check-in and check-out
	        LocalDate checkInDate = LocalDate.of(checkInYearIndex, checkInMonthIndex + 1, checkInDayIndex);
	        LocalDate checkOutDate = LocalDate.of(checkOutYearIndex, checkOutMonthIndex + 1, checkOutDayIndex);
	        long diffInDays = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
	        
	        //Calculate the final price
	        int totalPrice = finalRoomPrice * (int)diffInDays;
	        
	        //Display the final price
	        finalPrice.setText("$" + totalPrice);
		}
		
		
    //Method that would change the room based on the type
		public void roomChange(JComboBox roomType, JComboBox roomNumber, JTextField txtRoomPrice) {
			String selectedRoomType = roomType.getSelectedItem().toString();
			String roomPrice = "$50";
			
			switch(selectedRoomType){
			case "Single":
				//adding the single rooms
				String[] singleRoom = new String[50];
				
				for(int i = 0; i < 50; i++) {
					singleRoom[i] = "S" + (i+1);
				}
				
				roomNumber.setModel(new DefaultComboBoxModel<>(singleRoom));
				roomPrice = "$50";
				break;
				
			case "Double":
				//adding the double rooms
				String[] doubleRoom = new String[50];
				
				for(int i = 0; i <50; i++) {
					doubleRoom[i] = "D" + (i + 1);
				}
				
				roomNumber.setModel(new DefaultComboBoxModel<>(doubleRoom));
				roomPrice = "$100";
				break;
				
			case "Suite":
				//adding the suite rooms
				String[] suiteRoom = new String[50];
				
				for(int i = 0; i < 50; i++) {
					suiteRoom[i] = "SS" + (i+1);
				}
				
				roomNumber.setModel(new DefaultComboBoxModel<>(suiteRoom));
				roomPrice = "$150";
				break;
			}
			
			txtRoomPrice.setText(roomPrice);
		}
		
    //Method that would save the table to a txt file
		public void process(DefaultTableModel model_reservation) {
			String records = "";
			for(int row = 0; row < model_reservation.getRowCount(); row++) {
				for(int column = 0; column < model_reservation.getColumnCount(); column++) {
					records +=  model_reservation.getValueAt(row, column) + "#";
				}
				records += "\n";
		    }
			db.storeToFile(records);
		}
		
	//Method that would get the input
		public void getData(Vector guestDetails, JTextField txtGuestName, JComboBox cboRoomType, JComboBox cboRoomNumber,
				            JComboBox cboCheckInMonth, JComboBox cboCheckInDay, JComboBox cboCheckInYear, JComboBox cboCheckOutMonth, JComboBox cboCheckOutDay,
				            JComboBox cboCheckOutYear, JTextField txtFinalPrice) {
			
			guestDetails.clear();
			
			guestDetails.add(txtGuestName.getText());
			guestDetails.add(cboRoomType.getSelectedItem().toString());
			guestDetails.add(cboRoomNumber.getSelectedItem().toString());
			
			//add check-in date to the table
    	    String selectedCheckInMonth  = (String) cboCheckInMonth.getSelectedItem();
    	    String selectedCheckInDay = (String) cboCheckInDay.getSelectedItem();
    	    String selectedCheckInYear  = (String) cboCheckInYear.getSelectedItem();
    	    String checkInDate = selectedCheckInMonth + " " + selectedCheckInDay + ", " + selectedCheckInYear;
    	    guestDetails.add(checkInDate);
    	    
    	    //add check-out date to the table
    	    String selectedCheckOutMonth  = (String) cboCheckOutMonth.getSelectedItem();
    	    String selectedCheckOutDay = (String) cboCheckOutDay.getSelectedItem();
    	    String selectedCheckOutYear  = (String) cboCheckOutYear.getSelectedItem();
    	    String checkOutDate = selectedCheckOutMonth + " " + selectedCheckOutDay + ", " + selectedCheckOutYear;
    	    guestDetails.add(checkOutDate);
    	    
    	    guestDetails.add(txtFinalPrice.getText());
		}
		
	//Method that resets the components of the input
		public void resetComponents(JButton btnAdd, JButton btnClear, JButton btnClose, JButton btnUpdate, JButton btnDelete,
				                    JTextField txtGuestName, JComboBox cboRoomNumber, JComboBox cboRoomType, JTextField txtRoomPrice, JTextField txtFinalPrice,
				                    JComboBox cboCheckInMonth, JComboBox cboCheckInDay, JComboBox cboCheckInYear, JComboBox cboCheckOutMonth, JComboBox cboCheckOutDay,
						            JComboBox cboCheckOutYear) {
			
			btnAdd.setEnabled(true);
    		btnClear.setEnabled(true);
    		btnClose.setEnabled(true);
    		
    		btnUpdate.setEnabled(false);
    		btnDelete.setEnabled(false);
    		
    		txtGuestName.setText("");
    		cboRoomNumber.setSelectedIndex(0);
    		cboRoomType.setSelectedIndex(0);
			
    		txtRoomPrice.setText("");
    		txtFinalPrice.setText("");
    		
    		//Get current date
    	    Calendar calendar = Calendar.getInstance();
    	    int currentYear = calendar.get(Calendar.YEAR);
    	    int currentMonth = calendar.get(Calendar.MONTH);
    	    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
    	    
    	    //Setting the default values to the current date
    	    cboCheckInMonth.setSelectedIndex(currentMonth);
    	    cboCheckInDay.setSelectedItem(String.valueOf(currentDay));
    	    cboCheckInYear.setSelectedItem(String.valueOf(currentYear));
    	    
    	    cboCheckOutMonth.setSelectedIndex(currentMonth);
    	    cboCheckOutDay.setSelectedItem(String.valueOf(currentDay));
    	    cboCheckOutYear.setSelectedItem(String.valueOf(currentYear));
		}
		
		//Button methods
				//ADD
				public void addDetails(JTextField txtGuestName, JComboBox cboRoomType, JComboBox cboRoomNumber, DefaultTableModel model_reservation,
						Vector guestDetails, JComboBox cboCheckInMonth, JComboBox cboCheckInDay, JComboBox cboCheckInYear, JComboBox cboCheckOutMonth, JComboBox cboCheckOutDay,
			            JComboBox cboCheckOutYear, JTextField txtFinalPrice, JButton btnAdd, JButton btnClear, JButton btnClose, JButton btnUpdate, JButton btnDelete, JTextField txtRoomPrice) {
					
					String guestName = txtGuestName.getText();
					String roomType = cboRoomType.getSelectedItem().toString();
					String roomNumber = cboRoomNumber.getSelectedItem().toString();
					
					//looping through each row in the table
			 	 	for(int i = 0; i < model_reservation.getRowCount(); i++) {
			 	 		//retrieves the room number from the column and turns it into a integer
			 	 		String roomNum = model_reservation.getValueAt(i, 2).toString();
			 	 		if(roomNum.equals(roomNumber)) {
			 	 			JOptionPane.showMessageDialog(null, "Room number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
			 	            return;
			 	 		} 
			 	 	}
			 	 	
			 	 	getData(guestDetails, txtGuestName, cboRoomType, cboRoomNumber, cboCheckInMonth, 
			 	 			cboCheckInDay, cboCheckInYear, cboCheckOutMonth, cboCheckOutDay, cboCheckOutYear, txtFinalPrice);
			 	 	
			 	 	model_reservation.addRow(guestDetails);
			 	 	
			 	 	resetComponents(btnAdd, btnClear, btnClose, btnUpdate, btnDelete, txtGuestName, cboRoomNumber,
			 	 			cboRoomType, txtRoomPrice, txtFinalPrice, cboCheckInMonth, cboCheckInDay, cboCheckInYear, cboCheckOutMonth, cboCheckOutDay, cboCheckOutYear);
				}
				
				//UPDATE
				public void updateDetails(JTable reservationTable, Vector guestDetails, JTextField txtGuestName, JComboBox cboRoomType, JComboBox cboRoomNumber,
			            JComboBox cboCheckInMonth, JComboBox cboCheckInDay, JComboBox cboCheckInYear, JComboBox cboCheckOutMonth, JComboBox cboCheckOutDay,
			            JComboBox cboCheckOutYear, JTextField txtFinalPrice, JButton btnAdd, JButton btnClear, JButton btnClose, JButton btnUpdate, JButton btnDelete, JTextField txtRoomPrice ) {
					
					//update button
					int i = reservationTable.getSelectedRow();
					
					//loop way
					getData(guestDetails, txtGuestName, cboRoomType, cboRoomNumber, cboCheckInMonth, 
			 	 			cboCheckInDay, cboCheckInYear, cboCheckOutMonth, cboCheckOutDay, cboCheckOutYear, txtFinalPrice);
					
					for(int col = 0; col < reservationTable.getColumnCount(); col++) {
						reservationTable.setValueAt(guestDetails.get(col), i, col);
					}
					resetComponents(btnAdd, btnClear, btnClose, btnUpdate, btnDelete, txtGuestName, cboRoomNumber,
			 	 			cboRoomType, txtRoomPrice, txtFinalPrice, cboCheckInMonth, cboCheckInDay, cboCheckInYear, cboCheckOutMonth, cboCheckOutDay, cboCheckOutYear);
				}
				
				//DELETE
				public void deleteDetails(JTable reservationTable, DefaultTableModel model_reservation) {
					
					int i = reservationTable.getSelectedRow();
					model_reservation.removeRow(i);
				}
 }
