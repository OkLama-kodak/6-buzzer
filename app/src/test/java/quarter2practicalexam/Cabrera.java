package quarter2practicalexam;

import org.junit.Test;

public class Cabrera {

    @Test
    public void testLibraryFlow() {
        System.out.println("--- GENERATING LIBRARY TEST DATA ---");

        String[] automatedInputs = {
                "1",  // Step 1: Choose Borrow Book
                "2",  // Step 2: Choose Pay Fines
                "10", // Enter payment 10 (Insufficient fine payment < 15)
                "2",  // Step 3: Choose Pay Fines
                "50", // Enter payment 50 (Sufficient fine payment >= 15)
                "3"   // Step 4: Choose Exit
        }; System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");

        boolean running = true;
        int inputIndex = 0;

        while (running && inputIndex < automatedInputs.length) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Borrow Book");
            System.out.println("2. Pay Fines");
            System.out.println("3. Exit");

            String menuChoice = automatedInputs[inputIndex++].trim();
            System.out.println(menuChoice);
