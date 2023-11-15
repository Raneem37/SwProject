import java.util.Random;
import java.util.Scanner;

public class OTP {

    public String otpMessage(String mobileNumber) {
        String id = "0123456789";
        Random random = new Random();
        StringBuilder string = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int randomI = random.nextInt(id.length());
            char randomC = id.charAt(randomI);
            string.append(randomC);
        }

        String otp= string.toString();
        System.out.println("The OTP for "+ mobileNumber + " is: " + otp);
        return otp;
    }


    protected boolean verifyOTP(String mobileNumber, Scanner scanner) {
         scanner = new Scanner(System.in);
        String otpMessage = otpMessage(mobileNumber);
        System.out.println("Please enter the OTP: ");
        String otpInput = scanner.nextLine();

        if(otpInput.equals(otpMessage)){
            return true;
        }
        else {
            return false;
        }
    }
}
