import java.util.ArrayList;
import java.util.Objects;

public class WalletProvider {


    protected static ArrayList<String> wallets = new ArrayList<>();

    public static boolean check(String mobile) {
        for (User user : DataBase.users) {
            if (Objects.equals(user.getMobileNumber(), mobile)) {
                return false;
            }
        }

        if (wallets.contains(mobile)) return false;


        return true;
    }
}
