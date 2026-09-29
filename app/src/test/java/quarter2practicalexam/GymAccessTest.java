package quarter2practicalexam;

import org.junit.Test;

public class GymAccessTest {
    @Test
    public void main() {
        String[] simulatedInputs = {
                "1",          // Enter Gym
                "2",          // Hire Trainer
                "Lawrence",       // Member Name
                "1",          // Level 1 (VIP membership tier)
                "2",          // Hire Trainer
                "Izon",        // Member Name
                "2",          // Level 2 (Basic membership tier)
                "2",          // Hire Trainer
                "Khurt",     // Member Name
                "99",         // Invalid membership tier
                "3",          // Access VIP Locker Room
                "1",          // VIP Level check
                "9",          // Invalid Menu Choice
                "4"           // Exit
        };

        boolean running = true;
        int inputIndex = 0;

        while (running && inputIndex < simulatedInputs.length) {
            // Main Menu
            System.out.println("\n--- GYM SYSTEM MENU ---");
            System.out.println("1. Enter Gym Floor");
            System.out.println("2. Hire Trainer");
            System.out.println("3. Access VIP Locker Room");
            System.out.println("4. Exit");
            System.out.print("Select choice: ");

            String menuChoice = simulatedInputs[inputIndex++].trim();
            System.out.println(menuChoice);

            switch (menuChoice) {
                case "1":
                    System.out.println("Welcome to the Gym Floor! Enjoy your workout.");
                    break;

                case "2":
                    System.out.println("\n--- HIRE A TRAINER ---");

                    // Prompt for Member Name
                    System.out.print("Enter member name: ");
                    if (inputIndex < simulatedInputs.length) {
                        String memberName = simulatedInputs[inputIndex++].trim();
                        System.out.println(memberName);

                        // Prompt for Membership Tier Level
                        System.out.print("Enter membership level (1 for VIP, 2 for Basic): ");
                        if (inputIndex < simulatedInputs.length) {
                            String levelInput = simulatedInputs[inputIndex++].trim();
                            System.out.println(levelInput);

                            try {
                                int level = Integer.parseInt(levelInput);

                                if (level == 1) {
                                    System.out.println("Trainer Assigned to " + memberName + "!");
                                } else if (level == 2) {
                                    System.out.println("Upgrade Required for " + memberName + " (VIP Tier needed).");
                                } else {
                                    System.out.println("Invalid membership level entered.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Membership level must be a number!");
                            }
                        }
                    }
                    break;

                case "3":
                    System.out.println("\n--- VIP LOCKER ROOM ACCESS ---");
                    System.out.print("Enter membership level (1 for VIP, 2 for Basic): ");

                    if (inputIndex < simulatedInputs.length) {
                        String tierInput = simulatedInputs[inputIndex++].trim();
                        System.out.println(tierInput);

                        if (tierInput.equals("1")) {
                            System.out.println("Access Granted: Welcome to the VIP Lounge & Locker Room.");
                        } else {
                            System.out.println("Access Denied: VIP membership required.");
                        }
                    }
                    break;

                case "4":
                    System.out.println("Exiting system... Thank you for visiting!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please select 1, 2, 3, or 4.");
                    break;
            }

            if (inputIndex >= simulatedInputs.length && running) {
                System.out.println("\n--- SIMULATION COMPLETE ---");
                running = false;
            }
        }
    }
}