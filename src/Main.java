import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

/*
 * Test Class
 * Contains main method and several helper methods
 */
public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        printWelcome();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register new loans");
            System.out.println("2. Show all loans");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                int count = askForLoanCount(sc);
                Loan[] loans = registerLoans(sc, count);
                printLoans(loans);
            } else if (choice.equals("2")) {
                showAllLoans();
            } else if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

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

            System.out.print("Type (Books/video/electronics): ");
            String type = sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();


            // Create correct object based on type
            if (type.equalsIgnoreCase("electronics")) {
                loans[i] = new Electronics(title, 3);
                saveLoanToFirebase(loans[i]);
            } else if (type.equalsIgnoreCase("books")) {
                System.out.print("Author: ");
                String author = sc.nextLine();
                loans[i] = new Books(title, 5, author);
                saveLoanToFirebase(loans[i]);
            } else if (type.equalsIgnoreCase("video")) {
                System.out.print("Duration: ");
                int duration = sc.nextInt();
                loans[i] = new Video(title, 2, duration);
                saveLoanToFirebase(loans[i]);


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
    public static void saveLoanToFirebase(Loan loan) {
        try {
            URL url = new URL("https://loan-df553-default-rtdb.europe-west1.firebasedatabase.app/loans.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Få typen dynamisk fra klassen
            String type = loan.getClass().getSimpleName();

            String jsonInput = "{"
                    + "\"title\":\"" + loan.getTitle() + "\","
                    + "\"days\":" + loan.getDate() + ","
                    + "\"type\":\"" + type + "\""
                    + "}";

            OutputStream os = conn.getOutputStream();
            os.write(jsonInput.getBytes());
            os.flush();
            os.close();

            conn.getResponseCode();
            conn.disconnect();

            System.out.println("Saved to Firebase!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showAllLoans() {
        try {
            URL url = new URL("https://loan-df553-default-rtdb.europe-west1.firebasedatabase.app/loans.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner sc = new Scanner(conn.getInputStream());
            StringBuilder json = new StringBuilder();
            while (sc.hasNextLine()) {
                json.append(sc.nextLine());
            }
            sc.close();
            conn.disconnect();

            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, LoanData>>(){}.getType();
            Map<String, LoanData> loans = gson.fromJson(json.toString(), type);

            System.out.println("\n--- All Loans ---");
            for (Map.Entry<String, LoanData> entry : loans.entrySet()) {
                LoanData l = entry.getValue();
                System.out.println("Title: " + l.title + ", Days: " + l.days + ", Type: " + l.type);
            }
            System.out.println("----------------\n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to fetch loans from Firebase.");
        }
    }

    // Hjælpeklasse til at holde data fra Firebase
    static class LoanData {
        String title;
        int days;
        String type;
    }
}




