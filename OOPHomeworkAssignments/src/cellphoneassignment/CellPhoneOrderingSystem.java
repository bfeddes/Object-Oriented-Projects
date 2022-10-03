/*Brian Feddes
 * CPSC 24500
 * Cell Phone Ordering System
 * Professor Klump
 * Fall 2022 Semester
 */
package cellphoneassignment;
import java.util.Scanner;
    public class CellPhoneOrderingSystem {
    // Method to print out the header
    public static void header(){
      System.out.println("****************************************************");
      System.out.println("        CORPORATE CELL PHONE ORDERING SYSTEM");
      System.out.println("****************************************************\n");
      System.out.println("Welcome to the corproate cell phone ordering system.");
      System.out.println("Here you can order multiple phones of different kinds");
      System.out.println("with various add-ons for your employees.\n");
      }
    // Method to print out the summary
    public static void summary(String specs, double cost){
      // Printing summary
      System.out.println("\nHere is a summary of your order:");
      System.out.println(specs);
      System.out.printf("Your total cost is $%.2f.\n",cost);
      System.out.println("\nThank you for your order.");
    }
    // main class
    public static void main(String[] args) {
      //Initiating scanner
      Scanner sc = new Scanner(System.in);
      // Calling header function to print out the header
      header();
      // Variables 
      String phoneType = "";
      int iphoneCost = 849;
      int androidCost = 799;
      double finalTotal = 0;
      String orderString = "";
      String screenDimensions = "";
      String addOnChoice;
    
      // Asking the user how many phones they want to purchase
      System.out.print("How many phones will you purchase? ");
      int numOfPhones = sc.nextInt();

      // Loop for configuring phones
      for (int i = 1; i <=numOfPhones;i++){

      // Variables stored within the for loop so that every phone has specific specs/costs
      double phoneCost = 0;
      String allAddOns = "";
      String addOns = "";

      // Configuration number
      System.out.printf("\nLet's configure phone #%d ...\n",i);

      // Asking user for what brand of phone
      System.out.print("Enter A for Android or I for IPhone: ");
      phoneType = sc.next();
      if (phoneType.equalsIgnoreCase("I")){
      phoneCost = phoneCost + iphoneCost;
      phoneType = "IPhone ";
      } else if (phoneType.equalsIgnoreCase("A")){
      phoneCost = phoneCost + androidCost;
      phoneType = "Android ";
      }

      // Asking user for screen size
      System.out.print("What screen size? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
      int screenSize = sc.nextInt();
      if (screenSize == 1){
      screenDimensions = "5.6\"";
      } else if (screenSize == 2){
      screenDimensions = "6.2\"";
      phoneCost = phoneCost * 1.2;
      } else if (screenSize == 3){
      screenDimensions = "6.7\"";
      phoneCost = phoneCost * 1.4;
      }

      // Asking user for storage
      System.out.print("How much storage? Enter 64, 128, or 256: ");
      int storageAmount = sc.nextInt();

      if (storageAmount == 64){
      } else if (storageAmount == 128){
      phoneCost = phoneCost + 100;
      } else if (storageAmount == 256){
      phoneCost = phoneCost + 250;
      } else {System.out.println("You did not enter a valid amount of storage.");}

      // Asking user for add ons
      do {
      allAddOns = allAddOns + addOns;
      System.out.println("What add-on do you want?");
      System.out.println("  [C]ase ($49)");
      System.out.println("  [S]creen protector ($15)");
      System.out.println("  [E]ar buds ($99)");
      System.out.println("  [W]ireless charger ($59)");
      System.out.println("  [F]inish order");
      System.out.print("Enter the letter of your choice: ");
      addOnChoice = sc.next();
      if (addOnChoice.equalsIgnoreCase("C")){
        phoneCost = phoneCost + 49;
        addOns = " / case ";
        } else if (addOnChoice.equalsIgnoreCase("S")){
          phoneCost = phoneCost + 15;
          addOns = " / screen protector";
        } else if (addOnChoice.equalsIgnoreCase("E")){
          phoneCost = phoneCost + 99;
          addOns = " / ear buds";
        } else if (addOnChoice.equalsIgnoreCase("W")){
          phoneCost = phoneCost + 59;
          addOns = " / wireless charger";
        }
        } while(!addOnChoice.equalsIgnoreCase("F"));

      // Storing the results
      orderString = orderString + String.format("%s %s %dGB%s ($%.2f) \n",phoneType, screenDimensions, storageAmount, allAddOns, phoneCost);
      finalTotal = finalTotal + phoneCost;
      }

      // Calling the summary method to print the full order
      summary(orderString, finalTotal);
    }
  }
