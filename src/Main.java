import java.util.ArrayList;
import java.time.LocalDateTime;

 class Transaction {
    private String sender;
    private String receiver;
    private double amount;
    private LocalDateTime localDateTime;

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        localDateTime = LocalDateTime.now();
    }

    public String toString() {
        return sender + " transferred " + "$" + amount + " to " + receiver + " at " +
                localDateTime;
    }
}
 class BankAccount {
     ArrayList<Transaction> transactions;
    private double balance;
    private String accountNumber;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println( ownerName + " Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount: $" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean transferTo(BankAccount recipient, double amount) {
        boolean success = withdraw(amount);

        if(success) {
            recipient.deposit(amount);
            Transaction transaction = new Transaction(ownerName, recipient.ownerName, amount);
            recipient.transactions.add(transaction);

            System.out.println("Transfer Succesful");
            return true;
        } else {
            System.out.println("Transfer failed - Insufficient funds.");
            return false;
        }
    }

    public void showTransaction() {
        System.out.println(ownerName + "'s transaction history");
        for(Transaction t : transactions) {
            System.out.println(t);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("001", "Alice");
        BankAccount bob = new BankAccount("002", "Bob");
        alice.deposit(100);
        bob.deposit(50);

        System.out.println("Alice balance: " + alice.getBalance());
        System.out.println("Bob balance: " + bob.getBalance());

        alice.transferTo(bob, 30);   // Should succeed
        alice.transferTo(bob, 200);  // Should fail

        alice.showTransaction();
        bob.showTransaction();



    }
}