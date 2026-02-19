import java.util.Scanner;

/*
 * Test Class
 * Contains main method and several helper methods
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        printWelcome();

        int count = askForPetCount(sc);

        Loan[] loans = registerLoans(sc, count);

        printPets(loans);

          // Manual sorting (NO Comparable)



        sc.close();
    }

    /*
     * Prints welcome message
     */
    public static void printWelcome() {
        System.out.println("🐾 Welcome to the Pet Adoption Center 🐾");
        System.out.println("Let's register some animals!");
    }

    /*
     * Asks user how many pets they want to register
     * Validates input
     */
    public static int askForPetCount(Scanner sc) {

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

            System.out.print("Type (rasberrypi/cat/lizard): ");
            String type = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            // Create correct object based on type
            if (type.equalsIgnoreCase("rasberrypi")) {
                loans[i] = new rasberrypi(date);
            }
             else if (type.equalsIgnoreCase("programming_book")) {
                loans[i] = new programming_book(date);
            } else {

            }
        }

        return loans;
    }

    /*
     * Prints all pets in the array
     */
    public static void printPets(Loan[] loans) {

        System.out.println("\n--- Pets Registered ---");

        for (int i = 0; i < loans.length; i++) {
            System.out.println(loans[i]); // toString() is called automatically
        }
    }
