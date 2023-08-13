public class Main {
    public static void main(String[] args) {

HDFCAccount tonyAcc = new HDFCAccount("Tony Stark","123456",2000);
System.out.println(tonyAcc);
          // add money
        System.out.println(tonyAcc.addMoney(10000));

        //fetch balance
        System.out.println(tonyAcc.fetchBalance("12345")); // wrong password
        System.out.println(tonyAcc.fetchBalance("123456")); // correct password

            //withdraw money
        System.out.println(tonyAcc.withdrawMoney(50000 , "123456"));
        System.out.println(tonyAcc.withdrawMoney(500,"1234")); // wrong password
        System.out.println(tonyAcc.withdrawMoney(500,"123456")); // right password

            //change password
        System.out.println(tonyAcc.changePassword("1234","1234abc")); // wrong password
        System.out.println(tonyAcc.changePassword("123456","1234abc"));

        // interest
        System.out.println("Interest of Tonys Account for 3 years : "+tonyAcc.calculateInterest(3));
    }
}