// Assignment 5 (Lab 5) - Exercise 5 (Challenge)
public class PaymentProcessor {

    // DESIGN A: instanceof pattern matching. The processor must know every concrete type.
    public void pay(Payment p) {
        if (p instanceof CardPayment c) {
            System.out.println("[A] Charging card ****" + c.last4() + " for " + c.amount);
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.println("[A] Mobile money request to " + m.phone() + " for " + m.amount);
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }

    // DESIGN B: polymorphic process(). The processor does not care about concrete types.
    public void payPolymorphic(Payment p) {
        p.process();
    }

    /* COMPARISON:
       Design A: all type-specific logic is in one place, but every new payment type (e.g. PayPal)
       forces you to edit pay() and add another branch. Forgetting a branch is only caught at run time.
       Design B: each class owns its own behaviour; adding PayPalPayment needs NO change to the processor
       (open for extension, closed for modification). The compiler also forces new subclasses to implement
       process(). Design B is preferred here. instanceof is best kept for cases where the behaviour does
       not belong inside the class (for example, code you cannot modify). */
}
