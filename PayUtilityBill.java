import java.util.Scanner;

class PayUtilityBill implements PaymentStrategy {
    Scanner scanner = new Scanner(System.in);
    User thisUser;

    @Override
    public void processPayment(User thisUser) {
        this.thisUser = thisUser;
        System.out.println("Utility bill payment processed.");
        System.out.println("1. Pay gas bill");
        System.out.println("2. Pay water bill");
        System.out.println("3. Pay electricity bill");
        System.out.println("4. Back");
        int billsChoice = scanner.nextInt();

        switch (billsChoice) {
            case 1 -> handleBill(new GasBill(), "gas");
            case 2 -> handleBill(new WaterBill(), "water");
            case 3 -> handleBill(new ElectricityBill(), "electricity");
            case 4 -> System.out.println("BYE");
            default -> System.out.println("Error, please enter a valid choice.");
        }
    }

    private void handleBill(Bills bill, String billType) {
        bill.createBill();
        System.out.println("Do you wish to pay the " + billType + " bill?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int yesOrNo = scanner.nextInt();

        switch (yesOrNo) {
            case 1 -> bill.payBill(thisUser);
            case 2 -> System.out.println("BYE");
            default -> System.out.println("Error!");
        }
    }
}
