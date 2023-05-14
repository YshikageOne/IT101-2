package transactionProcessingSystem;

import java.awt.Color;
import javax.swing.*;


public class Frame extends JFrame{
	private int width, height;
	
/* Table of Variables
 * width - width of the window
 * height - height of the window
 * title - caption of the frame/window
 * visible - setting to show the window or not
 * close_operation - 0 to 3 values
 * resize - prevents the frame to change size
 * 
 * file - file location
 * 
 * Colors
 * red - 0 to 255
 * blue - 0 to 255
 * green - 0 to 255
 * opacity - 0 to 255
 */
	
//constructor : default screen(800x500)
	public Frame() {
		super(); //calls on a superclass JFrame
		width = 500;
		height = 800;
		setWindowSize(width, height);
	}
	
//parameterized constructor : user may set based on preference
	public Frame(int width, int height) {
		super();
		setWindowSize(width, height);
	}

//parameterized constructor : user may set based on preference
	public Frame(String title, int width, int height) {
		super(title);
		setWindowSize(width, height);
	}

//parameterized constructor : user may set based on preference
	public Frame(String title, int width, int height, boolean visible) {
		super(title);
		setWindowSize(width, height);
		setVisible(visible);
	}
	
//parameterized constructor : user may set based on preference
	public void setWindowSize(int width, int height) {
		setSize(width, height);
	}
	
//parameterized constructor : user may set based on preference
	public void setFrame(String title, int width, int height) {
		setTitle(title);
		setWindowSize(width, height);
	}
	
//parameterized constructor : user may set based on preference
	public void setFrame(String title, int width, int height, boolean visible) {
		setFrame(title, width, height);
		setVisible(visible);
	}
	
//parameterized constructor : user may set based on preference
	public void setFrame(String title, int width, int height, boolean visible, int close_operation) {
		setFrame(title, width, height, visible);
		setDefaultCloseOperation(close_operation);
	}
	
//parameterized constructor : user may set based on preference
	public void setFrame(String title, int width, int height, boolean visible, int close_operation, boolean resize) {
		setFrame(title, width, height, visible, close_operation);
		setResizable(resize);
	}

	
	public void setBackgroundColor(int red, int green, int blue, int opacity) {
		getContentPane().setBackground(new Color(red,green,blue,opacity));
	}
	
	public JPanel setBackgroundImage(String file) {
		JPanel wallpaper = new JPanel();
		JLabel pic = new JLabel(new ImageIcon(file));//set the image to JLabel
		wallpaper.add(pic);
		return wallpaper;
	}

}
