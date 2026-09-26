abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    abstract String getType();
}

class Student extends Customer {

    Student(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount - (amount * 0.10);
    }

    @Override
    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {

    Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount - (amount * 0.05);
    }

    @Override
    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {

    Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }

    @Override
    String getType() {
        return "GUEST";
    }
}

public class CanteenTest {

    public static void main(String[] args) {

        Customer[] customers = {
            new Student(200),
            new Staff(300),
            new Guest(150)
        };

        double total = 0;

        for (Customer customer : customers) {

            double finalAmount =
                    customer.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                customer.getType(),
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