package week5laboratory2;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

public class SentinelControlledLoop {

	public static void main(String[] args) {
		//initialize the values
		//made by me Mr.Clyde Allen Yu :D
		ArrayList<Integer> numList = new ArrayList<>();
		int input;
		int breakNum = 0;
		String output = "";
		
		//getting the input then if the input is 0 then the loop ends
		while(true) {
			input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter an integer (type 0 to finish)", "Get the input", JOptionPane.QUESTION_MESSAGE));
			
			if(input == breakNum) {
				break;
			}
			
			numList.add(input);
		}
		
		//displaying the outputs
		String allNum = ("If the inputs are: " + Arrays.toString(numList.toArray()).replace("[", "").replace("]", "") + " 0");
		String noZeroNum = ("Numbers: " + Arrays.toString(numList.toArray()).replace("[", "").replace("]", ""));
		
		ArrayList<Integer> oddNum = new ArrayList<>();
		ArrayList<Integer> evenNum = new ArrayList<>();
		
		for(int i = 0; i < numList.size();i++) {
			if(numList.get(i) % 2 != 0) {
				oddNum.add(numList.get(i));
			}else {
				evenNum.add(numList.get(i));
			}
		}
	   int oddCount = oddNum.size();
	   int evenCount = evenNum.size();
		
	   String oddNumbers = ("Odd Numbers: " + Arrays.toString(oddNum.toArray()).replace("[", "").replace("]", ""));
	   String evenNumbers = ("Even Numbers: " + Arrays.toString(evenNum.toArray()).replace("[", "").replace("]", "").toString());
	   String oddNumbersCount = ("Odd: " + oddCount);
	   String evenNumbersCount = ("Even: " + evenCount);
	   
	   //final output
	   output = (allNum + "\n" + noZeroNum + "\n" + oddNumbers + "\n" + evenNumbers + "\n" + oddNumbersCount + "\n" + evenNumbersCount + "\nmade by me Mr.Clyde Allen Yu :D");
	   
	   JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.PLAIN_MESSAGE);
	   
	}

}
