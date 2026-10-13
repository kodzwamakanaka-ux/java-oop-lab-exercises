// Assignment 7 (Lab 7) - Exercise 4: withdraw now THROWS instead of returning false
public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + ": balance is only " + balance, amount - balance);
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }
}
