package betterTPS;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private static Database db = new Database("logindetails.txt");
	private int attempts = 1;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		//Main Frame
		setTitle("Log IN!!!");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gayur\\Downloads\\unknown.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setBounds(250, 27, 84, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(250, 113, 84, 14);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setBounds(250, 41, 175, 31);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String[][] loginDetails = db.loginDetails("logindetails.txt");
			    
			    String enteredUsername = txtUsername.getText(); 
			    char[] enteredPassword = password.getPassword();
			    
			    boolean loginSuccessful = false;
			    
			    for (String[] details : loginDetails) {
		            String username = details[0];
		            String password = details[1];
		            String enteredPasswordString = String.valueOf(enteredPassword);

		            if (enteredUsername.equals(username) && enteredPasswordString.equals(password)) {
		                loginSuccessful = true;
		                break;
		            }
		            
			    }
		            if (attempts < 4 && loginSuccessful) {
		                JOptionPane.showMessageDialog(null, "Login successful", "Nice", JOptionPane.PLAIN_MESSAGE);
		                HotelReservation hotelReservation = new HotelReservation();
				    	hotelReservation.setVisible(true);
				    	dispose();
		            } else if(attempts !=4) {
		            	JOptionPane.showMessageDialog(null, "Login error. Please try again. Attempts : " + attempts, "Login ERROR", JOptionPane.ERROR_MESSAGE);
	                    txtUsername.setText("");
	                    password.setText("");
	                    attempts++;
		             }else {
		            	 JOptionPane.showMessageDialog(null, "Maximum login attempts reached. Please try again later.", "Get the fuck out of here", JOptionPane.ERROR_MESSAGE);
		                 btnLogin.setEnabled(false);
		                 txtUsername.setText("");
		                 password.setText("");
		             }
			}
		});
		btnLogin.setBounds(250, 258, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using le Hotel Management", "Goodbye", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
		btnQuit.setBounds(349, 258, 89, 23);
		contentPane.add(btnQuit);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(250, 127, 175, 31);
		contentPane.add(password);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 240, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel icon = new JLabel("");
		icon.setBounds(0, 0, 240, 240);
		icon.setIcon(new ImageIcon("C:\\Users\\gayur\\Downloads\\hotel-logo-simple-illustration_4.jpg"));
		panel.add(icon);
		
		JLabel lblWelcome = new JLabel("Welcome to the Generic Hotel Management");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 251, 220, 18);
		panel.add(lblWelcome);
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("300 Black Man for only 2 Pounds???\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 280, 210, 18);
		panel.add(lblNewLabel);
		
		JLabel lblYesSir = new JLabel("YES SIR");
		lblYesSir.setVerticalAlignment(SwingConstants.TOP);
		lblYesSir.setHorizontalAlignment(SwingConstants.CENTER);
		lblYesSir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYesSir.setBounds(10, 309, 210, 18);
		panel.add(lblYesSir);
	}
}
