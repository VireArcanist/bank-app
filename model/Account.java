package model;

public class Account { 
    String iban;
    String owner;
    double balance;

    public Account(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
        if (balance < 0) {
            throw new InvalidAmountException("Balance cannot be negative");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    } 

    public void withdraw(double amount) {
        if (amount <= 0){
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        this.balance -= amount;
        System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
    }

    public void transfer(Account toAccount, double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Transfer amount must be positive");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for transfer");
        }
        this.withdraw(amount);
        toAccount.deposit(amount);
        
    }
}