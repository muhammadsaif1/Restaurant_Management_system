import java.util.ArrayList;
import java.util.Scanner;

abstract class FoodItem {
    protected String name;
    protected double pricePKR;

    public FoodItem(String name, double pricePKR) {
        this.name = name;
        this.pricePKR = pricePKR;
    }

    public String getName() {
        return name;
    }

    public double getPricePKR() {
        return pricePKR;
    }

    public abstract void prepare();
}

class Starter extends FoodItem {
    public Starter(String name, double pricePKR) {
        super(name, pricePKR);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing starter: " + getName());
    }
}

class MainCourse extends FoodItem {
    public MainCourse(String name, double pricePKR) {
        super(name, pricePKR);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing main course: " + getName());
    }
}

class Order {
    private ArrayList<FoodItem> items = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();

    public void addItem(FoodItem item, int quantity) {
        items.add(item);
        quantities.add(quantity);
    }

    public void placeOrder() {
        System.out.println("Your Order:");
        double totalBillPKR = 0;

        for (int i = 0; i < items.size(); i++) {
            FoodItem item = items.get(i);
            int quantity = quantities.get(i);

            item.prepare();
            System.out.println("Adding " + item.getName() + " (Quantity: " + quantity + ") to the order.");
            totalBillPKR += item.getPricePKR() * quantity;
        }

        System.out.println("Total Bill: PKR " + totalBillPKR);
    }
}

 public class Saif_Restaurant_Management_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        ArrayList<FoodItem> menu = new ArrayList<>();
        menu.add(new Starter("Salad", 300.0));
        menu.add(new Starter("Smoothie",150));
        menu.add(new Starter("Tea",100));
        menu.add(new Starter("French Fries",100));
        menu.add(new MainCourse("Zinger Burger",650));
        menu.add(new MainCourse("Pasta", 600.0));
        menu.add(new MainCourse("Chicken Biryani",300));
        menu.add(new MainCourse("Club Sandwich",1100));


        while (true) {
            System.out.println("Menu:");
            for (int i = 0; i < menu.size(); i++) {
                FoodItem item = menu.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " - PKR " + item.getPricePKR());
            }

            System.out.println("Enter the number of the dish you want to order (0 to finish):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();

            if (choice >= 1 && choice <= menu.size()) {
                order.addItem(menu.get(choice - 1), quantity);
            } else {
                System.out.println("Invalid choice.");
            }

            System.out.print("Do you want to order another dish? (y/n): ");
            char anotherDish = scanner.next().charAt(0);

            if (anotherDish == 'n' || anotherDish == 'N') {
                break;
            }
        }

        // Place the order
        order.placeOrder();
    }
}
