import java.util.Random;
public class ElectricityBill implements Bills{

    private long amount;

    ElectricityBill() { this.amount = generateBill(); }

    @Override
    public void createBill() {
        System.out.println("Your electricity bill is: "+ this.amount);
    }

    @Override
    public void payBill(User user) {
        if(user.getBalance() < amount) {
            System.out.println("Not Sufficient Funds to pay the electricity bill!");
            return;
        }
        System.out.println("Electricity Bill paid with amount "+ amount);
        user.setBalance(user.getBalance() - amount);
        System.out.println("Your current Balance is "+ user.getBalance());
    }
    @Override
    public int generateBill() {
        return new Random().nextInt(2000);

    }


}