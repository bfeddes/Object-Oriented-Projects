package starlightassignment;
import java.util.Scanner;
/*Brian Feddes
 * CPSC 24500 Fall 2022
 * Assignment 4 - Starlight Coffee
 */


public class posSystem {
    public static void main(String args[]){
        /*TO-DO LIST:
         * Start program with a header
         * Ask the user to enter their name --> import scanner 
         * Offer choices for the user to select
         * Calculate the user's total bill depending on the choices the user makes
         * Implement a tip percentage that will be added on to their bill
         * Apply the 10% discount
         */
    // Initalizing the Scanner class
    Scanner sc = new Scanner(System.in);

    // Assigning a storage variable to hold a user's total cost
    double userTotal = 0;

    // Program's header
    System.out.println("*************************************");
    System.out.println("STARLIGHT COFFEE POINT-OF-SALE SYSTEM");
    System.out.println("*************************************\n");

    // Asking the user for their name
    System.out.print("What is your name? ");
    String name = sc.next();
    System.out.println();

    // Asking the user what kind of coffee they want
    System.out.println("What kind of coffee do you want?");
    System.out.println("1. Americano");
    System.out.println("2. Italiano");
    System.out.println("3. Espresso");
    System.out.println("4. Cappuccino");
    System.out.print("Enter the number of your choice: ");

    //Checking which type of coffee the user ordered
    int coffeeType = sc.nextInt();
    if (coffeeType == 1){
        userTotal = userTotal + 2.25;
    } else if (coffeeType == 2){
        userTotal = userTotal + 2.75;
    } else if (coffeeType == 3){
        userTotal = userTotal + 3.50;
    } else if (coffeeType == 4){
        userTotal = userTotal + 3.75;
    } else {
      System.out.println("That item is not on the menu.");
    }
    System.out.println();
    
    // Asking the user what size they want
    System.out.println("What size do you want?");
    System.out.println("1. Tall");
    System.out.println("2. Grande");
    System.out.println("3. Venti");
    System.out.print("Enter the number of your choice: ");
    int coffeeSize = sc.nextInt();

    //Checking what size the user wanted
    if (coffeeSize == 1){
    
    } else if (coffeeSize == 2){
        userTotal = userTotal * 1.2;
    } else if (coffeeSize == 3){
        userTotal = userTotal * 1.4;
    } else {
        System.out.println("I am sorry, we do not serve that size");
    }
    System.out.println();
    // Asking the user how many shots they want.
    System.out.print("How many extra shots of espresso would you like? ");
    int extraShots = sc.nextInt();
    double shotPrice = extraShots * 0.50;
    userTotal = userTotal + shotPrice;
    System.out.println();

    //NEED TO COTINUE CODE FROM THIS POINT

    //Come back to here
System.out.printf("Your current total is $%.2f\n",userTotal);





    }
    
}
