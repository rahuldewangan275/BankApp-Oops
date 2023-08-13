import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{
   private String name;
   private String accountNo; // unique UUID
    private String password;
    private double balance;
    final double rateOfInterest =7.1;
    final String IFSCCode = "ABCD1234";


    // constructor
    public HDFCAccount() {
    }
    public HDFCAccount(String name,  String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Account Balance is "+this.balance;
        }
        return "Password is Incorrect";
    }

    @Override
    public String addMoney(double amount) {
        if(amount<1){
            return "Amount is not acceptable";
        }
       this.balance += amount;
       return "Amount is added successfully. Current Balanc is : " +this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if(this.balance >= amount){
                this.balance -= amount;
                return "Withdraw completed successfully. account is deducted by:" + amount + ". Current Balance is :"+ this.balance ;
            }
        }else if(!(this.password.equals(password))){
            return "Entered Wrong Password";
        }
        return "Insufficient Balance";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
      if(this.password.equals(oldPassword)){
          this.password = newPassword;
          return "Password Changed Successfully";
      }

      return "Entered Wrong Password";
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance*rateOfInterest*year/100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
