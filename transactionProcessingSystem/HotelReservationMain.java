package transactionProcessingSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import week10laboratory1.MainDataBase;

import java.awt.*;

public class HotelReservationMain extends Frame implements ActionListener, ItemListener, MouseListener, KeyListener, WindowListener{
	
     // data fields
     private JLabel ReservationRoomNum, GuestName, RoomType, RoomPrice, FinalPrice , Search; //label that would appear on the program(used as a LABEL to what input is which)
     private JTextField txtReservationRoomNum, txtGuestName, txtRoomPrice, txtSearch, txtFinalPrice; //this is for the text boxes that would be putted with int or String
     private JComboBox cboRoomNumber ,cboRoomType; //selection box
     private Font f = new Font("Tahoma", Font.BOLD, 16); //standard font that would be used
     private JButton Add, Clear, Update, Delete, Close;//Buttons
     private Choice checkInMonth, checkInDay, checkInYear, checkOutMonth,checkOutDay,checkOutYear; //provides a simple dropdown menu
   
     // data field for the table
     private JTable reservationTable; 
     // table access and manipulation
     private DefaultTableModel model_reservation;
     private Vector columns, rowData;
     private TableRowSorter sortTable;
     
     //private Database db = new Database("HotelReservation.txt");
     private JPanel panelReservationInfo, panelDates, panelPrice ,panelButtons, panelSearch, panelTable;
     
     //Database
     private Database db = new Database("Reservation.txt");
     
     //above are initialization of all of the variables needed for the program
     
     //constructor
     public HotelReservationMain() {
    	 initializedComponents();
    	 //calling in the methods
    	 reservationInfo();
    	 reservationButtons();
    	 
    	 add(reserveTable()).setBounds(320,50,660,360);
    	 add(panelButtons).setBounds(40,440,600,30);
    	 add(reservationPrice()).setBounds(10,360,300,50);
    	 add(reservationSearch()).setBounds(320,20,300,30);
    	 add(reservationDates()).setBounds(10,260,300,100);
    	 add(panelReservationInfo).setBounds(10,10,300,250);
    	 add(setBackgroundImage("images/hotel.jpg"));
       	 setFrame("Hotel Reservation", 1024, 576, true,DISPOSE_ON_CLOSE,false);
       	 
       	txtReservationRoomNum.setText(String.valueOf(getRowCount()));
       	txtSearch.addKeyListener(this);
       	txtGuestName.addKeyListener(this);
       	//register the buttons to the ActionListener
       	Add.addActionListener(this);
       	Clear.addActionListener(this);
       	Update.addActionListener(this);
       	Delete.addActionListener(this);
       	Close.addActionListener(this);
       	
       	reservationTable.addMouseListener(this);
       	addWindowListener(this);
       	
       	db = new Database ("Reservation.txt");
       	db.displayRecords(model_reservation);
       	resetComponents();
     }
     
     //Initializing
     public void initializedComponents() {
    	ReservationRoomNum = new JLabel("Hotel Room Number: ");
    	GuestName = new JLabel("Guest Name: ");
    	RoomType = new JLabel("Room Type: ");
    	new JLabel("Check-in Date: ");
        new JLabel("Check-out Date: ");
    	RoomPrice = new JLabel("Room Price: ");
    	
    	//input text field
    	txtReservationRoomNum = new JTextField(20);
    	txtReservationRoomNum.setEditable(false);
   	    
   	    txtGuestName = new JTextField();
	    txtRoomPrice = new JTextField();
	    txtRoomPrice.setEditable(false);
	    
	    //combo box to choose what room
   	    cboRoomType = new JComboBox(new String[] { "Single", "Double", "Suite" });
   	    //make the room type connected to the price
   	    cboRoomType.addItemListener(this);
   	    
   	    //buttons
   	    Add = new JButton("Add");
   	    Clear = new JButton("Clear");
   	    Update = new JButton("Update");
   	    Delete = new JButton("Delete");
     	Close = new JButton("Close");
   	    
     }
     
