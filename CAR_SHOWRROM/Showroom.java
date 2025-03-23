package Car_Showroom;

import java.util.Scanner;

public class Showroom implements utility {
    String showroom_name;
    String showroom_address;
    int total_employees;
    int total_no_of_stocks = 0;
    String manager_name;

    @Override
    public void get_details() {

        System.out.println();
        System.out.println("Showroom Name: " + showroom_name);
        System.out.println("Showroom Address: " + showroom_address);
        System.out.println("Manager Name: " + manager_name);
        System.out.println("Total Employees: " + total_employees);
        System.out.println("Total cars in Stocks: " + total_no_of_stocks);

    }

    @Override
    public void set_details() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Showroom Details ");
        System.out.println();
        System.out.print("ENTER SHOWROOM NAME: ");
        showroom_name = sc.nextLine();
        System.out.print("SHOWROOM ADDRESS ");
        showroom_address = sc.nextLine();
        System.out.print("ENTER MANAGER NAME: ");
        manager_name = sc.nextLine();
        System.out.print("ENTER TOTAL NO OF EMPLOYEES: ");
        total_employees = sc.nextInt();
        System.out.print("ENTER TOTAL NO OF CARS: ");
        total_no_of_stocks = sc.nextInt();

    }

}
