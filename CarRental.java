
import java.util.*;

class car {

    private String carID;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public car(String carID, String brand, String model, double basePricePerDay) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getId() {
        return carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

}

class customer {

    private String name;
    private String id;

    public customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

class Rental {

    private car Car;
    private customer Customer;
    private int days;

    public Rental(car Car, customer Customer, int days) {
        this.Car = Car;
        this.Customer = Customer;
        this.days = days;
    }

    public car getCar() {
        return Car;
    }

    public customer getCustomer() {
        return Customer;
    }

    public int getDays() {
        return days;
    }

}

class CarRentalSystem {

    private ArrayList<car> Cars;
    private ArrayList<customer> Customers;
    private ArrayList<Rental> Rentals;

    public CarRentalSystem() {
        Cars = new ArrayList<>();
        Customers = new ArrayList<>();
        Rentals = new ArrayList<>();
    }

    public void addCar(car Car) {
        Cars.add(Car);
    }

    public void addCustomer(customer Customer) {
        Customers.add(Customer);
    }

    public void RentCar(car Car, customer Customer, int days) {
        if (Car.isAvailable()) {
            Car.rent();
            Rentals.add(new Rental(Car, Customer, days));
        } else {
            System.out.println("Car is not available for rent. ");
        }
    }

    public void renturnCar(car Car) {
        Car.returnCar();

        Rental rentalToremove = null;
        for (Rental rental : Rentals) {
            if (rental.getCar() == Car) {
                rentalToremove = rental;
                break;
            }
        }
        if (rentalToremove != null) {
            Rentals.remove(rentalToremove);
        } else {
            System.out.println("Car was not Rented ");
        }
    }

    public void menu() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Car Rental System ");
            System.out.println("1. Rent a Car ");
            System.out.println("2. Return a Car");
            System.out.println("3. EXIT ");
            System.out.print("Enter your choice ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.println("Rent a Car ");
                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                System.out.println("\nAvailable Cars ");
                for (car Car : Cars) {
                    if (Car.isAvailable()) {

                        System.out.println(Car.getId() + " - " + Car.getBrand() + " " + Car.getModel());
                    }
                }

                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = sc.nextLine();

                System.out.print("\n Enter the number of days for rent: ");
                int rentalDay = sc.nextInt();
                sc.nextLine();

                customer newCustomer = new customer("CUS" + (Customers.size() + 1), name);
                addCustomer(newCustomer);

                car selectedCar = null;
                for (car Car : Cars) {
                    if (Car.getId().equals(carId) && Car.isAvailable()) {
                        selectedCar = Car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDay);
                    System.out.println("\nRental Information ");
                    System.out.println("Customer ID: " + newCustomer.getId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentalDay);
                    System.out.printf("Total Price: $%.2f\n", totalPrice);

                    System.out.println("\nConfirm rental (Y/N): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        RentCar(selectedCar, newCustomer, rentalDay);
                        System.out.println("Car Rented Successfully ");
                    } else {
                        System.out.println("Rental Canceled ");
                    }
                } else {
                    System.out.println("Invalid car selection or car not available for rent ");
                }
            } else if (choice == 2) {
                System.out.println("Return a Car ");
                System.out.println("Enter Car Id you want to return ");
                String carID = sc.nextLine();

                car carToReturn = null;
                for (car Car : Cars) {
                    if (Car.getId().equals(carID) && !Car.isAvailable()) {
                        carToReturn = Car;
                    }
                }
                if (carToReturn != null) {
                    customer Customer = null;
                    for (Rental rental : Rentals) {
                        if (rental.getCar() == carToReturn) {
                            Customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (Customer != null) {
                        renturnCar(carToReturn);
                        System.out.println("Car returned successfully by " + Customer.getName());
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid car ID or car is not rented ");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice ");
            }
        }
        System.out.println("Thank you for using Car Rental System ");
        sc.close();
    }

}

public class CarRental {
    public static void main(String[] args) {

        CarRentalSystem obj = new CarRentalSystem();

        car Car1 = new car("C001", "Toyota", "Tesla", 40.0);
        car Car2 = new car("C002", "Honda", "Supra", 60.0);
        car Car3 = new car("C003", "Mahindra", "Thar", 70.0);

        obj.addCar(Car1);
        obj.addCar(Car2);
        obj.addCar(Car3);
        obj.menu();
    }
}