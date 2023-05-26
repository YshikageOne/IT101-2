package betterTPS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HotelReservation extends JFrame {

	private JPanel contentPane;
	private JLabel backgroundImage;
	private JTable reservationTable;
	private JTextField txtSearch;
	private static Database db = new Database("Reserve.txt");
	private DefaultTableModel model_reservation;
	private JScrollPane scrollPaneReservation;
	private JTextField txtGuestName;
	private Vector<String> guestDetails;
	private JTextField txtFinalPrice;
	private JTextField txtRoomPrice;
	private static HotelReservationMethod hrm = new HotelReservationMethod();
	private TableRowSorter sortTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelReservation frame = new HotelReservation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HotelReservation() {
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				hrm.process(model_reservation);
				System.exit(0);
			}
			public void windowClosing(WindowEvent e) {
				hrm.process(model_reservation);
				System.exit(0);
			}
		});
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gayur\\Downloads\\xxvxv.PNG"));
		setTitle("Hotel Reservation WOOOOOO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel addDetails = new JPanel();
		addDetails.setBounds(543, 47, 455, 231);
		contentPane.add(addDetails);
		addDetails.setLayout(null);
		
		JLabel lblGuestName = new JLabel("Guest Name :");
		lblGuestName.setBounds(10, 22, 84, 14);
		addDetails.add(lblGuestName);
		
		txtGuestName = new JTextField();
		txtGuestName.setBounds(94, 19, 119, 20);
		addDetails.add(txtGuestName);
		txtGuestName.setColumns(10);
		
		JLabel lblRoomNumber = new JLabel("Room Number :");
		lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRoomNumber.setBounds(10, 101, 84, 26);
		addDetails.add(lblRoomNumber);
		
		JComboBox cboRoomNumber = new JComboBox();
		cboRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboRoomNumber.setBounds(94, 95, 119, 38);
		addDetails.add(cboRoomNumber);
		
		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setBounds(10, 66, 84, 14);
		addDetails.add(lblRoomType);
		
		JComboBox cboRoomType = new JComboBox();
		cboRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboRoomType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hrm.roomChange(cboRoomType, cboRoomNumber, txtRoomPrice);
			}
		});
		cboRoomType.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Suite"}));
		cboRoomType.setBounds(94, 52, 119, 38);
		addDetails.add(cboRoomType);
		
		//Check in and check out panel
		JPanel datePanel = new JPanel();
		datePanel.setBackground(Color.GRAY);
		datePanel.setBounds(223, 11, 222, 126);
		addDetails.add(datePanel);
		datePanel.setLayout(null);
		
		JLabel lblCheckIn = new JLabel("Check-in Date");
		lblCheckIn.setBounds(71, 5, 79, 16);
		lblCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		datePanel.add(lblCheckIn);
		
		JComboBox cboCheckInDay = new JComboBox();
		cboCheckInDay.setBounds(96, 32, 41, 22);
		datePanel.add(cboCheckInDay);
		
		JComboBox cboCheckInMonth = new JComboBox();
		cboCheckInMonth.setBounds(10, 32, 76, 22);
		datePanel.add(cboCheckInMonth);
		
		JComboBox cboCheckInYear = new JComboBox();
		cboCheckInYear.setBounds(147, 32, 65, 22);
		datePanel.add(cboCheckInYear);
		
		JLabel lblCheckOut = new JLabel("Check-out Date");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCheckOut.setBounds(71, 65, 87, 16);
		datePanel.add(lblCheckOut);
		
		JComboBox cboCheckOutMonth = new JComboBox();
		cboCheckOutMonth.setBounds(10, 92, 76, 22);
		datePanel.add(cboCheckOutMonth);
		
		JComboBox cboCheckOutDay = new JComboBox();
		cboCheckOutDay.setBounds(96, 92, 41, 22);
		datePanel.add(cboCheckOutDay);
		
		JComboBox cboCheckOutYear = new JComboBox();
		cboCheckOutYear.setBounds(147, 92, 65, 22);
		datePanel.add(cboCheckOutYear);
		
		JLabel lblFinalPrice = new JLabel("Final Price :");
		lblFinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFinalPrice.setBounds(10, 188, 84, 26);
		addDetails.add(lblFinalPrice);
		
		txtFinalPrice = new JTextField();
		txtFinalPrice.setEditable(false);
		txtFinalPrice.setColumns(10);
		txtFinalPrice.setBounds(94, 182, 119, 38);
		addDetails.add(txtFinalPrice);
		
		//method that calls in the date and price
        hrm.reservationDatesAndPrice(datePanel, cboCheckInDay, cboCheckInMonth, cboCheckInYear, cboCheckOutDay, cboCheckOutMonth, cboCheckOutYear, txtFinalPrice, cboRoomType);
		
		JLabel lblRoomPrice = new JLabel("Room Price :");
		lblRoomPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRoomPrice.setBounds(10, 138, 84, 39);
		addDetails.add(lblRoomPrice);
		
		txtRoomPrice = new JTextField();
		txtRoomPrice.setEditable(false);
		txtRoomPrice.setColumns(10);
		txtRoomPrice.setBounds(94, 139, 119, 38);
		addDetails.add(txtRoomPrice);
		
		JLabel myGenuineReaction = new JLabel("New label");
		myGenuineReaction.setIcon(new ImageIcon("C:\\Users\\gayur\\Downloads\\348908300_811854287258987_5626051713494398267_n.jpg"));
		myGenuineReaction.setBounds(223, 148, 222, 72);
		addDetails.add(myGenuineReaction);
		model_reservation = new DefaultTableModel();
		Object[] column = {"Guest Name", "Room Type", "Room Number", "Check-in Date", "Check-out Date", "Final Price"};
		Object[] row = new Object[0];
		model_reservation.setColumnIdentifiers(column);
		
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setBounds(334, 210, 121, 41);
		contentPane.add(btnClose);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(412, 131, 121, 41);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(260, 131, 121, 41);
		contentPane.add(btnUpdate);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(260, 47, 121, 41);
		contentPane.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(412, 47, 121, 41);
		contentPane.add(btnClear);
		
		 ActionListener buttonPressed = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource().equals(btnAdd)) {
					hrm.addDetails(txtGuestName, cboRoomType, cboRoomNumber, model_reservation, guestDetails, 
							cboCheckInMonth, cboCheckInDay, cboCheckInYear, 
							cboCheckOutMonth, cboCheckOutDay, cboCheckOutYear, txtFinalPrice, btnAdd, btnClear, btnClose, btnUpdate, btnDelete, txtRoomPrice);
				} else if(e.getSource().equals(btnClear)) {
					hrm.resetComponents(btnAdd, btnClear, btnClose, btnUpdate, btnDelete, txtGuestName, 
							cboRoomNumber, cboRoomType, txtRoomPrice, txtFinalPrice, cboCheckInMonth, 
							cboCheckInDay, cboCheckInYear, cboCheckOutMonth, cboCheckOutDay, cboCheckOutYear);
				}else if(e.getSource().equals(btnUpdate)) {
					hrm.updateDetails(reservationTable, guestDetails, txtGuestName, cboRoomType, cboRoomNumber, 
							cboCheckInMonth, cboCheckInDay, cboCheckInYear, cboCheckOutMonth, cboCheckOutDay, cboCheckOutYear, 
							txtFinalPrice, btnAdd, btnClear, btnClose, btnUpdate, btnDelete, txtRoomPrice);
				}else if(e.getSource().equals(btnDelete)) {
					hrm.deleteDetails(reservationTable, model_reservation);
				}else if(e.getSource().equals(btnClose)) {
					hrm.process(model_reservation);
					JOptionPane.showMessageDialog(null, "Thank you for using le Hotel Management", "Goodbye", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}
				
			}
		};
		
		guestDetails = new Vector<String>();
		btnAdd.addActionListener(buttonPressed);
		btnClear.addActionListener(buttonPressed);
		btnUpdate.addActionListener(buttonPressed);
		btnDelete.addActionListener(buttonPressed);
		btnClose.addActionListener(buttonPressed);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getSource().equals(txtSearch)) {
					String search = txtSearch.getText();
					
					sortTable = new TableRowSorter(model_reservation);
					reservationTable.setRowSorter(sortTable);
					
					sortTable.setRowFilter(RowFilter.regexFilter(search, 0,1,2,3));
				}
			}
		});
		txtSearch.setBounds(61, 276, 121, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		
		scrollPaneReservation = new JScrollPane();
		scrollPaneReservation.setBounds(10, 300, 988, 226);
		contentPane.add(scrollPaneReservation);
		
		reservationTable = new JTable();
		reservationTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
					 if (e.getSource().equals(reservationTable)) {
						 int i = reservationTable.getSelectedRow();
						 
						 txtGuestName.setText(reservationTable.getValueAt(i, 0) + "");
					     cboRoomType.setSelectedItem(reservationTable.getValueAt(i, 1) + "");
					     cboRoomNumber.setSelectedItem(reservationTable.getValueAt(i, 2) + "");
					     
					     //Check-in
					     String checkInDate = reservationTable.getValueAt(i, 3).toString();
					     String[] checkInParts = checkInDate.split(" ");
					     cboCheckInMonth.setSelectedItem(checkInParts[0]);
					     cboCheckInDay.setSelectedItem(checkInParts[1].replace(",", ""));
					     cboCheckInYear.setSelectedItem(checkInParts[2]);
					     
					     //Check-out
					     String checkOutDate = reservationTable.getValueAt(i, 4).toString();
					     String[] checkOutParts = checkOutDate.split(" ");
					     cboCheckOutMonth.setSelectedItem(checkOutParts[0]);
					     cboCheckOutDay.setSelectedItem(checkOutParts[1].replace(",", ""));
					     cboCheckOutYear.setSelectedItem(checkOutParts[2]);
					     
					     tableClick();

					 }
				}

			private void tableClick() {
				btnAdd.setEnabled(false);
				btnClear.setEnabled(false);
		 		btnUpdate.setEnabled(true);
		 		btnDelete.setEnabled(true);
				
			}
		});
		reservationTable.setModel(model_reservation);
		scrollPaneReservation.setViewportView(reservationTable);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(10, 279, 45, 14);
		contentPane.add(lblSearch);
		
		JLabel lblWelcome = new JLabel("Welcome to the Hotel Reservation Manangement\r\n");
		lblWelcome.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
		lblWelcome.setBounds(260, 11, 608, 25);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gayur\\Downloads\\hotel-logo-simple-illustration_4.jpg"));
		lblNewLabel.setBounds(10, 11, 240, 240);
		contentPane.add(lblNewLabel);
		
		backgroundImage = new JLabel("");
		backgroundImage.setBounds(0, 0, 1024, 576);
		backgroundImage.setIcon(new ImageIcon("C:\\Users\\gayur\\eclipse-workspace\\SchoolStuff\\images\\hotel.jpg"));
		contentPane.add(backgroundImage);
		
		
		//display the table
		db.displayRecords(model_reservation);
	}
}
