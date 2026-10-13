// Assignment 3 (Lab 3) - Exercise 3: shows the history getter is protected
import java.util.List;

public class BankHistoryDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500);
        acc.deposit(250);
        acc.withdraw(100);
        acc.withdraw(5000);

        List<String> h = acc.getHistory();
        h.forEach(System.out::println);

        try {
            h.add("Deposit 1000000");   // tampering attempt
        } catch (UnsupportedOperationException e) {
            System.out.println("Tampering blocked: history is unmodifiable");
        }
    }
}