     //adding components to the main panel
     public void reservationInfo() {
    	 panelReservationInfo = new JPanel();
    	 panelReservationInfo.setBorder(BorderFactory.createTitledBorder("Reservation Information"));
    	 panelReservationInfo.setLayout(new GridLayout(4,2));
    	 panelReservationInfo.setFont(f);
    	 panelReservationInfo.setOpaque(false);
    	 
    	 //adding components
    	 ReservationRoomNum = new JLabel("Hotel Room Number: ");
    	 panelReservationInfo.add(ReservationRoomNum);
    	 
    	//JComboBox for selecting the room number
    	    cboRoomNumber = new JComboBox<Integer>();
    	    //add room numbers 1 to 100 to the combo box
    	    for (int i = 1; i <= 100; i++) {
    	    	cboRoomNumber.addItem(i);
    	    }
    	    panelReservationInfo.add(cboRoomNumber);
    	    
    	    GuestName = new JLabel("Guest Name: ");
    	    panelReservationInfo.add(GuestName);
    	    panelReservationInfo.add(txtGuestName);
    	    
    	    RoomType = new JLabel("Room Type: ");
    	    panelReservationInfo.add(RoomType);
    	    panelReservationInfo.add(cboRoomType);
    	    
    	    RoomPrice = new JLabel("Room Price(Per Night): ");
    	    panelReservationInfo.add(RoomPrice);
    	    panelReservationInfo.add(txtRoomPrice);
     }
     
     //Methods for the check in and check out dates
     public JPanel reservationDates() {
    	    panelDates = new JPanel();
    	    panelDates.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    	    panelDates.setBorder(BorderFactory.createTitledBorder("Reservation Dates"));
    	    
    	    //Get current date
    	    Calendar calendar = Calendar.getInstance();
    	    int currentYear = calendar.get(Calendar.YEAR);
    	    int currentMonth = calendar.get(Calendar.MONTH);
    	    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
    	    
    	    //Check-in date choice boxes
    	    JLabel checkInLabel = new JLabel("Check-in:");
    	    checkInMonth = new Choice();
    	    checkInDay = new Choice();
    	    checkInYear = new Choice();
    	    
    	    //Populate check-in month choice box
    	    String[] monthNames = new DateFormatSymbols().getMonths();
    	    
    	    for (int i = 0; i < monthNames.length - 1; i++) {
    	        checkInMonth.add(monthNames[i]);
    	    }
    	   
    	    
    	    //Populate check-in day choice box
    	    for (int i = 1; i <= 31; i++) {
    	        checkInDay.add(String.valueOf(i));
    	    }
    	  
    	    
    	    //Populate check-in year choice box
    	    for (int i = currentYear; i <= currentYear + 1; i++) {
    	        checkInYear.add(String.valueOf(i));
    	    }
    	    
    	    //Setting the default values to the current date
    	    checkInMonth.select(currentMonth);
    	    checkInDay.select(String.valueOf(currentDay));
    	    checkInYear.select(String.valueOf(currentYear));
    	    
    	    //the -> is a lambda expression for 
    	    /*checkInMonth.addItemListener(new ItemListener() {
    	     *   public void itemStateChanged(ItemEvent e) {
                      updateFinalPrice();
               }
    	     */
    	    
    	    checkInMonth.addItemListener(e -> updateFinalRoomPrice());
    	    checkInDay.addItemListener(e -> updateFinalRoomPrice());
    	    checkInYear.addItemListener(e -> updateFinalRoomPrice());
    	    
    	    // Check-out date choice boxes
    	    JLabel checkOutLabel = new JLabel("Check-out:");
    	    checkOutMonth = new Choice();
    	    checkOutDay = new Choice();
    	    checkOutYear = new Choice();
    	    
    	    
    	    for (int i = 0; i < monthNames.length - 1; i++) {
    	        checkOutMonth.add(monthNames[i]);
    	    }
    	    
    	    for (int i = 1; i <= 31; i++) {
    	        checkOutDay.add(String.valueOf(i));
    	    }
    	    
    	    
    	    for (int i = currentYear; i <= currentYear + 1; i++) {
    	        checkOutYear.add(String.valueOf(i));
    	    }
    	    
    	    //Setting the default values to the current date
    	    checkOutMonth.select(currentMonth);
    	    checkOutDay.select(String.valueOf(currentDay));
    	    checkOutYear.select(String.valueOf(currentYear));
    	    
    	    checkOutMonth.addItemListener(e -> updateFinalRoomPrice());
    	    checkOutDay.addItemListener(e -> updateFinalRoomPrice());
    	    checkOutYear.addItemListener(e -> updateFinalRoomPrice());
    	    
    	    panelDates.add(checkInLabel);
    	    panelDates.add(checkInMonth);
    	    panelDates.add(checkInDay);
    	    panelDates.add(checkInYear);
    	    
    	    panelDates.add(checkOutLabel);
    	    panelDates.add(checkOutMonth);
    	    panelDates.add(checkOutDay);
    	    panelDates.add(checkOutYear);
    	    
    	    
    	    return panelDates;
     }
     
