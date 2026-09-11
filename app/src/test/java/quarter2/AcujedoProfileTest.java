package quarter2;

import org.junit.Test;

public class AcujedoProfileTest {
    @Test
    public void printMyProfile() {
        // --- 1. THE INPUT (storing your personal details in variables) ---
        String myName = "khurt";
        String myFavFood = "sinigang";
        String petName = "Kaizo";
        int myAge = 16;

        // ---2. THE OUTPUT (printing to the console)---
        System.out.println("--- MY DIGITAL PROFILE ---");
        System.out.println("Hello, my name is" + myName + "and i am " + myAge );
        System.out.println( "My pets name is " + petName);
        System.out.println( " My favorite food is" + myFavFood);


    }
}

