abstract class Vehicle {

    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();

    abstract String getType();
}

class Bike extends Vehicle {

    Bike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10;
    }

    @Override
    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {

    Car(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {

        if (hours == 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }

    @Override
    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {

    Truck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {

        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    @Override
    String getType() {
        return "TRUCK";
    }
}

public class ParkingTest {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
            new Bike(3),
            new Car(4),
            new Truck(1),
            new Car(1)
        };

        double total = 0;

        for (Vehicle vehicle : vehicles) {

            double charge =
                    vehicle.calculateCharge();

            System.out.printf(
                "%s: %.2f%n",
                vehicle.getType(),
                charge
            );

            total += charge;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );
    }
}