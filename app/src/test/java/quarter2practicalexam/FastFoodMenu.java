package quarter2practicalexam;
import org.junit.Test;
public class FastFoodMenu {

    @Test
    public void start() {
        int choice = 1;

        do {
            System.out.println("==============================");
            System.out.println("       FAST FOOD MENU");
            System.out.println("==============================");
            System.out.println("1. Burger");
            System.out.println("2. Fries");
            System.out.println("3. Exit");
            System.out.println("==============================");

            // Change this value to test different choices
            choice++;

            switch (choice) {

                case 1:
                    System.out.println("\n===== BURGER OPTIONS =====");
                    System.out.println("1. Combo");
                    System.out.println("2. Solo");

                    int burgerChoice = 1;

                    if (burgerChoice == 1) {
                        System.out.println("You ordered a Burger Combo!");
                        System.out.println("Burger + Fries + Drink");
                    } else if (burgerChoice == 2) {
                        System.out.println("You ordered a Solo Burger!");
                    } else {
                        System.out.println("Invalid burger option.");
                    }

                    System.out.println();
                    break;

                case 2:
                    System.out.println("\nYou ordered Fries!");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("\nThank you for ordering!");
                    break;

                default:
                    System.out.println("\nInvalid option. Please try again.\n");
            }

        } while (choice != 3);
    }

    public static void main(String[] args) {

        FastFoodMenu fastFoodSystem = new FastFoodMenu();

        fastFoodSystem.start();
    }
}
