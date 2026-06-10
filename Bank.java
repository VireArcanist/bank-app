import java.util.HashMap;

public class Bank {
    HashMap<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.iban, account);
    }

    public void showAll() {
        for (Account account : accounts.values()) {
            System.out.println(account.iban + " | " + account.owner + " | " + account.balance);
        }
    }

    public Account getAccount(String iban) {
        return accounts.get(iban);
    }  
}


