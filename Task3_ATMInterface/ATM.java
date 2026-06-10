import java.util.Scanner;

class ATM {
    User user;
    BankAccount account;

    ATM(User user, BankAccount account) {
        this.user = user;
        this.account = account;
    }

    void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== ATM LOGIN =====");
        System.out.print("Enter User ID: ");
        String id = sc.next();

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (id.equals(user.userId) && pin.equals(user.userPin)) {
            System.out.println("\nLogin Successful! Welcome ");

            int choice;

            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        account.showHistory();
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        account.withdraw(sc.nextDouble());
                        System.out.println("Done ");
                        break;

                    case 3:
                        System.out.print("Enter amount: ");
                        account.deposit(sc.nextDouble());
                        System.out.println("Done ");
                        break;

                    case 4:
                        System.out.print("Enter receiver name: ");
                        String toUser = sc.next();

                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();

                        account.transfer(amt, toUser);
                        System.out.println("Transfer processed ");
                        break;

                    case 5:
                        System.out.println("Current Balance: " + account.getBalance());
                        break;

                    case 6:
                        System.out.println("Thank you for using ATM ");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 6);

        } else {
            System.out.println(" Invalid Credentials!");
        }

        sc.close();
    }
}