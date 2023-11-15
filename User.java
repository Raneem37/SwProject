class User {

    private long balance;
    private String username;
    private String password;
    private String mobileNumber;
    private UserRegistration accountType;

    private String accountNumber;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public User(String username, String password, String mobileNumber, UserRegistration accountType, long balance) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password) ;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getMobileNumber() { return mobileNumber; }

    public long getBalance() { return balance; }

    public void setBalance(long balance) { this.balance = balance; }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAccountType(UserRegistration accountType) {
        this.accountType = accountType;
    }

    public UserRegistration getAccountType() {
        return accountType;
    }
}