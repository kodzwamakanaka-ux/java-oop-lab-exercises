// Assignment 6 (Lab 6) - Exercise 3
public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = { new SavingsAccount(800), new CurrentAccount(2000) };
        for (Account a : accounts) {
            a.deposit(200);
            a.applyMonthlyFee();
            System.out.printf("%s fee=%.2f balance=%.2f%n",
                    a.getClass().getSimpleName(), a.monthlyFee(), a.getBalance());
        }
    }
}
