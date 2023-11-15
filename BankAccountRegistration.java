import java.util.Scanner;

class BankAccountRegistration extends UserRegistration {
    private String accountNumber;
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    @Override
    public void registerUser(Scanner scanner) {
        scanner = new Scanner(System.in);

        OTP otpVerification = new OTP();
        System.out.println("Registering user using bank account...");
//        Bank_API.bank_accs.add(Bank_API.APIGenerator());

        System.out.println("Enter your phone number please: ");
        String mobileNumber = scanner.nextLine();
        WalletProvider.wallets.add(mobileNumber);

        // Verify bank account and mobile number
        boolean bankVerification = Bank_API.check(mobileNumber);

        if (bankVerification) {
            if(otpVerification.verifyOTP(mobileNumber,scanner)) {
                System.out.println("Bank account and mobile number verified. Enter a username and password:");
                String enteredUsername = scanner.nextLine();
                String enteredPassword = scanner.nextLine();
                System.out.println("Enter balance:- ");
                long balance = scanner.nextLong();
                if (isUniqueUserName(enteredUsername)&& isComplexPassword(enteredPassword)){
                    User newUser = new User(enteredUsername, enteredPassword, mobileNumber, this, balance);
                    String API = Bank_API.APIGenerator();
                    Bank_API.bank_accs.add(API);
                    newUser.setAccountNumber(API);
                    DataBase.users.add(newUser);
                    System.out.println("User registered successfully!");
                    System.out.println("Your account number is " + newUser.getAccountNumber());

                } else {
                    System.out.println("Unsuccessful. Registration aborted.");
                }
            } else {
                System.out.println("OTP verification failed. Registration aborted.");
            }
        } else {
            System.out.println("Bank account or mobile number verification failed. Registration aborted.");
        }
    }
}
