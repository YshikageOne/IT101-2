package week6laboratory1;

import javax.swing.JOptionPane;
import java.util.Random;

public class ExtraChallenge {

	public static void main(String[] args) {
		 //made by me Mr.Clyde Allen Yu :D
		
		 // Initialize array of prize names
        String[] prize = {"Cellphone with projector", "Washing Machine with ironing",
                "House and Lot with lot and house", "Trip to Afghanistan for 2",
                "Summer Vacation at Sahara desert", "LED TV without TV", "Ferrari with dining room",
                "1 year supply of baygon katol", "1-day long boxing practice with Bradley and Pacquiao",
                "A kiss from Mommy Dionisia", "Lifetime Driver of Delima", "Unlimited family vacation package to Syria"};

        // Generate random prizes
        Random randomGenerator = new Random();
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = randomGenerator.nextInt(prize.length);
        }

        // display the randomly assigned prizes 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("Person ").append(i + 1).append(": ").append(prize[array[i]]).append("\n");
        }
        JOptionPane.showMessageDialog(null, "made by me Mr.Clyde Allen Yu :D\nRaffle Game Winners:\n\n" + sb.toString(), "Raffle Game",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
