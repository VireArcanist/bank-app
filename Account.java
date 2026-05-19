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
}