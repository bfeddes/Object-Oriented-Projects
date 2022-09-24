package starlightassignment;
import java.util.Scanner;
/*Brian Feddes
 * CPSC 24500 Fall 2022
 * Assignment 4 - Starlight Coffee
 */


public class posSystem {
    // printHeading function
    public static String printHeading(){
        return "*************************************\nSTARLIGHT COFFEE POINT-OF-SALE SYSTEM\n*************************************\n";
    }

    // printBill function
    public static double printBill(double bev, double bevSize, int shots, String discount, int tipAmount, String name){
        // Checking type of drink
        if (bev == 1){
            bev = 2.25;
        } else if (bev == 2){
            bev = 2.75;
        } else if (bev == 3){
            bev = 3.50;
        } else if (bev == 4){
            bev = 3.75;
        }
        // Checking size of drink
        if (bevSize == 2){
        bev = bev * 1.2;
        } else if (bevSize == 3){
        bev = bev * 1.4;
        } else {
            bev = bev;
        }

        // Checking number of shots
        bev = bev + (shots * 0.5);

        // Checking Tip Amount
                double tipPrice = 0;
        if (tipAmount == 1){
                    tipPrice = 0.1 * bev;
        } else if (tipAmount == 2){
                    tipPrice = 0.15 * bev;
        } else if (tipAmount == 3){
                    tipPrice = 0.20 * bev;
        }

        // Checking discount
        double discountPrice = 0;
        if (discount.equalsIgnoreCase("y")){
            discountPrice = bev * 0.1;
        } else {
            discountPrice = bev * 0;
        }
        // Calculating taxes
        double taxes = (bev - discountPrice) * 0.0875;

        // Calculating the total
        double total = ((bev-discountPrice) + tipPrice + taxes);

        // Printing all the information
        System.out.println();
        System.out.printf("Here is your bill, %s:\n",name);
        System.out.printf("Beverage       $  %.2f\n", bev);
        System.out.printf("Club Discount  $  %.2f\n",discountPrice);
        System.out.printf("Tip Amount     $  %.2f\n",tipPrice);
        System.out.printf("Taxes          $  %.2f\n",taxes);
        System.out.printf("Total          $  %.2f\n", total);
        System.out.println();
        return bev;
    }
    public static void main(String args[]){
    // Initalizing the Scanner class
    Scanner sc = new Scanner(System.in);
    
    // header printing the printHeading function
    System.out.println(printHeading());

    // Asking the user their name
    System.out.print("What is your name? " );
    String name = sc.nextLine();

    // Asking the user what kind of coffee they want
    System.out.println();
    System.out.println("What kind of coffee do you want?\n1. Americano\n2. Italiano\n3. Espresso\n4. Cappuccino");
    System.out.print("Enter the number of your choice: ");
    int coffeeType = sc.nextInt();
    System.out.println();

    // Asking the user what size they want
    System.out.println("What size do you want?\n1. Tall\n2. Grande\n3. Venti");
    System.out.print("Enter the number of your choice: ");
    int coffeeSize = sc.nextInt();

    // Asking the user how many shots they want.
    System.out.println();
    System.out.print("How many extra shots of espresso would you like? ");
    int extraShots = sc.nextInt();
    System.out.println();

    // Asking the user if they are a member of Starlight Stats
    System.out.print("Are you a member of Starlight Stars (y or n)? ");
    String starlightMember = sc.next();

    // Asking the user what size tip they would like to leave
    System.out.println();
    System.out.println("What size tip would you like to leave?\n1. Good service - 10%\n2. Great service - 15%\n3. Outstanding service - 20%");
    System.out.print("Enter the number of your choice: ");
    int tipSize = sc.nextInt();

    // Printing out the user's bill.
    printBill(coffeeType,coffeeSize, extraShots, starlightMember, tipSize, name);
    System.out.println("Thank you for choosing Starlight Coffee!");
    }
    
}
