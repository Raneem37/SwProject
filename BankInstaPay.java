import java.util.Scanner;

public class BankInstaPay extends InstaPay {
    public void displayUserBankMenu(User user) {
        boolean FLAG = true;
        while (FLAG) {
            System.out.println("Welcome, " + user.getUsername() + "!");
            System.out.println("1. Transfer to Wallet using the mobile number");
            System.out.println("2. Transfer to Another Bank account");
            System.out.println("3. Transfer to Another instapay account");
            System.out.println("4. Inquire about your balance");
            System.out.println("5. Pay bills");
            System.out.println("6. Log Out");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    transferToWallet.processPayment(user);
                    break;
                case 2:
                    transferBankAccount.processPayment(user);
                    break;
                case 3:
                    transferToInstapayAccount.processPayment(user);
                    break;
                case 4:
                    inquireBalance.processPayment(user);
                    break;
                case 5:
                    payBills.processPayment(user);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    FLAG = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
