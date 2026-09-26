package quarter2practicalexam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class GymAccessTest {

    @Test
    public void testGymFLow() {
        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING GYM TEST DATA ---");

        // Step 1:Enter gym floor option
        automatedInput.append("1\n"); //Choose Enter Gym

        // Step 2:Test VIP membership tier(Level 1)
        automatedInput.append("2\n"); //Choose Hire Trainer
        automatedInput.append("1\n"); //Enter Level 1 (Expected: Trainer Assigned)

        // Step 3:Test Basic Membership tier (Level 2)
        automatedInput.append("2\n"); //Choose Hire Trainer
        automatedInput.append("2\n"); //Enter Level 2 (Expected: Upgrade Required)

        // Step 4:Exit System
        automatedInput.append("3\n"); // Choose Exit

        System.out.println("--- TEST DATA GENERATION COMPLETE---\n");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.toString().getBytes());
        Scanner scanner = new Scanner(inputStream);

    }
}