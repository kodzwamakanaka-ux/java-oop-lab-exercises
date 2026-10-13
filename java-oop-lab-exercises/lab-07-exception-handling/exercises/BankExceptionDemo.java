// Assignment 7 (Lab 7) - Exercise 4
public class BankExceptionDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500);
        try {
            acc.withdraw(100);
            System.out.println("Withdrawal OK. " + acc);
            acc.withdraw(5000);
            System.out.println("This line is skipped");
        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage() + " (short by " + e.getShortfall() + ")");
        }

        /* TRADE-OFFS (boolean return vs checked exception):
           + Exception: callers cannot silently ignore a failure (the compiler forces handling), and the
             exception carries a message and extra data such as the shortfall.
           + Keeps the normal return path clean; no 'if (!withdraw())' after every call.
           - More code for callers (try/catch), and checked exceptions can clutter method signatures.
           - Exceptions are slower than a plain boolean, so they suit exceptional situations, not routine
             control flow. A boolean is simple, but callers can forget to check it and the failure reason
             is lost. */
    }
}
