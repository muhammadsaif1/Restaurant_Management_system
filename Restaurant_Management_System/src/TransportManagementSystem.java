// Abstraction (Interface)
interface Vehicle {
    void start();
    void stop();
    void accelerate();
}

// Inheritance
abstract class BaseVehicle implements Vehicle {
    private String name;
    private String model;

    public BaseVehicle(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }
}

// Encapsulation
class Bus extends BaseVehicle {
    private int capacity;

    public Bus(String name, String model, int capacity) {
        super(name, model);
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus " + getName() + " started.");
    }

    @Override
    public void stop() {
        System.out.println("Bus " + getName() + " stopped.");
    }

    @Override
    public void accelerate() {
        System.out.println("Bus " + getName() + " is accelerating.");
    }

    public int getCapacity() {
        return capacity;
    }
}

class Car extends BaseVehicle {
    private int passengerCapacity;

    public Car(String name, String model, int passengerCapacity) {
        super(name, model);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void start() {
        System.out.println("Car " + getName() + " started.");
    }

    @Override
    public void stop() {
        System.out.println("Car " + getName() + " stopped.");
    }

    @Override
    public void accelerate() {
        System.out.println("Car " + getName() + " is accelerating.");
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
}

// Polymorphism
public class TransportManagementSystem {
    public static void main(String[] args) {
        Vehicle universityBus = new Bus("University Bus", "Model X", 50);
        Vehicle universityCar = new Car("University Car", "Model Y", 4);

        manageVehicle(universityBus);
        manageVehicle(universityCar);
    }

    public static void manageVehicle(Vehicle vehicle) {
        System.out.println("Managing " + vehicle.getClass().getSimpleName());
        vehicle.start();
        vehicle.accelerate();
        vehicle.stop();
        if (vehicle instanceof Bus) {
            Bus bus = (Bus) vehicle;
            System.out.println("Bus Capacity: " + bus.getCapacity() + " passengers");
        } else if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println("Car Passenger Capacity: " + car.getPassengerCapacity() + " passengers");
        }
    }
}
