package week10laboratory1;

import java.awt.Color.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class MainProgram extends MainFrame implements ActionListener,MouseListener,KeyListener,WindowListener{
	//data fields
	private JLabel ID, Name, Type, Gender, lblColor, Breed, Price, Age, Search;
	private JTextField txtID, txtName, txtColor, txtPrice, txtAge, txtSearch;
	private JComboBox cboGender, cboType, cboBreed, cboMonth, cboDay, cboYear;
	private Font f = new Font("Arial", Font.BOLD, 16);
	private int age;
	private int current_year = Year.now().getValue();
	private JButton Add, Clear, Update, Delete, Close;

	//data field for the table
	private JTable petTable;
	//table access and manipulation
	private DefaultTableModel model_pet;
	private Vector columns, rowData;
	private TableRowSorter sortTable;
	
	//Database
	private MainDataBase db = new MainDataBase("Pet.txt");
	
	//JPanel objects
	private JPanel panelPetInfo, panelbirthdate, panelButtons, panelSearch, panelTable;

	//constructor
	public MainProgram() {
		initializedComponents();
		petInfo();
		add(panelPetInfo).setBounds(10,10,300,250);
		petBirthday();
		add(panelbirthdate).setBounds(10,260,300,80);
		petBirthdayButtons();
		add(panelButtons).setBounds(40,340,600,30);
		add(petSearch()).setBounds(320,20,300,30);
		add(panelPetTable()).setBounds(320,50,550,290);
		/*adds the panel to the window and sets the position within the window
		 * 10, 10 - x and y coordinates of the top-left corner of the panel
		 * 300, 250 - width and length of the panel in the window
		 */
		
		
		add(setBackgroundImage("images/pets.jpg"));
		setFrame("Pet Registration Form", 920, 612, true,DISPOSE_ON_CLOSE,false);
		//pack();
		/* setFrame(title, width, height, visible)
		 * 
		 * setFrame("Pet Registration Form", 900, 400, true,DISPOSE_ON_CLOSE,true);
		 * setFrame(title, width, height, visible, close_operation, resize);
		 * 
		 * DISPOSE_ON_CLOSE means that frame will close when the user clicks the close button
		 */
		
		/*NOTE:
		 * pack(); means that the image will fit on the window
		 * 
		 * Adding the pack() when?
		 * 1. Before the setFrame - the image will appear on the top middle and the window would be in the size of the given width and height 
		 * 2. After the setFrame - the window would resize itself to the size of the image
		 */
		
		//setting the value of txtID as the table adds up new saved records
		txtID.setText(getRowCount());
		
		//register the buttons to the ActionListener
		Add.addActionListener(this);
		Clear.addActionListener(this);
		Update.addActionListener(this);
		Delete.addActionListener(this);
		Close.addActionListener(this);
		
		petTable.addMouseListener(this);
		txtSearch.addKeyListener(this);
		
		txtName.addKeyListener(this);
		txtPrice.addKeyListener(this);
		txtColor.addKeyListener(this);
		txtColor.addMouseListener(this);
		addWindowListener(this);
		
		db = new MainDataBase("Pet.txt");
		db.displayRecords(model_pet);
		
		resetComponents();
	}
	
	//initializing the components of the whole window
	public void initializedComponents() {
		ID = new JLabel("ID: ");
		Name = new JLabel("Name: ");
		Type = new JLabel("Type: ");
		Gender = new JLabel("Gender: ");
		lblColor = new JLabel("Color: ");
		Breed = new JLabel("Breed: ");
		Price = new JLabel("Price: ");
		
		txtID = new JTextField(20);
		txtID.setEditable(false);
		
		txtName = new JTextField(20);
		txtColor = new JTextField(20);
		txtPrice = new JTextField(20);
		
		cboGender = new JComboBox();
		cboType = new JComboBox();
		cboBreed = new JComboBox();
		
		optionsBox();
		
		Add = new JButton("Add New", new ImageIcon("images/add_user.png"));
		Clear = new JButton("Clear", new ImageIcon("images/remove_user.png"));
		
		Update = new JButton("Update");
		Delete = new JButton("Delete");
		Close = new JButton("Close");
	}
	
	//adding components to panelPetInfo
	public void petInfo() {
		//initializing the Panel to recieve inputs
		panelPetInfo = new JPanel();
		panelPetInfo.setBorder(BorderFactory.createTitledBorder("Pet Registration Form")); //puts a tilted border around the panel with the title in quotations
		panelPetInfo.setLayout(new GridLayout(7,2)); //size of the panel 7x2
		panelPetInfo.setFont(f);//font
		panelPetInfo.setOpaque(false);//make the panel opaque or transparent
		
		//adding them components (label, txt or selection box)
		panelPetInfo.add(ID); panelPetInfo.add(txtID); 
		panelPetInfo.add(Name); panelPetInfo.add(txtName);
		panelPetInfo.add(Gender); panelPetInfo.add(cboGender); 
		panelPetInfo.add(Type); panelPetInfo.add(cboType);
		panelPetInfo.add(Breed); panelPetInfo.add(cboBreed);
		panelPetInfo.add(lblColor); panelPetInfo.add(txtColor); 
		panelPetInfo.add(Price); panelPetInfo.add(txtPrice); 
	}
	
	//adding the selection in the ComboBox
	public void optionsBox() {
		cboGender.addItem("Male");
		cboGender.addItem("Female");
		
		db = new MainDataBase("Type.txt");
		db.fillToComboBox(cboType);
		
		db = new MainDataBase("Breed.txt");
		db.fillToComboBox(cboBreed);
	}
	
	//Panel for the birthday and age
	public void petBirthday() {
		panelbirthdate = new JPanel();
		Age = new JLabel("Age");
		txtAge = new JTextField("0", 5); //initial value and no of columns via width makes the text field wide enought to display 5 characters
		txtAge.setEditable(false);
		txtAge.setToolTipText("Age"); //When the user hovers over the text field, a tooltip will be displayed with the specified text, providing additional information or context.
		
		//Loads the month to a combobox
		cboMonth = new JComboBox(Month.values());
		cboDay = new JComboBox();
		cboYear = new JComboBox();
		
		panelbirthdate.setLayout(new FlowLayout(FlowLayout.LEFT,1,1)); 
		/*setting the layout to get the birthdate and age of the pet
		 * FlowLayout - arranges the components in a row
		 * FlowLayout.LEFT - components will be aligned to the left side of the container
		 * 1,1 - horizontal and vertical gap between components counted by pixel gap
		 */
		panelbirthdate.setBorder(BorderFactory.createTitledBorder("Birthdate"));
		panelbirthdate.add(cboMonth);
		panelbirthdate.add(cboDay);
		panelbirthdate.add(cboYear);
		panelbirthdate.add(Age);
		panelbirthdate.add(txtAge);
		
		for(int i = 1; i <= 31; i++) {
			cboDay.addItem(i);
			cboYear.addItem(i + 1970);
		}
		
		cboYear.setEditable(true);
		cboYear.addActionListener(this);
	}

	//buttons for the petBirthday panel
	public void petBirthdayButtons() {
		panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(1, 5, 4, 2)); //row, column, horizontal gap, vertical gap
		panelButtons.add(Add);
		panelButtons.add(Clear);
		
		//creating an empty label as a seperator
		panelButtons.add(new JLabel(""));
		panelButtons.add(Update);
		panelButtons.add(Delete);
		panelButtons.add(Close);
	}
	
	//searching pets
	public JPanel petSearch() {
		panelSearch = new JPanel();
		Search = new JLabel("Search");
		txtSearch = new JTextField(10);
		panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT,2,1));
		panelSearch.add(Search);
		panelSearch.add(txtSearch);
		panelSearch.setOpaque(false);
		return panelSearch;
	}
	
	//Pet Table
	public JPanel panelPetTable() {
		panelTable = new JPanel();
		petTable = new JTable();
		model_pet = new DefaultTableModel();
		
		panelTable.setLayout(new BorderLayout());
		panelTable.add(new JScrollPane(petTable), BorderLayout.CENTER);
		
		String cols[] = {"ID", "Name", "Gender", "Type", "Breed", "Color", "Price","Month", "Day",
				         "Year", "Age"};
		
		columns = new Vector<>();
		//for each loop to store array elements to vector columns
		for(String val:cols) {
			columns.add(val);
		}
		
		//set column to table via DefaultTableModel
		model_pet.setColumnIdentifiers(columns);
		//sets the column names of the table to the values stored in the columns vector.
		
		//binding the table to the DefaultTableModel
		petTable.setModel(model_pet);
		//This binds the table to the model, which means any changes made to the model will be reflected in the table
		
		//sets all the column = width
		petTable.setAutoResizeMode(petTable.AUTO_RESIZE_OFF);
		/*By doing this, the table will not automatically adjust the width of its columns based on the data or window size. 
		 * Instead, the columns will maintain a fixed width as specified in the model or by manual adjustments.
		 */
		return panelTable;
	}
	
	//getting the inputs
	public void getData() {
		rowData = new Vector<String>();
		rowData.add(txtID.getText());
		rowData.add(txtName.getText());
		rowData.add(cboGender.getSelectedItem());
		rowData.add(cboType.getSelectedItem());
		rowData.add(cboBreed.getSelectedItem());
		rowData.add(txtColor.getText());
		rowData.add(txtPrice.getText());
		rowData.add(cboMonth.getSelectedItem());
		rowData.add(cboDay.getSelectedItem());
		rowData.add(cboYear.getSelectedItem());
		rowData.add(txtAge.getText());
	}
	
	//set the components to default values
	public void resetComponents() {
		txtID.setText(getRowCount());
		
		Add.setEnabled(true);
		Clear.setEnabled(true);
		Close.setEnabled(true);
		
		Update.setEnabled(false);
		Delete.setEnabled(false);
		
		//clearing the components
		txtName.setText("");
		txtPrice.setText("");
		txtColor.setText("");
		txtAge.setText("0");
	}
	
	// whenever the table is clicked, the update and delete buttons are enabled
	public void tableClick() {
		txtID.setText(getRowCount());
		Add.setEnabled(false);
		Update.setEnabled(true);
		Delete.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new MainProgram();
	}
	
	//gives you the current number of saved records
	public String getRowCount() {
		return "10" + model_pet.getRowCount();
	}
	
	public void process() {
		String records = "";
		for(int row = 0; row < model_pet.getRowCount(); row++) {
			for(int column = 0; column < model_pet.getColumnCount(); column++) {
				/* combining the values from the table as it gets the record
				 * with a seperator delimeter |
				 */
				records += model_pet.getValueAt(row, column) + "#";
			}
			records += "\n";
			//combines each record of the table to the next line
			//saving the recorded values from the table to the txt file
		}
		db.storeToFile(records);
		//explaination later
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cboYear)) {
			age = current_year - Integer.parseInt(cboYear.getSelectedItem().toString());
			//calculates the age based on the selected year from the cboYear 
			txtAge.setText(age + "");
		}else if(e.getSource().equals(Add)) {
			getData();
			model_pet.addRow(rowData);
			txtID.setText(getRowCount());
			resetComponents();
		}else if(e.getSource().equals(Clear)) {
			resetComponents();
		}else if(e.getSource().equals(Update)) {
			//update button
			int i = petTable.getSelectedRow();
			//This changes the records of your table based on the selected row
			
			/*the conventional way
			petTable.setValueAt(txtName.getText(), i, 1);
			petTable.setValueAt(cboGender.getSelectedItem(), i, 2);
			petTable.setValueAt(cboType.getSelectedItem(), i, 3);
			petTable.setValueAt(cboBreed.getSelectedItem(), i, 4);
			petTable.setValueAt(txtColor.getText(), i, 5);
			petTable.setValueAt(txtPrice.getText(), i, 6);
			petTable.setValueAt(cboMonth.getSelectedItem(), i, 7);
			petTable.setValueAt(cboDay.getSelectedItem(), i, 8);
			petTable.setValueAt(cboYear.getSelectedItem(), i, 9);
			petTable.setValueAt(txtAge.getText(), i, 10);
			*/
			
			//loop way
			getData();
			for(int col = 1; col < petTable.getColumnCount(); col++) {
				petTable.setValueAt(rowData.get(col), i, col);
			}
			resetComponents();
			//explaination later
			
		}else if(e.getSource().equals(Delete)) {
			int i = petTable.getSelectedRow();
			model_pet.removeRow(i);
			//explaination later
		}else if(e.getSource().equals(Close)) {
			process();
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(petTable)) {
		int i = petTable.getSelectedRow();
		//JOptionPane.showMessageDialog(null, "Row " + i + "  is selected");
		
		/*Set the text of the components based on the table selection
		 * i - row selected
		 * while the numerical values represent the columns of your table
		 */
		
		txtID.setText(petTable.getValueAt(i, 0) + "");
		txtName.setText(petTable.getValueAt(i, 1) + "");
		cboGender.setSelectedItem(petTable.getValueAt(i, 2) + "");
		cboType.setSelectedItem(petTable.getValueAt(i, 3) + "");
		cboBreed.setSelectedItem(petTable.getValueAt(i, 4) + "");
		txtColor.setText(petTable.getValueAt(i, 5) + "");
		txtPrice.setText(petTable.getValueAt(i, 6) + "");
		cboMonth.setSelectedItem(petTable.getValueAt(i, 7) + "");
		cboDay.setSelectedItem(petTable.getValueAt(i, 8) + "");
		cboYear.setSelectedItem(petTable.getValueAt(i, 9) + "");
		txtAge.setText(petTable.getValueAt(i, 10) + "");
		
		tableClick();
		//explaination later
	}else if(e.getSource().equals(txtColor)) {
		Color color = JColorChooser.showDialog(null, "Pick your color", Color.black);
		txtColor.setBackground(color);
		txtColor.setText("");
		//explaination later
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

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(txtPrice)) {
			if((e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z')) {
				e.consume();
			}
			//explaination later
		} else if(e.getSource().equals(txtName) || e.getSource().equals(txtColor)) {
			char ch = e.getKeyChar();
			if(!((Character.isWhitespace(ch) || e.getKeyChar() >= 'a' || e.getKeyChar() >= 'A' 
				&& (e.getKeyChar() <= 'z' || e.getKeyChar() <= 'Z')))) {
				e.consume();
			}
			//explaination later
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(txtSearch)) {
			String search = txtSearch.getText();
			//binding TableRowSorter and DefaultTableModel
			sortTable = new TableRowSorter(model_pet);
			
			//setting the pet table for sorting/searching
			petTable.setRowSorter(sortTable);
			
			/*setting the TableRowSorter which filters the data via the inputted value
			 * search - the keyword to be search and find
			 * integer (0) - the column you want to look into houses all of the values
			 */
			sortTable.setRowFilter(RowFilter.regexFilter(search, 0,1));
			
			//explaination later
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
		// TODO Auto-generated method stub
		
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
