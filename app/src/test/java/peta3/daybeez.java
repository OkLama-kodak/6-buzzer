package peta3;

import org.junit.Test
import java.io.ByteArrayInputStream
import java.util.Scanner

     public class daybeez{

      @Test
     public void testCompleteSystemFlow(){
        /*
        * 1. THE VIRTUAL KEYBOARD
         * A 'StringBuilder' acts as our virtual keyboard.
         * Instead of physically typing into the console, we will "append" (add)
         * every number or word the user would type into this builder.
         */
          StringBuilder simulatedUserInput = new StringBuilder();

          System.out.println("--- GENERATING SIMULATED USER INPUTS ---");

         /*
         *PART 1: SIMULATING Repetitive Tasks
          * We can use a while loop here to generate multiple inputs efficiently.
          * Think of this as a customer making 3 different orders or transactions.
          */
          int interactionCount = 1;
          while (interactionCount <= 3) {
              System.out.println("Generating inputs for interaction #" + interactionCount);

              if (interactionCount == 1) {
                  // Simulating the user typing '1' and pressing ENTER.
                  // IMPORTANT: The "\n" represents pressing the Enter key!

              }
}