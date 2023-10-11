import org.assertj.core.api.Assert;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat; // Will be used at one point


public class BankAccountTest {

//    There should be a getter for each property so: getFirstName, getLastName, getDOB, GetAccountNumber,
//    and getAccountBalance
    @Test
    void canGetFirstName(){
//      Test getFirstName
        BankAccount bankAccount = new BankAccount();
        //Default value for firstname is an "Firstname"
        assertThat(bankAccount.getFirstName()).isEqualTo("Firstname");
    }
    @Test
    void canGetLastName(){
//      Test getLastName
        BankAccount bankAccount = new BankAccount();
        //Default value for firstname is an "Firstname"
        assertThat(bankAccount.getLastName()).isEqualTo("Lastname");
    }
    @Test
    void canGetDateOfBirth(){
        BankAccount bankAccount = new BankAccount();
        assertThat(bankAccount.getDateOfBirth()).isEqualTo(LocalDate.of(1970, 01, 01));
    }
    @Test
    void canGetAccountNumber(){
        BankAccount bankAccount = new BankAccount();
        assertThat(bankAccount.getAccountNumber()).isEqualTo(123456789);
    }
    @Test
    void canGetBalance(){
        BankAccount bankAccount = new BankAccount();
        assertThat(bankAccount.getBalance()).isEqualTo(0);
    }


//      There should be a setter for each property: so setFirstName, setLastName, setDOB, setAccountNumber
//      and setAccountBalance
    @Test
    void canSetFirstName(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setFirstName("John");
        assertThat(bankAccount.getFirstName()).isEqualTo("John");
    }

    @Test
    void canSetLastName(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setLastName("Smith");
        assertThat(bankAccount.getLastName()).isEqualTo(("Smith"));
    }

    @Test
    void canSetDateOfBirth(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setDateOfBirth("2023-02-08");
        assertThat(bankAccount.getDateOfBirth()).isEqualTo(LocalDate.of(2023,2,8));
    }
    @Test
    void canSetAccountNumber(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(987654321);
        assertThat(bankAccount.getAccountNumber()).isEqualTo(987654321);
    }

    @Test
    void canSetBalance(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(2500);
        assertThat(bankAccount.getBalance()).isEqualTo(2500);
    }



    @Test
    void canDeposit(){
//        This will test the deposit method on the bank account object.

        BankAccount bankAccount = new BankAccount();
        assertThat(bankAccount.getBalance()).isEqualTo(0);
        bankAccount.deposit(100);
        assertThat(bankAccount.getBalance()).isEqualTo(100);
        bankAccount.deposit(50);
        assertThat(bankAccount.getBalance()).isEqualTo(150);
    }

    @Test
    void canWithdraw(){
//        This will test the deposit method on the bank account object.
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(100);
        assertThat(bankAccount.getBalance()).isEqualTo(100);
        bankAccount.withdraw(50);
        assertThat(bankAccount.getBalance()).isEqualTo(50);
        bankAccount.withdraw(50);
        assertThat(bankAccount.getBalance()).isEqualTo(0);
        bankAccount.withdraw(50);
        assertThat(bankAccount.getBalance()).isEqualTo(-50);

    }

    @Test
    void canPayInterest(){
//        This will test the payinterest method on the bank account object.
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(100);
        bankAccount.payInterest();
        assertThat(bankAccount.getBalance()).isEqualTo(105);
        bankAccount.payInterest();
        assertThat(bankAccount.getBalance()).isEqualTo(110.25);
    }






}
