package week3laboratory1;

import javax.swing.*;

public class TrafficLights {

	public static void main(String[] args) {
		//randomly generating the number 
		int randomNumber = (int) (Math.random() * 3) + 1;
		
		ImageIcon go = new ImageIcon("go.PNG");
		ImageIcon wait = new ImageIcon("wait.PNG");
		ImageIcon stop = new ImageIcon("stop.PNG");
		
		if(randomNumber == 1) {
			JOptionPane.showMessageDialog(null, "The vehicle is set to go", "Traffic Light", JOptionPane.PLAIN_MESSAGE, go);
		}else if(randomNumber == 2) {
			JOptionPane.showMessageDialog(null, "The vehicle is set to wait", "Traffic Light", JOptionPane.PLAIN_MESSAGE, wait);
		}else if(randomNumber == 3) {
			JOptionPane.showMessageDialog(null, "The vehicle is set to stop", "Traffic Light", JOptionPane.PLAIN_MESSAGE, stop);
		}

	}

}
