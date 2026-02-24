import java.util.Scanner;


/*
 * Test Class hi
 * Contains main method and several helper methods
 */
public class Main {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        printWelcome();

        int count = askForLoanCount(sc);

        Loan[] loans = registerLoans(sc, count);

        sortLoansByName(loans);

        printLoans(loans);






        sc.close();
    }


    public static void printWelcome() {
        System.out.println("Welcome to the TechLab Loan System!");
        System.out.println("Let's register some Loans");
    }


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


    public static Loan[] registerLoans(Scanner sc, int count) {

        Loan[] loans = new Loan[count];

        for (int i = 0; i < count; i++) {

            System.out.println("\nRegister loan #" + (i + 1));

            System.out.print("Type (Books/Video/Electronics): ");
            String type = sc.nextLine();

            if (type.equalsIgnoreCase("electronics")) {
                System.out.print("Type (Arduino/Raspberry Pi/VR Equipment): ");
                String typeElectronics = sc.nextLine();
                if (typeElectronics.equalsIgnoreCase("Arduino")) {
                    System.out.print("Kit Level: ");
                    String kitLevel = sc.nextLine();
                    loans[i] = new Arduino("Arduino", 3, kitLevel);
                } else if (typeElectronics.equalsIgnoreCase("Raspberry Pi")) {
                    System.out.print("Model: ");
                    String model = sc.nextLine();
                    loans[i] = new RaspberryPi("Raspberry Pi", 3, model);
                } else if (typeElectronics.equalsIgnoreCase("VR Equipment")) {
                    System.out.print("Model: ");
                    String model = sc.nextLine();
                    loans[i] = new RaspberryPi("VR Equipment", 3, model);
                } else {
                    System.out.println("bad input");
                    i--;
                }

            }


            // Create correct object based on type
            else if (type.equalsIgnoreCase("books")) {
                System.out.print("Title: ");
                String titleBooks = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                loans[i] = new Books(titleBooks, 5, author);
            } else if (type.equalsIgnoreCase("video")) {
                System.out.print("Title: ");
                String titleVideo = sc.nextLine();
                System.out.print("Duration: ");
                String duration = sc.nextLine();
                loans[i] = new Video(titleVideo, 2, duration);
            } else {
                System.out.println("bad input");
                i--;
            }
        }

        return loans;
    }

    static int p = 0;

    public static void printLoans(Loan[] loans) {

        System.out.println("\n--- Loans Registered ---");


        for (int i = 0; i < loans.length; i++) {
            p++;
            System.out.println(loans[i]);// toString() is called automatically
            System.out.println("Loan Days: " + loans[i].getDate());
            System.out.println("");

        }
        System.out.println("Summary:");
        System.out.println("You have borrowed " + loans.length + " Items");
    }
    public static void sortPetsByName(Loan[] loans) {

        // Outer loop controls number of passes
        for (int i = 0; i < loans.length - 1; i++) {

            // Inner loop compares neighboring elements
            for (int j = 0; j < loans.length - 1 - i; j++) {

                /*
                 * compareTo compares two Strings alphabetically.
                 * If result > 0, first name comes AFTER second name.
                 * That means we need to swap them.
                 */
                if (loans[j].getTitle()
                        .compareTo(loans[j + 1].getTitle()) > 0) {

                    // Swap objects
                    Loan temp = loans[j];
                    loans[j] = loans[j + 1];
                    loans[j + 1] = temp;
                }
            }
        }
    }
}




