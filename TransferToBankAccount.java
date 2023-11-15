import java.util.Scanner;

public class TransferToBankAccount implements PaymentStrategy {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void processPayment(User thisUser) {
        boolean uerFound = false;
        System.out.println("Please write the receiver's bank number:- ");
        String bankNumber = scanner.nextLine();
        for (User u: DataBase.users) {
            if(u.getAccountNumber().equals(bankNumber)){
                uerFound= true;
                System.out.println("How much would you like to transfer:- ");
                long transferredMoney= scanner.nextLong();
                if (thisUser.getBalance()<transferredMoney) {
                    System.out.println("Not enough balance, please try again");
                } else {
                    u.setBalance(u.getBalance()+transferredMoney);
                    thisUser.setBalance(thisUser.getBalance()-transferredMoney);
                    System.out.println("Balance was Transferred correctly");
                }

            }
        }
        if(!uerFound){
            System.out.println("No user with this bank number was found.");
        }
    }
}
