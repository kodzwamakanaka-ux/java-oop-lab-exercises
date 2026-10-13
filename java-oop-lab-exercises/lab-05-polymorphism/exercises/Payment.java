// Assignment 5 (Lab 5) - Exercise 5 (Challenge): the payment types
public abstract class Payment {
    protected final double amount;

    protected Payment(double amount) { this.amount = amount; }

    // Used by the polymorphic design (Design B)
    public abstract void process();
}

class CardPayment extends Payment {
    private final String cardNumber;

    CardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    String last4() { return cardNumber.substring(cardNumber.length() - 4); }

    @Override
    public void process() {
        System.out.println("Charging card ****" + last4() + " for " + amount);
    }
}

class MobileMoneyPayment extends Payment {
    private final String phone;

    MobileMoneyPayment(double amount, String phone) {
        super(amount);
        this.phone = phone;
    }

    String phone() { return phone; }

    @Override
    public void process() {
        System.out.println("Requesting mobile money approval from " + phone + " for " + amount);
    }
}
