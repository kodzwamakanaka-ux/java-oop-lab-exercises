// Assignment 5 (Lab 5) - Exercise 5: runs both designs
public class PaymentDemo {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(120.50, "4111111111111234"),
            new MobileMoneyPayment(30.00, "+263771234567")
        };

        PaymentProcessor processor = new PaymentProcessor();
        for (Payment p : payments) processor.pay(p);
        for (Payment p : payments) processor.payPolymorphic(p);
    }
}
