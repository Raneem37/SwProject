import java.util.*;

abstract class UserRegistration {
    public static boolean isComplexPassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password should be at least 8 characters long.");
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password should contain at least one uppercase letter.");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            System.out.println("Password should contain at least one digit.");
            return false;
        }
        return true;
    }

    public static boolean isUniqueUserName(String userName) {
        for(int i=0;i<DataBase.users.size();i++){
            if(userName.equals(DataBase.users.get(i).getUsername())){
                System.out.println("This username already exists.");
                return false;
            }
        }
        return true;
    }

    public static User login(Scanner scanner , InstaPay instaPay) {
         scanner = new Scanner(System.in);
        System.out.println("Enter your user name:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        User user = null;
        Iterator itr = DataBase.users.iterator();

        while(itr.hasNext()) {
            User u = (User)itr.next();
            if (u.authenticate(username, password)) {
                user = u;
                System.out.println("You are logged in.");
                if(u.getAccountType() instanceof BankAccountRegistration) {
                    instaPay= new BankInstaPay();
                    instaPay.displayUserBankMenu(u);

                }
                if(u.getAccountType() instanceof WalletRegistration) {
                    instaPay= new WalletInstaPay();
                    instaPay.displayUserBankMenu(u);
                }
                break;
            }
        }

        if (user == null) {
            System.out.println("Invalid email or password.");
        }
     return user;
    }

     public abstract void registerUser(Scanner scanner);
}