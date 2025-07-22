package projects.Loan;

public class LoanMain {
    public static void main(String[] args) {
        Loan person1 = new PersonalLoan("Mark", 50000, 0.05, 5);
        person1.printSummary();

        Loan person2 = new BusinessLoan("Mark", 10000, 0.03, 1);
        person2.printSummary();

    }
}