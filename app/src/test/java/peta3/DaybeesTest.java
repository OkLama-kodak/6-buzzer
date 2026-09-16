package peta3;
import org.junit.Test;

public class DaybeesTest {

    @Test
    public void testCompleteSystemFlow() {
        /*
         * 1. THE VIRTUAL KEYBOARD
         * A 'StringBuilder' acts as our virtual keyboard.
         * Instead of physically typing into the console, we will "append" (add)
         * every number or word the user would type into this builder.
         */
        StringBuilder simulatedUserInput = new StringBuilder();

        System.out.println("--- GENERATING SIMULATED USER INPUTS ---");

        /*
         * PART 1: Simulating Repetitive Tasks
         * We can use a while loop here to generate multiple inputs efficiently.
         * Think of this as a customer making 3 different orders or transactions.
         */
        int interactionCount = 1;
        while (interactionCount <= 3) {
            System.out.println("Generating inputs for interaction #" + interactionCount);

            if (interactionCount == 1) {
                // Simulating the user typing '1' and pressing ENTER.
                // IMPORTANT: The "\n" represents pressing the Enter key!
                simulatedUserInput.append("1\n");
            } else if (interactionCount == 2) {
                // Simulating the user choosing option '2', then typing '300'
                simulatedUserInput.append("2\n");
                simulatedUserInput.append("300\n");
            } else {
                // Simulating the user choosing option '2', then typing '5000'
                simulatedUserInput.append("2\n");
                simulatedUserInput.append("5000\n");
            }
            interactionCount++;

        }

    }
}
