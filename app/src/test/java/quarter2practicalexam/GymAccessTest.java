package quarter2practicalexam;

import org.junit.Test;

public class GymAccessTest {
    @Test
    public void main() {
        String[] simulatedInputs = {
                "1",   // Enter Gym
                "2",   // Hire Trainer
                "1",   // Level 1 (VIP membership tier)
                "2",   // Hire Trainer
                "2",   // Level 2 (Basic membership tier)
                "3"    // Exit
        };

        boolean running = true;
        int inputIndex = 0;

        while (running && inputIndex < simulatedInputs.length) {
            // Main Menu
            System.out.println("\n--- MENU ---");
            System.out.println("1. Enter Gym");
            System.out.println("2. Hire Trainer");
            System.out.println("3. Exit");

            String menuChoice = simulatedInputs[inputIndex++].trim();
            System.out.println(menuChoice);

            switch (menuChoice) {
                case "1":
                    System.out.println("Welcome to the Gym Floor!");
                    break;