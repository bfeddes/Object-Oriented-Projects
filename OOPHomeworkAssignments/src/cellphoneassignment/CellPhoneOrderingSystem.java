/*Brian Feddes
 * CPSC 24500
 * Cell Phone Ordering System
 * Professor Klump
 * Fall 2022 Semester
 */
package cellphoneassignment;
import java.util.Scanner;
public class CellPhoneOrderingSystem {
    // ***Type of phone method***
    public static double phoneCalculator(int numOfPhones){
        // Initializing scanner class
        Scanner sc = new Scanner(System.in);
        // Initializing and declaring variables outside of loops
        String phoneType, storageName;
        String addOn = "";
        String screenSizeString = "";
        int iphoneCost = 849;            
        int androidCost = 799;
        double totalCost = 0;
        // Asking the user how many phones they want to purchase
        // Asking the user what type of phone they want
        System.out.print("Enter A for Android or I for iPhone: ");
        phoneType = sc.next();
        // Options for an iPhone
        if (phoneType.equalsIgnoreCase("I")){
        totalCost += iphoneCost;
        phoneType = "IPhone";
        } else if (phoneType.equalsIgnoreCase("A")){
        totalCost += androidCost;
        phoneType = "Android";
        }
        // Asking the user what add-ons they want
        System.out.println("What add-on do you want?");
        System.out.print("   [C]ase ($49)\n   [S]creen protector ($15)\n   [E]ar buds ($99)\n   [W]ireless charger ($59)\n   [F]inish order\nEnter the letter of your choice: ");
        String addOnChoice = sc.next();
        if(addOnChoice.equalsIgnoreCase("C")){
            totalCost += 49;
            addOn = "case";
        }else if(addOnChoice.equalsIgnoreCase("S")){
            totalCost += 15;
            addOn = "Screen Protector";
        }else if(addOnChoice.equalsIgnoreCase("E")){
            totalCost += 99;
            addOn = "Ear buds";
        }else if(addOnChoice.equalsIgnoreCase("W")){
            totalCost += 59;
            addOn = "Wireless Charger";
        }
        // While loop for add-ons while the user doesn't select finish
        while (!addOnChoice.equalsIgnoreCase("F")){
        System.out.println("What add-on do you want?");
        System.out.print("   [C]ase ($49)\n   [S]creen protector ($15)\n   [E]ar buds ($99)\n   [W]ireless charger ($59)\n   [F]inish order\nEnter the letter of your choice: ");
        addOnChoice = sc.next();
        if(addOnChoice.equalsIgnoreCase("C")){
        totalCost += 49;
        }else if(addOnChoice.equalsIgnoreCase("S")){
            totalCost += 15;
        }else if(addOnChoice.equalsIgnoreCase("E")){
            totalCost += 99;
        }else if(addOnChoice.equalsIgnoreCase("W")){
            totalCost += 59;
        }
        }
        return numOfPhones;
}
public static int screenSizes(){
    // Asking the screen size
    Scanner sc = new Scanner(System.in);
    String screenSizeString = "";
    System.out.print("What screen size? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
    int screenSize = sc.nextInt();
    return screenSize;
}
public static int storageAmount(){
    // Asking the storage
    Scanner sc = new Scanner(System.in);
    System.out.print("How much storage? Enter 64, 128, 256: ");
    int storage = sc.nextInt();
    return storage;
}
    // Method to print out the header
    public static void header(){
        System.out.println("****************************************************");
        System.out.println("        CORPORATE CELL PHONE ORDERING SYSTEM");
        System.out.println("****************************************************\n");
        System.out.println("Welcome to the coorproate cell phone ordering system.");
        System.out.println("Here you can order multiple phones of different kinds");
        System.out.println("with various add-ons for your employees.\n");
    }
    public static void main(String[] args) {
    // Main class to organize the methods in.
        Scanner sc = new Scanner(System.in);
        // Printing the header
        header();
        System.out.print("How many phones will you purchase? ");
        int numOfPhones = sc.nextInt();
        System.out.println();
        for (int i=1;i<=numOfPhones;i++){
        System.out.printf("Lets configure phone #%d\n",i);
        phoneCalculator(numOfPhones);
        }
         System.out.println("\nHere is a summary of your order:");
    }  
}
