import java.util.Random;

public class GasBill implements Bills{

    private long amount;

    GasBill() { this.amount = generateBill(); }

    @Override
    public void createBill() {
        System.out.println("Your gas bill is: "+ this.amount);
    }

    @Override
    public void payBill(User user) {
        if(user.getBalance() < amount) {
            System.out.println("Not Sufficient Funds to pay the gas bill!");
            return;
        }
        System.out.println("Gas Bill paid with amount "+ amount);
        user.setBalance(user.getBalance() - amount);
        System.out.println("Your current Balance is "+ user.getBalance());
    }
    @Override
    public int generateBill() {
        return new Random().nextInt(500);

    }

}