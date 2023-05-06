package week10laboratory1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TypeAndBreed {
	
	public static void typeCRUD() throws FileNotFoundException{
		//explaination later
		
		String menu[] = {"[A]dd Type",
				         "[V]iew Types", 
				         "[E]dit Type", 
				         "[D]elete Type", 
				         "[E]xit"};
		
		String choice = "";
		ArrayList <String> petTypes = new ArrayList<>();
		
		File file = new File("Type.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			String type = scan.nextLine();
			petTypes.add(type);
		}
		//explaination later
		
		while(!choice.equals("[E]xit")) {
			choice=JOptionPane.showInputDialog(null, "Please Select", "Animal Types", 1,null,menu,menu[0]).toString();
			//choicebox selection on what operations
			
			switch(choice) {
			case "[A]dd Type":
				petTypes.add(JOptionPane.showInputDialog("What type of animal?: "));
				break;
				//explaination later
				
			case "[V]iew Types":
				String allTypes = "Animal Types\n";
				for(int i = 0; i < petTypes.size(); i++) {
					allTypes += petTypes.get(i) + "\n";
				}
				JOptionPane.showMessageDialog(null, new JTextArea(allTypes));
				break;
				//explaination later
				
			case "[E]dit Type":
				String petName = JOptionPane.showInputDialog("Input animal type: ");
				boolean hasName = petTypes.contains(petName);
				
				if(hasName == false) {
					JOptionPane.showMessageDialog(null, "Animal type NOT found.", null, JOptionPane.ERROR_MESSAGE);
				} else {
					int index = petTypes.indexOf(petName);
					petTypes.set(index, JOptionPane.showInputDialog("Replace the animal with: "));
				}
				break;
				//explaination later
				
			case "[D]elete Type":
				String petNameDel = JOptionPane.showInputDialog("Input animal type: ");
				boolean hasNameDel = petTypes.contains(petNameDel);
				
				if(hasNameDel == false) {
					JOptionPane.showMessageDialog(null, "Animal type NOT found.", null, JOptionPane.ERROR_MESSAGE);
				}else {
					petTypes.remove(petNameDel);
					JOptionPane.showMessageDialog(null, "Animal type has been removed.");
				}
				break;
				//explaination later
				
			}
		}
		try {
			FileWriter write = new FileWriter(file);
			for(String line : petTypes) {
				write.write(line + System.lineSeparator());
			}
			write.close();
		}catch (IOException e) {
		    e.printStackTrace();
		}
		//explain later
	}
	
	public static void breedCRUD() throws FileNotFoundException{
		String menu[] = {"[A]dd Breed",
                         "[V]iew Breeds", 
                         "[E]dit Breed", 
                         "[D]elete Breed", 
                         "[E]xit"};
		String choice = "";
        ArrayList <String> breedTypes = new ArrayList<>();
		
		File breedfile = new File("Breed.txt");
		Scanner scan = new Scanner(breedfile);
		
		while(scan.hasNextLine()) {
			String type = scan.nextLine();
			breedTypes.add(type);
		}
		//explaination later
		
		while(!choice.equals("[E]xit")) {
			choice=JOptionPane.showInputDialog(null, "Please Select", "Animal Breed", 1,null,menu,menu[0]).toString();
			//choicebox selection on what operations
			
			switch(choice) {
			case "[A]dd Breed":
				breedTypes.add(JOptionPane.showInputDialog("What breed of the animal?: "));
				break;
				//explaination later
				
			case "[V]iew Types":
				String allTypes = "Breed Types\n";
				for(int i = 0; i < breedTypes.size(); i++) {
					allTypes += breedTypes.get(i) + "\n";
				}
				JOptionPane.showMessageDialog(null, new JTextArea(allTypes));
				break;
				//explaination later
				
			case "[E]dit Type":
				String breedName = JOptionPane.showInputDialog("Input animal breed: ");
				boolean hasName = breedTypes.contains(breedName);
				
				if(hasName == false) {
					JOptionPane.showMessageDialog(null, "Breed NOT found.", null, JOptionPane.ERROR_MESSAGE);
				} else {
					int index = breedTypes.indexOf(breedName);
					breedTypes.set(index, JOptionPane.showInputDialog("Replace the breed with: "));
				}
				break;
				//explaination later
				
			case "[D]elete Type":
			    String breedNameDel = JOptionPane.showInputDialog("Input animal breed: ");
			    boolean hasBreedNameDel = breedTypes.contains(breedNameDel);
			    
			    if (hasBreedNameDel == false) {
			        JOptionPane.showMessageDialog(null, "Breed NOT found.", null, JOptionPane.ERROR_MESSAGE);
			    } else {
			        breedTypes.remove(breedNameDel);
			        JOptionPane.showMessageDialog(null, "Breed has been removed.");
			    }
			    break;
				//explaination later
				
			}
		}
		try {
			FileWriter write = new FileWriter(breedfile);
			for(String line : breedTypes) {
				write.write(line + System.lineSeparator());
			}
			write.close();
		}catch (IOException e) {
		    e.printStackTrace();
		}
		//explain later
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		String menu[] = {"Animal Type", "Animal Breed"};
		String choice = JOptionPane.showInputDialog(null, "What file do you want to select?", "Menu",1,null,menu,menu[0]).toString();
		
		switch (choice) {
		case "Animal Type":
			typeCRUD();
			break;
			
		case "Animal Breed":
			breedCRUD();
			break;
		}
	}
}
