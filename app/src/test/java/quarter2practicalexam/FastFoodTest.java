package quarter2practicalexam;

import org.junit.Test;

public class FastFoodTest {
    @Test
    public void testFastFood() {
        int choice = 3;

        do {
            System.out.println("==========================");
            System.out.println("      Khurt's FastFood       ");
            System.out.println("1. Drinks ");
            System.out.println("2. Chicken");
            System.out.println("3. Exit");

        } while (choice != 3);
    }
}
