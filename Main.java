import manager.Bank;
import model.Account;
import exceptions.InvalidAmountException;
import exceptions.InsufficientFundsException;

public class Main { 
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account acc1 = new Account("TR1234567890", "Alice", 1000);
        Account acc2 = new Account("TR0987654321", "Bob", 500);
        Account acc3 = new Account("TR1122334455", "Charlie", 1500);
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);
        bank.showAll();

        try {
            acc1.withdraw(200);
            acc1.transfer(acc2, 300);
            acc2.deposit(100);
            acc2.withdraw(5000);
            acc3.deposit(-50);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFinal Account States:");
        bank.showAll();
    }

}