import java.util.Scanner;

class TransferToMobileWallet implements PaymentStrategy {
    Scanner scanner = new Scanner(System.in);
     @Override
    public void processPayment(User thisUser) {

        System.out.println("Please write the receiver's mobile number:- ");
        String mobileNumber = scanner.nextLine();
         boolean userFound = false;
        for (User u: DataBase.users) {
            if(u.getMobileNumber().equals(mobileNumber)){
                userFound = true;
                System.out.println("How much would you like to transfer:- ");
                long transferredMoney= scanner.nextLong();
                if (thisUser.getBalance()<transferredMoney) {
                    System.out.println("Not enough balance, please try again");
                } else {
                    u.setBalance(u.getBalance()+transferredMoney);
                    thisUser.setBalance(thisUser.getBalance()-transferredMoney);
                    System.out.println("Balance was Transferred correctly");
                }

                break;
            }



        }
         if (!userFound){
             System.out.println("No user with this mobile number was found.");
         }
    }
}