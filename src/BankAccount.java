public class BankAccount {
    public String name;
    private int balance;

    public BankAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit (int amount) {
        balance += amount;
        System.out.println(name + ", You deposit: " + amount);

    }

    void withdraw (int amount) {
        balance -= amount;
        System.out.println(name + ", You withdrew: " + amount);

    }

    public void getBalance() {
        System.out.println("Hello, " + name + " Your Balance is: " + balance);
    }
}
