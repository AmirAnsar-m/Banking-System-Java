import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance + " Euro");
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {

            System.out.println("\n--- Bankverwaltungssystem ---");
            System.out.println("1. Neues Konto erstellen");
            System.out.println("2. Alle Konten anzeigen");
            System.out.println("3. Geld einzahlen");
            System.out.println("4. Geld abheben");
            System.out.println("5. Beenden");
            System.out.print("Bitte wählen Sie eine Option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Neues Konto erstellen
                    System.out.print("Account Holder: ");
                    String name = scanner.next();
                    System.out.print("Account Number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    accounts.add(new BankAccount(name, accountNumber, initialBalance));
                    System.out.println("Account successfully created!");
                    break;

                case 2: // Alle Konten anzeigen
                    if (accounts.isEmpty()) {
                        System.out.println("There are no accounts.");
                    } else {
                        for (BankAccount account : accounts) {
                            account.displayAccountInfo();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 3: // Geld einzahlen
                    System.out.print("Account Number: ");
                    String depositAccount = scanner.next();
                    boolean accountFound = false;
                    for (BankAccount account : accounts) {
                        if (account.accountNumber.equals(depositAccount)) {
                            System.out.print("Amount to deposit: ");
                            double amount = scanner.nextDouble();
                            account.balance += amount;
                            System.out.println("Amount successfully deposited!");
                            accountFound = true;
                            break;
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account with this number not found.");
                    }
                    break;

                case 4: // Geld abheben
                    System.out.print("Account Number: ");
                    String withdrawAccount = scanner.next();
                    accountFound = false;
                    for (BankAccount account : accounts) {
                        if (account.accountNumber.equals(withdrawAccount)) {
                            System.out.print("Amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            if (amount <= account.balance) {
                                account.balance -= amount;
                                System.out.println("Amount successfully withdrawn!");
                            } else {
                                System.out.println("Insufficient funds.");
                            }
                            accountFound = true;
                            break;
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account with this number not found.");
                    }
                    break;

                case 5: // Beenden
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (choice != 5) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
