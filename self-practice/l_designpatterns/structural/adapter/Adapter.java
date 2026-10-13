package l_designpatterns.structural.adapter;

class LegacyGateway {
    private long transactionReference;
    private boolean paymentSuccessful;

    public void executeTransaction(double totalAmount, String currency) {
        System.out.println("LegacyGateway: Executing " + totalAmount + " " + currency);
        transactionReference = System.nanoTime();
        paymentSuccessful = true;
        System.out.println("LegacyGateway: Success. Txn ID: " + transactionReference);
    }

    public boolean checkStatus(long ref) {
        return paymentSuccessful;
    }

    public long getReferenceNumber() {
        return transactionReference;
    }
}

class LegacyGatewayAdapter implements PaymentProcessor {
    private final LegacyGateway legacyGateway;
    private long currentRef;

    public LegacyGatewayAdapter(LegacyGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Adapter: Translating processPayment() for " + amount + " " + currency);
        legacyGateway.executeTransaction(amount, currency);
        currentRef = legacyGateway.getReferenceNumber();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return legacyGateway.checkStatus(currentRef);
    }

    @Override
    public String getTransactionId() {
        return "LEGACY_TXN_" + currentRef;
    }
}

public class Adapter {
    public static void main(String[] args) {
        PaymentProcessor processor = new InHousePaymentProcessor();
        CheckoutService checkout = new CheckoutService(processor);
        System.out.println("--- Using modern Processor ---");
        checkout.checkout(199, "INR");

        LegacyGateway legacy = new LegacyGateway();
        processor = new LegacyGatewayAdapter(legacy);
        CheckoutService legacyCheckout = new CheckoutService(processor);

        System.out.println("\n--- Using legacy gateway via Adapter ---");
        legacyCheckout.checkout(75.50, "USD");

    }
}