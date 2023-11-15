import java.util.Scanner;

public abstract class InstaPay {

    UserRegistration userRegistration;
    PaymentStrategy transferBankAccount = new TransferToBankAccount() ;
    PaymentStrategy transferToWallet = new TransferToMobileWallet();
    PaymentStrategy transferToInstapayAccount= new TransferToAnotherAccount() ;
    PaymentStrategy inquireBalance= new InquireBalance();
    PaymentStrategy payBills= new PayUtilityBill();

     public abstract void displayUserBankMenu(User user);
    public void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean FLAG =true;
        while(FLAG) {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign in");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                        System.out.println("1. Sign up using bank account");
                        System.out.println("2. Sign up using mobile wallet");
                        System.out.println("3. Back");
                        int SignUpchoice = scanner.nextInt();
                        switch (SignUpchoice) {
                            case 1:
                                userRegistration = new BankAccountRegistration();
                                userRegistration.registerUser(scanner);
                                break;
                            case 2:
                                userRegistration = new WalletRegistration();
                                userRegistration.registerUser(scanner);
                                break;
                            case 3:
                                System.out.println("BYE");
                                break;
                            default:
                                System.out.println("Error! Enter a valid number");
                                break;
                        }
                    break;
                case 2:
                    UserRegistration.login(scanner, this);

                    break;
                case 3:
                    FLAG = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
