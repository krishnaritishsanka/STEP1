abstract class Payment {

    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    abstract String getType();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {

    WalletPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {

    BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount;
    }

    @Override
    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentTest {

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(1000),
            new WalletPayment(500),
            new BankTransferPayment(2000)
        };

        double total = 0;

        for (Payment payment : payments) {

            double finalAmount =
                    payment.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                payment.getType(),
                finalAmount
            );

            total += finalAmount;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );
    }
}