import java.util.Scanner;

/*
 * Test Class
 * Contains main method and several helper methods
 */
public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        printWelcome();

        int count = askForLoanCount(sc);

        Loan[] loans = registerLoans(sc, count);

        printLoans(loans);

        // Manual sorting (NO Comparable)


        sc.close();
    }

    /*
     * Prints welcome message
     */
    public static void printWelcome() {
        System.out.println("Welcome to the TechLab Loan System!");
        System.out.println("Let's register some Loans");
    }

    /*
     * Asks user how many pets they want to register
     * Validates input
     */
    public static int askForLoanCount(Scanner sc) {

        int count = 0;

        while (true) {

            System.out.print("How many Loans do you want to register? ");

            if (sc.hasNextInt()) {
                count = sc.nextInt();
                sc.nextLine(); // Clear buffer

                if (count > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number!");
                }
            } else {
                System.out.println("That wasn't a number, try again!");
                sc.nextLine(); // Clear invalid input
            }
        }

        return count;
    }

    /*
     * Registers pets and returns the array
     */
    public static Loan[] registerLoans(Scanner sc, int count) {

        Loan[] loans = new Loan[count];

        for (int i = 0; i < count; i++) {

            System.out.println("\nRegister loan #" + (i + 1));

            System.out.print("Type (Books/video/electronics): ");
            String type = sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Date: ");


            // Create correct object based on type
            if (type.equalsIgnoreCase("electronics")) {
                loans[i] = new Electronics(title, 3);
            } else if (type.equalsIgnoreCase("books")) {
                loans[i] = new Books(title, 5);

            } else if (type.equalsIgnoreCase("video")) {
                loans[i] = new Video(title, 2);


            }
        }

        return loans;
    }

    /*
     * Prints all loans in the array
     */
    public static void printLoans(Loan[] loans) {

        System.out.println("\n--- Loans Registered ---");

        for (int i = 0; i < loans.length; i++) {
            System.out.println(loans[i]);// toString() is called automatically

        }
    }
}
