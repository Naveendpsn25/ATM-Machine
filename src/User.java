import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private double balance;
    private ArrayList<String> transactions;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    // Getters and setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
            return true;
        }
        return false;
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println(t);
            }
        }
    }
}
