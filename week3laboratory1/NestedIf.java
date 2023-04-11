
package week3laboratory1;

import javax.swing.JOptionPane;

public class NestedIf {

	public static void main(String[] args) {
		//asking for the input
		String day = JOptionPane.showInputDialog(null, "Enter the day today:", "Day", JOptionPane.QUESTION_MESSAGE);
		String weather = JOptionPane.showInputDialog(null, "Enter the weather today:", "Weather", JOptionPane.QUESTION_MESSAGE);
		
		//anti case sensitive 
		String dayLow = day.toLowerCase();
		String weatherLow = weather.toLowerCase();
		
		//initializing the final output message
		String output = "";
		
		//nested if time
		if(dayLow.equals("monday") ||
		   dayLow.equals("tuesday") ||
		   dayLow.equals("wednesday") ||
		   dayLow.equals("thursday") ||
		   dayLow.equals("friday") ||
		   dayLow.equals("saturday") ||
		   dayLow.equals("sunday")) {
			
			output = (output + "Day of the week: " + day +
					  "\nWeather Today: " + weather);
			
			//specification for the days
			if(dayLow.equals("wednesday")) {
				output = (output + "\nTo Do List: School + Date");
			}else if(dayLow.equals("friday")) {
				output = (output + "\nTo Do List: School + Party");
			}else if(dayLow.equals("saturday")) {
				output = (output + "\nTo Do List: Bonding with Friends");
			}else if(dayLow.equals("sunday")) {
				output = (output + "\nTo Do List: Church + Family Bonding");
			}else {
				output = (output + "\nTo Do List: School");
			}
			
			if(weatherLow.equals("sunny")) {
				output = (output + "\nYou must bring a hat or umbrella");
			}else if(weatherLow.equals("rainy")) {
				output = (output + "\nYou must bring an umbrella or raincoat");
			}else if(weatherLow.equals("gloomy")) {
				output = (output + "\nYou must ride a taxi");
			}
			
		}else {
			output = (output + "Invalid Input");
		}
		
		//output
		
		JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.INFORMATION_MESSAGE);

	}

}
