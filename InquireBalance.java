class InquireBalance implements PaymentStrategy {
    @Override
    public void processPayment(User thisUser) {
        System.out.println("Inquiring about balance processed.");
        System.out.println("Your Balance is: "+ thisUser.getBalance());
    }
}