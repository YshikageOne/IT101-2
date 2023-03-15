package week2laboratory1;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class tas {

	public static void main(String[] args) {
		String header = "****************** SACO Corp - Provides only the best... probably. ******************\n";
		String year = String.format("%-10s : %10s", "Year", "2023\n");
		String line = "*************************************************************************************\n";
		String labels = String.format("%-20s %-20s %20s %24s%n", "Months", "Gross Income", "Total Expenses", "Net Income");
		String jan = String.format("%-20s %-26s %-28s %-14s %1s%n", "January", "89,000", "10,000", "79,000", "");
		String feb = String.format("%-20s %-26s %-28s %-14s %1s%n", "February", "109,000", "9,000", "100,000", "");
		String mar = String.format("%-20s %-26s %-28s %-14s %1s%n", "March", "80,000", "8,000", "72,000", "");
		String apr = String.format("%-20s %-26s %-28s %-14s %1s%n", "April", "130,000", "20,000", "110,000", "");
		String may = String.format("%-20s %-26s %-28s %-14s %1s%n", "May", "150,000", "10,000", "140,000", "");
		String jun = String.format("%-20s %-26s %-28s %-14s %1s%n", "June", "155,000", "5,000", "150,000", "");
		String jul = String.format("%-20s %-26s %-28s %-14s %1s%n", "July", "180,000", "15,000", "165,000", "");
		String aug = String.format("%-20s %-26s %-28s %-14s %1s%n", "August", "220,000", "40,000", "180,000", "");
		String sep = String.format("%-20s %-26s %-28s %-14s %1s%n", "September", "170,000", "20,000", "150,000", "");
		String oct = String.format("%-20s %-26s %-28s %-14s %1s%n", "October", "165,000", "15,000", "150,000", "");
		String nov = String.format("%-20s %-26s %-28s %-14s %1s%n", "November", "140,000", "5,000", "135,000", "");
		String dec = String.format("%-20s %-26s %-28s %-14s %1s%n", "December", "152,000", "8,000", "144,000", "");
		String total = String.format("%-20s %-26s %-28s %-14s %1s%n%n", "TOTAL", "1,740,000", "165,000", "1,575,000", "");
		
		String months = jan + feb + mar + apr + may + jun + jul + aug + sep + oct + nov + dec;
		String content = header + year + line + labels + months + total + line;
		
		try {
			FileWriter docu = new FileWriter("Sales.txt");
			docu.write(content);
			docu.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
