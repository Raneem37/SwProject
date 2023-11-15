import java.util.Scanner;

class WalletRegistration extends UserRegistration {

    @Override
    public void registerUser(Scanner scanner) {
        scanner = new Scanner(System.in);

        OTP otpVerification = new OTP();
        System.out.println("Registering user using wallet...");

        System.out.println("Enter your phone number please: ");
        String mobileNumber = scanner.nextLine();

        boolean mobileVerification = WalletProvider.check(mobileNumber);

        if (mobileVerification) {
            if(otpVerification.verifyOTP(mobileNumber,scanner)) {
                WalletProvider.wallets.add(mobileNumber);

                System.out.println("Mobile number verified. Enter a username and password:");
                String enteredUsername = scanner.nextLine();
                String enteredPassword = scanner.nextLine();
                System.out.println("Enter balance:- ");
                long balance = scanner.nextLong();
                if (isUniqueUserName(enteredUsername) && isComplexPassword(enteredPassword)) {

                    User newUser = new User(enteredUsername, enteredPassword, mobileNumber, this, balance);
                    DataBase.users.add(newUser);
                    System.out.println("User registered successfully!");
                } else {
                        System.out.println("Unsuccessful. Registration aborted.");
                    }
            } else {
                System.out.println("OTP verification failed. Registration aborted.");
            }
        } else {
            System.out.println("Mobile number verification with wallet provider failed. Registration aborted.");
        }

    }
}