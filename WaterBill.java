import java.util.Random;

public class WaterBill implements Bills {
    private long amount;

    WaterBill() { this.amount = generateBill(); }

    @Override
    public void createBill() {
        System.out.println("Your water bill is: "+ this.amount);
    }

    @Override
    public void payBill(User user) {
        if(user.getBalance() < amount) {
            System.out.println("Not Sufficient Funds to pay the Water bill!");
            return;
        }
        System.out.println("Water Bill paid with amount "+ amount);
        user.setBalance(user.getBalance() - amount);
        System.out.println("Your current Balance is "+ user.getBalance());
    }
    @Override
    public int generateBill() {
        return new Random().nextInt(1000);

    }


}