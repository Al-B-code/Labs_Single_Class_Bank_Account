import org.assertj.core.api.Assert;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDate;

import static java.lang.Math.round;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat; // Will be used at one point


public class BankAccountTest {

//    There should be a getter for each property so: getFirstName, getLastName, getDOB, GetAccountNumber,
//    and getAccountBalance



    BankAccount bankAccount;

    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount(
                "Firstname",
                "Lastname",
                "1970-01-01",
                123456789,
                "Current Account",
                -500);
    }

    @Test
    void canGetFirstName(){
//      Test getFirstName
        //Default value for firstname is an "Firstname"
        assertThat(bankAccount.getFirstName()).isEqualTo("Firstname");
    }
    @Test
    void canGetLastName(){
//      Test getLastName
        //Default value for firstname is an "Firstname"
        assertThat(bankAccount.getLastName()).isEqualTo("Lastname");
    }
    @Test
    void canGetDateOfBirth(){
        assertThat(bankAccount.getDateOfBirth()).isEqualTo(LocalDate.of(1970, 01, 01));
    }
    @Test
    void canGetAccountNumber(){
        assertThat(bankAccount.getAccountNumber()).isEqualTo(123456789);
    }
    @Test
    void canGetBalance(){
        assertThat(bankAccount.getBalance()).isEqualTo(0);
    }
    void canGetAccountType(){
        assertThat((bankAccount.getAccountType())).isEqualTo("Current Account");
    }


//      There should be a setter for each property: so setFirstName, setLastName, setDOB, setAccountNumber
//      and setAccountBalance
    @Test
    void canSetFirstName(){
        bankAccount.setFirstName("John");
        assertThat(bankAccount.getFirstName()).isEqualTo("John");
    }

    @Test
    void canSetLastName(){
        bankAccount.setLastName("Smith");
        assertThat(bankAccount.getLastName()).isEqualTo(("Smith"));
    }

    @Test
    void canSetDateOfBirth(){
        bankAccount.setDateOfBirth("2023-02-08");
        assertThat(bankAccount.getDateOfBirth()).isEqualTo(LocalDate.of(2023,2,8));
    }
    @Test
    void canSetAccountNumber(){
        bankAccount.setAccountNumber(987654321);
        assertThat(bankAccount.getAccountNumber()).isEqualTo(987654321);
    }

    @Test
    void canSetBalance(){
        bankAccount.setBalance(2500);
        assertThat(bankAccount.getBalance()).isEqualTo(2500);
    }
    @Test
    void canSetAccountType(){
        assertThat(bankAccount.getAccountType()).isEqualTo("Current Account");
        bankAccount.setAccountType("Savings Account");
        assertThat((bankAccount.getAccountType())).isEqualTo("Savings Account");
    }



    @Test
    void canDeposit(){
//        This will test the deposit method on the bank account object.
        assertThat(bankAccount.getBalance()).isEqualTo(0);
        bankAccount.deposit(100);
        assertThat(bankAccount.getBalance()).isEqualTo(100);
        bankAccount.deposit(50);
        assertThat(bankAccount.getBalance()).isEqualTo(150);
    }

    @Test
    void canWithdraw(){
//        This will test the deposit method on the bank account object.
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
        bankAccount.setBalance(100);
        bankAccount.payInterest();
        assertThat(bankAccount.getBalance()).isEqualTo(105);
        bankAccount.payInterest();
        assertThat(bankAccount.getBalance()).isEqualTo(110.25);
    }
@Test
    void accountTypeAltersPayInterest(){
        bankAccount.setBalance(100);
        bankAccount.setAccountType("Savings Account");
        bankAccount.payInterest();
        assertThat(round(bankAccount.getBalance())).isEqualTo(110);
        bankAccount.payInterest();
        assertThat(round(bankAccount.getBalance())).isEqualTo(121);
    }
    @Test
    void overdraft(){
        bankAccount.withdraw(100);
        assertThat(bankAccount.getBalance()).isEqualTo(-100);
        bankAccount.withdraw(500);
        assertThat(bankAccount.withdraw(500)).isEqualTo(1);
        assertThat(bankAccount.getBalance()).isEqualTo(-100);
    }
}
