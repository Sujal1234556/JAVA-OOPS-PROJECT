
import java.util.Scanner;

class ATMMACHINE {

    int pin = 2006;
    float balance;

    public void checkPIN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter PIN: ");
        int EnterPIN = sc.nextInt();

        if (EnterPIN == pin) {
            menu();
        } else {
            System.out.println("Enter valid PIN ");
            checkPIN();
        }

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter your Choice: ");
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposite Money ");
        System.out.println("3. Withdraw Money ");
        System.out.println("4. EXIT ");
        int choice = sc.nextInt();

        if (choice == 1) {
            checkBalance();
        } else if (choice == 2) {
            Deposite_Money();
        } else if (choice == 3) {
            Withdarw_Money();
        } else if (choice == 4) {
            return;
        } else {
            System.out.println("Enter valid choice ");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void Deposite_Money() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to Deposite: ");
        int amount = sc.nextInt();

        balance += amount;
        System.out.println("Money Deposited Successfully ");
        menu();
    }

    public void Withdarw_Money() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to Withdraw ");
        int amount = sc.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient Balance ");
        } else {
            balance -= amount;
            System.out.println("Money Withdraw Successfully ");
        }
        menu();
    }
}

public class atm {
    public static void main(String[] args) {

        ATMMACHINE obj = new ATMMACHINE();
        obj.checkPIN();
    }
}