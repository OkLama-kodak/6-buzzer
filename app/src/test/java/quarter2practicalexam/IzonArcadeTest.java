    package quarter2practicalexam;

    import org.junit.Test;

    public class IzonArcadeTest {
        @Test
        public void main() {
            String[] simulatedInputs = {
                    "1", //Buy tokens
                    "2", //Claim Prize
                    "200", //Low ticket count
                    "2", //Claim Prize
                    "500", //High ticket count
                    "3", //Exit

            };

            boolean running = true;
            int inputIndex = 0;

            while (running && inputIndex < simulatedInputs.length) {
                //Main Menu
                System.out.println("\n--- MENU ---");
                System.out.println("1. Buy Tokens");
                System.out.println("2. Claim Prize");
                System.out.println("3. Exit");

                String menuChoice = simulatedInputs[inputIndex++].trim();
                System.out.println(menuChoice);

                switch(menuChoice) {
                    case "1":
                        System.out.println("Buying tokens...");
                        break;

                    case "2":
                        System.out.println("Claiming prize...");
                        System.out.println("Enter ticket count:");

                        if (inputIndex < simulatedInputs.length) {
                            String ticketInput = simulatedInputs[inputIndex++];
                            System.out.println(ticketInput);

                            int ticketCount = Integer.parseInt(ticketInput);

                            if (ticketCount < 500) {
                                System.out.println("Keep Playing!(Need Atleast 500 Tickets)");
                            } else {
                                System.out.println("Claiming Prize!");
                            }
                        }
                        break;

                    case "3":
                        System.out.println("Exiting...");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option!");
                }
            if (inputIndex >= simulatedInputs.length && running) {
                System.out.println("\n--- SIMULATION COMPLETE ---");
            }
            }
       }
    }