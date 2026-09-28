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
        };