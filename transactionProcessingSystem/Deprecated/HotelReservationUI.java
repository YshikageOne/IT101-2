package transactionProcessingSystem.Deprecated;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

public class HotelReservationUI extends JFrame implements ActionListener, MouseListener{
	private HotelReservationManager reservationManager;
    private DefaultTableModel reservationTableModel;
    private JTable reservationTable;
    private JTextField txtReservationRoomNum, txtGuestName, txtRoomPrice, txtSearch, txtFinalPrice;
    private JComboBox<Integer> cboRoomNumber;
    private JComboBox<String> cboRoomType;
    private JButton btnAdd, btnClear, btnUpdate, btnDelete, btnClose;
    private Choice checkInMonth, checkInDay, checkInYear, checkOutMonth, checkOutDay, checkOutYear;
    
    public HotelReservationUI() {
    	    reservationManager = new HotelReservationManager();
    	    initializeComponents();
    	    createReservationTable();
    	    setupUI();


    	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    setSize(1024, 576);
    	    setLocationRelativeTo(null);
    	    setResizable(false);
    	    setVisible(true);
    }
    
    private void initializeComponents() {
        txtReservationRoomNum = new JTextField(10);
        txtGuestName = new JTextField(20);
        txtRoomPrice = new JTextField(10);
        txtRoomPrice.setEditable(false);
        txtSearch = new JTextField(20);
        txtFinalPrice = new JTextField(10);
        txtFinalPrice.setEditable(false);

        cboRoomNumber = new JComboBox<>();
        cboRoomNumber.addActionListener(this);

        String[] roomTypes = { "Single", "Double", "Suite" };
        cboRoomType = new JComboBox<String>(roomTypes);
        cboRoomType.addActionListener(this);

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClose = new JButton("Close");

        checkInMonth = new Choice();
        checkInDay = new Choice();
        checkInYear = new Choice();
        checkOutMonth = new Choice();
        checkOutDay = new Choice();
        checkOutYear = new Choice();
        
        //register action listeners for buttons
        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnClose.addActionListener(this);
    }
    
    private void createReservationTable() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Room Number");
        columnNames.add("Guest Name");
        columnNames.add("Room Type");
        columnNames.add("Check-in Date");
        columnNames.add("Check-out Date");
        columnNames.add("Final Price");

        Vector<Vector<Object>> data = new Vector<>();

        reservationTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        reservationTable = new JTable(reservationTableModel);
        reservationTable.addMouseListener(this);
        reservationTable.setModel(reservationTableModel);
    }
    
    private void setupUI() {
        setLayout(null);
        setTitle("Hotel Reservation");

        int x = 40;
        int y = 10;
        int labelWidth = 120;
        int inputWidth = 150;
        int height = 30;

        JLabel lblReservationRoomNum = new JLabel("Hotel Room Number:");
        lblReservationRoomNum.setBounds(x, y, labelWidth, height);
        add(lblReservationRoomNum);

        cboRoomNumber.setBounds(x + labelWidth + 10, y, inputWidth, height);
        add(cboRoomNumber);

        JLabel lblGuestName = new JLabel("Guest Name:");
        lblGuestName.setBounds(x, y + 40, labelWidth, height);
        add(lblGuestName);
        txtGuestName.setBounds(x + labelWidth + 10, y + 40, inputWidth, height);
        add(txtGuestName);

        JLabel lblRoomType = new JLabel("Room Type:");
        lblRoomType.setBounds(x, y + 80, labelWidth, height);
        add(lblRoomType);

        cboRoomType.setBounds(x + labelWidth + 10, y + 80, inputWidth, height);
        add(cboRoomType);

        JLabel lblCheckInDate = new JLabel("Check-in Date:");
        lblCheckInDate.setBounds(x, y + 120, labelWidth, height);
        add(lblCheckInDate);

        checkInMonth.setBounds(x + labelWidth + 10, y + 120, 80, height);
        checkInDay.setBounds(x + labelWidth + 90, y + 120, 50, height);
        checkInYear.setBounds(x + labelWidth + 150, y + 120, 70, height);
        add(checkInMonth);
        add(checkInDay);
        add(checkInYear);

        JLabel lblCheckOutDate = new JLabel("Check-out Date:");
        lblCheckOutDate.setBounds(x, y + 160, labelWidth, height);
        add(lblCheckOutDate);

        checkOutMonth.setBounds(x + labelWidth + 10, y + 160, 80, height);
        checkOutDay.setBounds(x + labelWidth + 90, y + 160, 50, height);
        checkOutYear.setBounds(x + labelWidth + 150, y + 160, 70, height);
        add(checkOutMonth);
        add(checkOutDay);
        add(checkOutYear);

        JLabel lblRoomPrice = new JLabel("Room Price (Per Night):");
        lblRoomPrice.setBounds(x, y + 200, labelWidth, height);
        add(lblRoomPrice);

        txtRoomPrice.setBounds(x + labelWidth + 10, y + 200, inputWidth, height);
        add(txtRoomPrice);

        JLabel lblFinalPrice = new JLabel("Final Price:");
        lblFinalPrice.setBounds(x, y + 240, labelWidth, height);
        add(lblFinalPrice);

        txtFinalPrice.setBounds(x + labelWidth + 10, y + 240, inputWidth, height);
        add(txtFinalPrice);

        btnAdd.setBounds(40,440,600,30);
        add(btnAdd);

        btnClear.setBounds(40,440,600,30);
        add(btnClear);

        btnUpdate.setBounds(40,440,600,30);
        add(btnUpdate);

        btnDelete.setBounds(40,440,600,30);
        add(btnDelete);

        btnClose.setBounds(40,440,600,30);
        add(btnClose);

        JScrollPane scrollPane = new JScrollPane(reservationTable);
        scrollPane.setBounds(320, 50, 660, 360);
        add(scrollPane);
  }
  
    public void mouseClicked(MouseEvent e) {
  	// TODO Auto-generated method stub
  	
  }

    public void mousePressed(MouseEvent e) {
  	// TODO Auto-generated method stub
  	
  }

    public void mouseReleased(MouseEvent e) {
  	// TODO Auto-generated method stub
  	
  }

    public void mouseEntered(MouseEvent e) {
  	// TODO Auto-generated method stub
  	
  }

    public void mouseExited(MouseEvent e) {
  	// TODO Auto-generated method stub
  	
  }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAdd)) {
            addReservation();
        } else if (e.getSource().equals(btnClear)) {
            clearFields();
        } else if (e.getSource().equals(btnUpdate)) {
            updateReservation();
        } else if (e.getSource().equals(btnDelete)) {
            deleteReservation();
        } else if (e.getSource().equals(btnClose)) {
            closeApplication();
        } else if (e.getSource().equals(cboRoomNumber)) {
            displayRoomPrice();
        } else if (e.getSource().equals(cboRoomType)) {
            displayRoomPrice();
        }
    }
	
    //Method that adds the reservation to the table
  	private void addReservation() {
  		int roomNumber = (int) cboRoomNumber.getSelectedItem();
  	    String guestName = txtGuestName.getText();
  	    String roomType = cboRoomType.getSelectedItem().toString();
  	    LocalDate checkInDate = getSelectedDate(checkInYear, checkInMonth, checkInDay);
  	    LocalDate checkOutDate = getSelectedDate(checkOutYear, checkOutMonth, checkOutDay);

  	    double finalPrice = calculateFinalPrice(roomType, checkInDate, checkOutDate);

  	    HotelReservation reservation = new HotelReservation(roomNumber, guestName, roomType, checkInDate, checkOutDate, finalPrice);

  	    reservationManager.addReservation(reservation);
  	    displayAllReservations();
  	    clearFields();
  	}
  	
  	//Method that clears out the fields
  	private void clearFields() {
  	    txtGuestName.setText("");
  	    cboRoomNumber.setSelectedIndex(0);
  	    cboRoomType.setSelectedIndex(0);
  	    checkInMonth.select(0);
  	    checkInDay.select(0);
  	    checkInYear.select(0);
  	    checkOutMonth.select(0);
  	    checkOutDay.select(0);
  	    checkOutYear.select(0);
  	    txtRoomPrice.setText("");
  	    txtFinalPrice.setText("");
  	}
  	
  	//Method that updates the reservation
  	private void updateReservation() {
  	    int selectedRow = reservationTable.getSelectedRow();
  	    if (selectedRow != -1) {
  	        HotelReservation reservation = getSelectedReservation(selectedRow);
  	        if (reservation != null) {
  	            String guestName = txtGuestName.getText();
  	            String roomType = cboRoomType.getSelectedItem().toString();
  	            LocalDate checkInDate = getSelectedDate(checkInYear, checkInMonth, checkInDay);
  	            LocalDate checkOutDate = getSelectedDate(checkOutYear, checkOutMonth, checkOutDay);

  	            double finalPrice = calculateFinalPrice(roomType, checkInDate, checkOutDate);

  	            reservation.setGuestName(guestName);
  	            reservation.setRoomType(roomType);
  	            reservation.setCheckInDate(checkInDate);
  	            reservation.setCheckOutDate(checkOutDate);
  	            reservation.setFinalPrice(finalPrice);

  	            displayAllReservations();
  	            clearFields();
  	        }
  	    } else {
  	        JOptionPane.showMessageDialog(this, "Please select a reservation to update.", "Update Reservation",
  	                JOptionPane.WARNING_MESSAGE);
  	    }
  	}
  	
  	//Method that deletes the reservation
  	private void deleteReservation() {
  	    int selectedRow = reservationTable.getSelectedRow();
  	    if (selectedRow != -1) {
  	        HotelReservation reservation = getSelectedReservation(selectedRow);
  	        if (reservation != null) {
  	            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this reservation?",
  	                    "Delete Reservation", JOptionPane.YES_NO_OPTION);
  	            if (confirm == JOptionPane.YES_OPTION) {
  	                reservationManager.removeReservation(reservation);
  	                displayAllReservations();
  	                clearFields();
  	            }
  	        }
  	    } else {
  	        JOptionPane.showMessageDialog(this, "Please select a reservation to delete.", "Delete Reservation",
  	                JOptionPane.WARNING_MESSAGE);
  	    }
  	}

  	//Method that closes the application
  	private void closeApplication() {
  		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to close the application?",
  				"Close Application", JOptionPane.YES_NO_OPTION);
  				if (confirm == JOptionPane.YES_OPTION) {
  				System.exit(0);
  		}
  	}
  	
  	//Method that displays the room price
  	private void displayRoomPrice() {
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
  	 calculateFinalPrice();
  	 
  	}
  	
  	private void calculateFinalPrice() {
  	    LocalDate checkInDate = getSelectedDate(checkInYear, checkInMonth, checkInDay);
  	    LocalDate checkOutDate = getSelectedDate(checkOutYear, checkOutMonth, checkOutDay);
  	    String roomType = cboRoomType.getSelectedItem().toString();

  	    double finalPrice = calculateFinalPrice(roomType, checkInDate, checkOutDate);
  	    txtFinalPrice.setText(String.format("%.2f", finalPrice));
  	}

  	private double calculateFinalPrice(String roomType, LocalDate checkInDate, LocalDate checkOutDate) {
  		int roomPrice = 0;
   	 
   	    switch(roomType) {
   	    case "Single":
   	    	roomPrice = 50;
   		    break;
   	    case "Double":
   	    	roomPrice = 75;
   		    break;
   	    case "Suite":
   	    	roomPrice = 100;
   		    break;
   	 }
  	    long durationOfStay = getDurationOfStay(checkInDate, checkOutDate);
  	    return roomPrice * durationOfStay;
  	}
  	
  	private long getDurationOfStay(LocalDate checkInDate, LocalDate checkOutDate) {
  	    return checkInDate.until(checkOutDate).getDays();
  	}

  	private LocalDate getSelectedDate(Choice yearChoice, Choice monthChoice, Choice dayChoice) {
  	    int year = Integer.parseInt(yearChoice.getSelectedItem());
  	    int month = monthChoice.getSelectedIndex() + 1;
  	    int day = Integer.parseInt(dayChoice.getSelectedItem());

  	    return LocalDate.of(year, month, day);
  	}
  	
  	private void displayAllReservations() {
  	    reservationTableModel.setRowCount(0);

  	    List<HotelReservation> reservations = reservationManager.getAllReservations();
  	    for (HotelReservation reservation : reservations) {
  	        Vector<Object> rowData = new Vector<>();
  	        rowData.add(reservation.getRoomNumber());
  	        rowData.add(reservation.getGuestName());
  	        rowData.add(reservation.getRoomType());
  	        rowData.add(reservation.getCheckInDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
  	        rowData.add(reservation.getCheckOutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
  	        rowData.add(reservation.getFinalPrice());
  	        reservationTableModel.addRow(rowData);
  	    }
  	}

  	private HotelReservation getSelectedReservation(int row) {
  	    int roomNumber = (int) reservationTable.getValueAt(row, 0);
  	    return reservationManager.findReservationByRoomNumber(roomNumber);
  	}
  	
  	public static void main(String[] args) {
  	    SwingUtilities.invokeLater(new Runnable() {
  	        public void run() {
  	            new HotelReservationUI();
  	        }
  	    });
  	}
}