import java.util.Scanner;

class TransferToAnotherAccount implements PaymentStrategy {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void processPayment(User thisUser) {
        boolean userFound = false;
        System.out.println("Please write the receiver's username:- ");
        String userName = scanner.nextLine();
        for (User u: DataBase.users) {
            if(u.getUsername().equals(userName)){
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
        if(!userFound) {
            System.out.println("No user with this name was found.");
        }
    }

}