package l_designpatterns.structural.adapter;

interface PaymentProcessor {
    void processPayment(double amount, String currency);

    boolean isPaymentSuccessful();

    String getTransactionId();
}

class InHousePaymentProcessor implements PaymentProcessor {
    private String transactionId;
    private boolean paymentSuccessful;

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("InHouse: Processing " + amount + " " + currency);
        transactionId = "TXN_" + System.currentTimeMillis();
        paymentSuccessful = true;
        System.out.println("InHouse: Success. Txn ID: " + transactionId);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return paymentSuccessful;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}

class CheckoutService {
    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount, String currency) {
        System.out.println("Checkout: Processing order for " + amount + " " + currency);
        paymentProcessor.processPayment(amount, currency);
        if (paymentProcessor.isPaymentSuccessful()) {
            System.out.println("Transaction successful " + paymentProcessor.getTransactionId());
        } else {
            System.out.println("Payment failed");
        }
    }
}

public class ECommerceAppV1 {
    public static void main(String[] args) {
        // PaymentProcessor processor = new InHousePaymentProcessor();
        // CheckoutService checkout = new CheckoutService(processor);
        // checkout.checkout(199, "INR");
    }
}
