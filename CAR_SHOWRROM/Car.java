package Car_Showroom;

import java.util.*;

public class Car extends Showroom implements utility {

     String car_name;
     String car_color;
     String car_fuel_type;
     int car_price;
     String car_type;
     String car_transmission;

     @Override
     public void get_details() {
          System.out.println("NAME: " + car_name);
          System.out.println("COLOR: " + car_color);
          System.out.println("FUEL TYPE: " + car_fuel_type);
          System.out.println("PRICE: " + car_price);
          System.out.println("TYPE: " + car_type);
          System.out.println("TRANSMISSION: " + car_transmission);
     }

     @Override
     public void set_details() {
          Scanner sc = new Scanner(System.in);
          System.out.print("ENTER CAR DETAILS ");
          System.out.println();
          System.out.print("Enter car name: ");
          car_name = sc.nextLine();
          System.out.print("Enter car color: ");
          car_color = sc.nextLine();
          System.out.print("Enter car fuel type: ");
          car_fuel_type = sc.nextLine();
          System.out.print("Enter car price: ");
          car_price = sc.nextInt();
          sc.nextLine();
          System.out.print("Enter car type: ");
          car_type = sc.nextLine();
          System.out.print("Enter car transmission: ");
          car_transmission = sc.nextLine();
          total_no_of_stocks++;
     }
}
