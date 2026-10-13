package l_designpatterns.behavioral;

// strategy interface
interface PaymentStrategy {
    void processPayment();
}

/*
 * concrete strategy implementations
 */
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }

}

class UPIPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment...");
    }

}

class NetBankingPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing net banking transaction");
    }

}

// context
class PaymentProcessor {
    private PaymentStrategy paymentStrategy; // reference

    // constructor injection to set payment strategy
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // dynamically change payment strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // process payment using current strategy
    public void processPayment() {
        paymentStrategy.processPayment();
    }
}

// client
public class Strategy {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment();
        PaymentStrategy upi = new UPIPayment();

        PaymentProcessor processor = new PaymentProcessor(creditCard);
        processor.processPayment();

        processor.setPaymentStrategy(upi);
        processor.processPayment();

        processor.setPaymentStrategy(new NetBankingPayment());
        processor.processPayment();
    }
}