     //Methods for the buttons
     public void reservationButtons() {
    	 panelButtons = new JPanel();
    	 panelButtons.setLayout(new GridLayout(1, 5, 4, 2));
    	    
    	//Set the opaque property of each button
    	Add.setOpaque(true);
        Clear.setOpaque(true);
    	Update.setOpaque(true);
        Delete.setOpaque(true);
        Close.setOpaque(true);
    	    
    	panelButtons.add(Add);
    	panelButtons.add(Clear);
    	    
        //Add an empty JLabel to create the transparent gap
        JLabel gapLabel = new JLabel(new ImageIcon("images/hotel.jpg"));
        gapLabel.setOpaque(false);
    	panelButtons.add(gapLabel);
    	    
    	panelButtons.add(Update);
        panelButtons.add(Delete);
    	panelButtons.add(Close);
    }   
       
     //Method that would search a specifc reservation
     public JPanel reservationSearch() {
    	 panelSearch = new JPanel();
    	 Search = new JLabel("Search:");
    	 txtSearch = new JTextField(10);
    	 panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 1));
    	 
    	 panelSearch.add(Search);
    	 panelSearch.add(txtSearch);
    	 panelSearch.setOpaque(false);
    	 
    	 return panelSearch;
     }
     
     //Method that would display the final price
     public JPanel reservationPrice() {
    	 panelPrice = new JPanel();
    	 panelPrice.setLayout(new FlowLayout(FlowLayout.LEFT));
 	     panelPrice.setBorder(BorderFactory.createTitledBorder("Final Price"));
 	     
 	     //label and text fields for the Final Price
 	     FinalPrice = new JLabel("Final Price: ");
 	     txtFinalPrice = new JTextField(10);
 	     txtFinalPrice.setEditable(false);
 	     panelPrice.add(FinalPrice); panelPrice.add(txtFinalPrice);

 	     
 	     return panelPrice;
     }
     
     //Method that updates the price of Room based on what room type
     public void updateRoomPrice() {
    	 String selectedRoomType = cboRoomType.getSelectedItem().toString();
    	 String roomPrice = "";
    	 
    	 switch(selectedRoomType) {
    	 case "Single":
    		 roomPrice = "$50";
    		 break;
    	 case "Double":
    		 roomPrice = "$75";
    		 break;
    	 case "Suite":
    		 roomPrice = "$100";
    		 break;
    	 }
    	 
    	 txtRoomPrice.setText(roomPrice);
     }
     
     //Method that updates the final price based on what room type and how long the guest would stay
     public void updateFinalRoomPrice() {
    	 //Getting the room type
    	 String roomType = cboRoomType.getSelectedItem().toString();
    	 int finalPrice = 0;
    	 
    	 switch(roomType) {
    	 case "Single":
    		 finalPrice = 50;
    		 break;
    	 case "Double":
    		 finalPrice = 75;
    		 break;
    	 case "Suite":
    		 finalPrice = 100;
    		 break;
    	 }
      //Get the check-in and check-out dates
    	int checkInMonthIndex = checkInMonth.getSelectedIndex();
    	int checkInDayIndex = Integer.parseInt(checkInDay.getSelectedItem().toString());
    	int checkInYearIndex = Integer.parseInt(checkInYear.getSelectedItem().toString());
    	int checkOutMonthIndex = checkOutMonth.getSelectedIndex();
        int checkOutDayIndex = Integer.parseInt(checkOutDay.getSelectedItem().toString());
    	int checkOutYearIndex = Integer.parseInt(checkOutYear.getSelectedItem().toString());
    
     //Calculate the number of days between check-in and check-out
        LocalDate checkInDate = LocalDate.of(checkInYearIndex, checkInMonthIndex + 1, checkInDayIndex);
        LocalDate checkOutDate = LocalDate.of(checkOutYearIndex, checkOutMonthIndex + 1, checkOutDayIndex);
        long diffInDays = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        
     //Calculate the final price
        int totalPrice = finalPrice * (int)diffInDays;
        
     //Display the final price
        txtFinalPrice.setText("$" + totalPrice);
    	 
    	 
     }
     
     //Method that displays the frame
     public JPanel reserveTable() {
    	 panelTable = new JPanel();
    	 reservationTable = new JTable();
    	 model_reservation = new DefaultTableModel();
    	 
    	 panelTable.setLayout(new BorderLayout());
    	 panelTable.add(new JScrollPane(reservationTable), BorderLayout.CENTER);
    	 
    	 String cols[] = {"Room Number" , "Guest Name", "Room Type", "Check-In Date", "Check-Out Date",
    			          "Final Price"};
    	 
    	 columns = new Vector<>();
 		 //for each loop to store array elements to vector columns
 		 for(String val:cols) {
 			columns.add(val);
 		 }
 		
 		 //set column to table via DefaultTableModel
 		 model_reservation.setColumnIdentifiers(columns);
 		 //sets the column names of the table to the values stored in the columns vector.
 		
 		 //binding the table to the DefaultTableModel
 		 reservationTable.setModel(model_reservation);
 		 //This binds the table to the model, which means any changes made to the model will be reflected in the table
 		
 		 return panelTable;
    	 
     }
     
     //getting the inputs
     public void getData() {
    	    rowData = new Vector<String>();
    	    rowData.add(String.valueOf(cboRoomNumber.getSelectedItem()));
    	    rowData.add(txtGuestName.getText());
    	    rowData.add(cboRoomType.getSelectedItem().toString());

    	    //add check-in date to rowData vector
    	    String selectedCheckInMonth  = checkInMonth.getSelectedItem();
    	    String selectedCheckInDay = checkInDay.getSelectedItem();
    	    String selectedCheckInYear  = checkInYear.getSelectedItem();
    	    String checkInDate = selectedCheckInMonth + " " + selectedCheckInDay + ", " + selectedCheckInYear;
    	    rowData.add(checkInDate);

    	    //add check-out date to rowData vector
    	    String selectedCheckOutMonth = checkOutMonth.getSelectedItem();
    	    String selectedCheckOutDay = checkOutDay.getSelectedItem();
    	    String selectedCheckOutYear = checkOutYear.getSelectedItem();
    	    String checkOutDate = selectedCheckOutMonth + " " + selectedCheckOutDay + ", " + selectedCheckOutYear;
    	    rowData.add(checkOutDate);

    	    rowData.add(txtFinalPrice.getText());
    	}
     
     public static void main (String[] args) {
    	 new HotelReservationMain();
     }
     
     //method that returns the current number of records
     public int getRowCount() {
    	 return model_reservation.getRowCount();
     }

     //whenever the table is clicked, the update and delete buttons are enabled
 	 public void tableClick() {
 		Add.setEnabled(false);
 		Update.setEnabled(true);
 		Delete.setEnabled(true);
 	}
     
     public void itemStateChanged(ItemEvent e) {
         if (e.getStateChange() == ItemEvent.SELECTED) {
             updateRoomPrice();
         }	
  	}

    
	
	 public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Add)) {
			//Checker if a room number is already claimed or not
	 	 	int selectedRoomNum = (int) cboRoomNumber.getSelectedItem(); //gets the selected number from the combo box
	 	 	
	 	 	//looping through each row in the table
	 	 	for(int i = 0; i < model_reservation.getRowCount(); i++) {
	 	 		//retrieves the room number from the column and turns it into a integer
	 	 		int roomNum = Integer.parseInt(model_reservation.getValueAt(i, 0).toString());
	 	 		if(roomNum == selectedRoomNum) {
	 	 			JOptionPane.showMessageDialog(this, "Room number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
	 	            return;
	 	 		}
	 	 	}
			 
			getData();
			model_reservation.addRow(rowData);
			txtReservationRoomNum.setText(String.valueOf(cboRoomNumber.getSelectedItem()));
			resetComponents();
			
		}else if(e.getSource().equals(Clear)){
			resetComponents();
		}else if(e.getSource().equals(Update)){
			//update button
			int i = reservationTable.getSelectedRow();
			
			//loop way
			getData();
			for(int col = 1; col < reservationTable.getColumnCount(); col++) {
				reservationTable.setValueAt(rowData.get(col), i, col);
			}
			resetComponents();
			
		}else if(e.getSource().equals(Delete)){
			
			int i = reservationTable.getSelectedRow();
			model_reservation.removeRow(i);
			
		}else if(e.getSource().equals(Close)){
			process();
			System.exit(0);
		}
		
	}
	 
	public void process() {
		String records = "";
		for(int row = 0; row < model_reservation.getRowCount(); row++) {
			for(int column = 0; column < model_reservation.getColumnCount(); column++) {
				records +=  model_reservation.getValueAt(row, column) + "#";
			}
			records += "\n";
	    }
		db.storeToFile(records);
	}	
	
	//Method that resets the input to the default values
	public void resetComponents() {
		
		Add.setEnabled(true);
		Clear.setEnabled(true);
		Close.setEnabled(true);
		
		Update.setEnabled(false);
		Delete.setEnabled(false);
		
		txtGuestName.setText("");
		
	}
	
	public void mouseClicked(MouseEvent e) {
	    if (e.getSource().equals(reservationTable)) {
	        int i = reservationTable.getSelectedRow();
	        getData();

	        //room number
	        cboRoomNumber.setSelectedItem(reservationTable.getValueAt(i, 0) + "");

	        //guest name
	        txtGuestName.setText(reservationTable.getValueAt(i, 1) + "");

	        //room type
	        cboRoomType.setSelectedItem(reservationTable.getValueAt(i, 2) + "");

	        //final price
	        txtFinalPrice.setText(reservationTable.getValueAt(i, 5) + "");

	        //update combo box with selected room number
	        //gets the value of the first column of the selected row in the reservationTable, which is the room number in this case
	        int selectedRoomNumber = Integer.parseInt(reservationTable.getValueAt(i, 0).toString());
	        //since the room numbers in the combo box start at 1 but the index starts at 0, the index needs to be shifted by one
	        cboRoomNumber.setSelectedIndex(selectedRoomNumber - 1);
	        
	        //Check-in
	        String checkInDate = reservationTable.getValueAt(i, 3).toString();
	        String[] checkInParts = checkInDate.split(" ");
	        checkInMonth.select(checkInParts[0]);
	        checkInDay.select(checkInParts[1].replace(",", ""));
	        checkInYear.select(checkInParts[2]);

	        
	        //Check-out
	        String checkOutDate = reservationTable.getValueAt(i, 4).toString();
	        String[] checkOutParts = checkOutDate.split(" ");
	        checkOutMonth.select(checkOutParts[0]);
	        checkOutDay.select(checkOutParts[1].replace(",", ""));
	        checkOutYear.select(checkOutParts[2]);
	        
	        tableClick();

	    }
	}

	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Error catcher
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(txtGuestName)) {
			char ch = e.getKeyChar();
			if(!((Character.isWhitespace(ch) || e.getKeyChar() >= 'a' || e.getKeyChar() >= 'A' 
					&& (e.getKeyChar() <= 'z' || e.getKeyChar() <= 'Z')))) {
				e.consume();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(txtSearch)) {
			String search = txtSearch.getText();
			
			sortTable = new TableRowSorter(model_reservation);
			reservationTable.setRowSorter(sortTable);
			
			sortTable.setRowFilter(RowFilter.regexFilter(search, 0));
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {
		process();
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		process();
		System.exit(0);	
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
