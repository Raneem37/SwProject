import java.util.*;

public class Bank_API {
    protected static ArrayList<String> bank_accs = new ArrayList<>();

    public static String APIGenerator() {
        String id = "0123456789";
        Random random = new Random();
        StringBuilder string = new StringBuilder(4);

        for (int i = 0; i <4; i++) {
            int randomI = random.nextInt(id.length());
            char randomC = id.charAt(randomI);
            string.append(randomC);
        }

        return (string.toString());
    }
    public static boolean check(String mobile) {
        // Check if the phone number is associated with any existing bank account
        for (String accNum : bank_accs) {
            for (User u : DataBase.users) {
                if (Objects.equals(u.getAccountNumber(), accNum) && Objects.equals(u.getMobileNumber(), mobile)) {
                    return false; // Phone number is associated with an existing bank account
                }
            }
        }
        return true; // Phone number is not associated with any existing bank account
    }
}
