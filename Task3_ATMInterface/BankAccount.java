import java.util.ArrayList;

class BankAccount {
    double balance;
    ArrayList<String> history = new ArrayList<>();

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: " + amount);
        } else {
            history.add("Failed Withdraw: Insufficient Balance");
        }
    }

    void transfer(double amount, String toUser) {
        if (amount <= balance) {
            balance -= amount;
            history.add("Transferred: " + amount + " to " + toUser);
        } else {
            history.add("Failed Transfer: Insufficient Balance");
        }
    }

    void showHistory() {
        System.out.println("\n--- Transaction History ---");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String h : history) {
                System.out.println(h);
            }
        }
    }

    double getBalance() {
        return balance;
    }
}