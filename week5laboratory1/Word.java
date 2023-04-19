package week5laboratory1;

import javax.swing.JOptionPane;

public class Word {

	public static void main(String[] args) {
		//made by me Mr.Clyde Allen Yu :D
		
		//input and checks if its empty
		String input = JOptionPane.showInputDialog("Enter a character or string:");
        if (input == null) {
        	JOptionPane.showMessageDialog(null, "No input entered. Exiting...");
            return;
        	
        }
       
        
        //anti-case sensitive
        input = input.toLowerCase().replaceAll("\\s+", "");
        
        //initialize 
        int specialCharacters = 0;
        int vowels = 0;
        int consonants = 0;
        int oddNum = 0;
        int evenNum = 0;
        int space = 0;
        int zeroes = 0;
        
        // loop to check each character
        for(int i = 0; i < input.length(); i++) {
        	char eachChar = input.charAt(i);
        	
        	//for special char
        	if(!Character.isLetterOrDigit(eachChar)) {
        		specialCharacters++;
        	}
        	
        	//for consonants
        	if(Character.isLetter(eachChar) && !"aeiou".contains(String.valueOf(eachChar))){
        		consonants++;
        	}
        	
        	//for vowels
        	if(Character.isLetter(eachChar) && "aeiou".contains(String.valueOf(eachChar))){
        		vowels++;
        	}
        	
        	//for spaces
        	if (Character.isWhitespace(eachChar)) {
                space++;
            }
        	
        	//for zeroes odd and even
        	if(Character.isDigit(eachChar)) {
        		int digit = Character.getNumericValue(eachChar);
        		
        		if(digit == 0) {
        			zeroes++;
        		} else if(digit % 2 == 0 ) {
        			evenNum++;
        		}else {
        			oddNum++;
        		}
        	}
        }
        
        //output
        String output = ( "Created By: Clyde Allen Yu :D\n" + "Input: " + input + "\n" +
                "Special Characters: " + specialCharacters + "\n" +
                "Consonants: " + consonants + "\n" +
                "Vowels: " + vowels + "\n" +
                "Spaces: " + space + "\n" +
                "Zero Digits: " + zeroes + "\n" +
                "Odd Digits: " + oddNum + "\n" +
                "Even Digits: " + evenNum);
        JOptionPane.showMessageDialog(null, output);
        



        

	}

}
