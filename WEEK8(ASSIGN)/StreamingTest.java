import java.time.LocalDate;

abstract class SubscriptionPlan {

    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class BasicPlan extends SubscriptionPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingTest {

    public static void main(String[] args) {

        SubscriptionPlan[] subscribers = {

            new BasicPlan(
                "Asha",
                LocalDate.parse("2024-01-15")
            ),

            new StandardPlan(
                "Ravi",
                LocalDate.parse("2024-02-01")
            ),

            new PremiumPlan(
                "Neha",
                LocalDate.parse("2024-03-10")
            ),

            new BasicPlan(
                "Kiran",
                LocalDate.parse("2024-12-20")
            )
        };

        for (SubscriptionPlan plan : subscribers) {

            System.out.println(
                plan.name + ": "
                + plan.getRenewalDate()
            );
        }
    }
}