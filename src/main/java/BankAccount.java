import java.time.LocalDate;

public class BankAccount {

    private String firstName = "Firstname";
    private String lastName = "Lastname";
    private LocalDate dateOfBirth = LocalDate.parse("1970-01-01");
    private int accountNumber;
    private double balance = 0;
    private String accountType;
    private double overdraft;


    public BankAccount(String firstName,
                       String lastName,
                       String dateOfBirth,
                       int accountNumber,
                       String accountType,
                       double overdraft) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.overdraft = overdraft;

    }

//    Below are the getters.
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
    public String getAccountType(){
        return this.accountType;
    }

//    Below are the setters.
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }


//    Deposit method
    public void deposit(int depositAmount){
        this.balance += depositAmount;
    }
//    Withdraw method
    public int withdraw(int withdrawAmount){
        if ((this.balance - withdrawAmount) > overdraft){
            this.balance -= withdrawAmount;
            return 0;
        }
            return 1;

    }



// PayInterest method
    public void payInterest(){
        if (this.getAccountType().equals("Current Account")){
            this.balance *= 1.05;
        }
        if (this.getAccountType().equals("Savings Account")){
            this.balance *= 1.10;
        }
    }

//
}
