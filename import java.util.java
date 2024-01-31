import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMSystem {

    private static Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        initializeUserDatabase();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM System!");

        // User authentication
        String userId = getUserInput("Enter User ID: ");
        String userPin = getUserInput("Enter PIN: ");

        if (authenticateUser(userId, userPin)) {
            System.out.println("Authentication successful. ATM functionalities unlocked.");

            // Main menu
            while (true) {
                printMainMenu();
                int choice = Integer.parseInt(getUserInput("Enter your choice: "));

                switch (choice) {
                    case 1:
                        System.out.println("View Transactions History");
                        // Implement transaction history logic
                        break;
                    case 2:
                        System.out.println("Withdraw");
                        // Implement withdraw logic
                        break;
                    case 3:
                        System.out.println("Deposit");
                        // Implement deposit logic
                        break;
                    case 4:
                        System.out.println("Transfer");
                        // Implement transfer logic
                        break;
                    case 5:
                        System.out.println("Quitting ATM System. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting ATM System.");
        }
    }

    private static void initializeUserDatabase() {
        // Sample user data (replace with your actual user data)
        userDatabase.put("user123", "1234");
        userDatabase.put("johnDoe", "5678");
        // Add more users as needed
    }

    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextLine();
    }

    private static boolean authenticateUser(String userId, String userPin) {
        return userDatabase.containsKey(userId) && userDatabase.get(userId).equals(userPin);
    }

    private static void printMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }
}