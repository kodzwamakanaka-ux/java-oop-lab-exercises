// Assignment 6 (Lab 6) - Exercise 3 (Intermediate)
public abstract class Account {
    protected double balance;

    protected Account(double openingBalance) { this.balance = openingBalance; }

    // Concrete method shared by all accounts
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    // Each account type decides its own fee
    public abstract double monthlyFee();

    public void applyMonthlyFee() { balance -= monthlyFee(); }

    public double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    SavingsAccount(double openingBalance) { super(openingBalance); }

    // Savings: free if balance is at least 1000, otherwise 5
    @Override public double monthlyFee() { return balance >= 1000 ? 0.0 : 5.0; }
}

class CurrentAccount extends Account {
    CurrentAccount(double openingBalance) { super(openingBalance); }

    // Current: flat monthly fee of 15
    @Override public double monthlyFee() { return 15.0; }
}
