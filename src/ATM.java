import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private HashMap<String, User> users = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n1. Create Account\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        users.put(username, new User(username, password));
        System.out.println("Account created successfully.");
    }

    private void login() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful.");
            atmOperations(user);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void atmOperations(User user) {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. View Transactions\n4. Balance\n5. Logout");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    user.deposit(sc.nextDouble());
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    if (!user.withdraw(sc.nextDouble())) {
                        System.out.println("Insufficient balance.");
                    }
                }
                case 3 -> user.showTransactions();
                case 4 -> System.out.println("Balance: ₹" + user.getBalance());
                case 5 -> {
                    System.out.println("Logged out.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
