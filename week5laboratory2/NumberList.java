package week5laboratory2;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberList {

    public static void main(String[] args) {
        //made by me Mr.Clyde Allen Yu :D

        String numberFile = "Numbers.txt";

        try {
            //gets the file and reads the file
            BufferedReader read = new BufferedReader(new FileReader(numberFile));
            String line;
            int sum = 0, count = 0, oddSum = 0, evenSum = 0;
            int[] rowSums = new int[5];
            int[] rowCounts = new int[5];
            int lowestNumber = Integer.MAX_VALUE;
            int highestNumber = Integer.MIN_VALUE;
            StringBuilder divisibleBy5Numbers = new StringBuilder();
            StringBuilder negativeNumbers = new StringBuilder();

            // Read the file line by line
            while ((line = read.readLine()) != null) {
                String[] numberStrings = line.trim().split("\\s+");
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    sum += number;
                    count++;

                    // Check for odd, even, divisible by 5, and negative numbers
                    if (number % 2 != 0) {
                        oddSum += number;
                    } else {
                        evenSum += number;
                    }

                    if (number % 5 == 0) {
                        divisibleBy5Numbers.append(number).append(" ");
                    }

                    if (number < 0) {
                        negativeNumbers.append(number).append(" ");
                    }

                 // Calculate row sums and counts
                    int row = count - 1;
                    if (row < rowSums.length) { // Check if row is within bounds
                        rowSums[row] += number;
                    }
                    if (row < rowCounts.length) { // Check if row is within bounds
                        rowCounts[row]++;
                    }

                    // Update lowest and highest number
                    if (number < lowestNumber) {
                        lowestNumber = number;
                    }
                    if (number > highestNumber) {
                        highestNumber = number;
                    }
                }
            }

            // Calculate average
            double average = (double) sum / count;

            // Build result message
            StringBuilder resultMessage = new StringBuilder();
            resultMessage.append("All numbers:\n");
            read = new BufferedReader(new FileReader(numberFile));
            while ((line = read.readLine()) != null) {
                resultMessage.append(line).append("\n");
            }
            resultMessage.append("Sum and Average:\n");
            resultMessage.append("Sum: ").append(sum).append("\n");
            resultMessage.append("Average: ").append(average).append("\n");
            resultMessage.append("All Odd Numbers and their Total Sum:\n");
            resultMessage.append("Odd Numbers: ").append(oddSum).append("\n");
            resultMessage.append("Sum of Odd Numbers: ").append(oddSum).append("\n");
            resultMessage.append("All Even Numbers and their Total Sum:\n");
            resultMessage.append("Even Numbers: ").append(evenSum).append("\n");
            resultMessage.append("Sum of Even Numbers: ").append(evenSum).append("\n");
            resultMessage.append("Divisible by 5:\n");
            resultMessage.append(divisibleBy5Numbers.toString()).append("\n");
            resultMessage.append("Negative Numbers:\n");
            resultMessage.append(negativeNumbers.toString()).append("\n");
            resultMessage.append("Row Sums:\n");
            for (int i = 0; i < rowSums.length; i++) {
                resultMessage.append("Row ").append(i + 1).append("Sum:").append(rowSums[i]).append("\n");
            }
              resultMessage.append("Row Counts:\n");
            for (int i = 0; i < rowCounts.length; i++) {
            resultMessage.append("Row ").append(i + 1).append(" Count: ").append(rowCounts[i]).append("\n");
            }
            resultMessage.append("Lowest Number: ").append(lowestNumber).append("\n");
            resultMessage.append("Highest Number: ").append(highestNumber).append("\n");
            
            // Show result message in a dialog box
            JOptionPane.showMessageDialog(null, resultMessage.toString(), "Number List Analysis", JOptionPane.INFORMATION_MESSAGE);

            // Close file reader
            read.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "File Read Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error parsing number: " + e.getMessage(), "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
}