class Loan {
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int termInYears;

    Loan(String customerName, double amount, double interestRate, int termInYears) {
        this. customerName = customerName;
        this.amount = amount;
        this.interestRate = interestRate;
        this.termInYears = termInYears;
    }

    double calculateRepayment() {
        double interest = amount * interestRate * termInYears;
        return amount + interest;
    }

    void printSummary() {
        System.out.println("Customer: " + customerName);
        System.out.println("Amount: " + amount);
        System.out.println("Interest: " + (interestRate * 100) + "%");
        System.out.println("Term: " + termInYears + " years");
        System.out.println("Total Repayment: " + calculateRepayment());
    }
}

class PersonalLoan extends Loan {
    PersonalLoan(String customer, double amount, double interestRate, int termInYears) {
        super(customer, amount, interestRate, termInYears);
    }

    @Override
    void printSummary() {
        System.out.println("[Personal Loan]");
        super.printSummary();
    }
}

class BusinessLoan extends Loan {
    BusinessLoan(String customer, double amount, double interestRate, int termInYears) {
        super(customer, amount, interestRate, termInYears);
    }

    @Override
    void printSummary() {
        System.out.println("[Business Loan]");
        super.printSummary();
    }
}


public class Main {
    public static void main(String[] args) {
        Loan person1 = new PersonalLoan("Mark", 50000, 0.05, 5);
        person1.printSummary();

        Loan person2 = new BusinessLoan("Mark", 10000, 0.03, 1);
        person2.printSummary();

    }
}
