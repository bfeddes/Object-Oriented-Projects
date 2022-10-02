/*Brian Feddes
 * CPSC 24500
 * Cell Phone Ordering System
 * Professor Klump
 * Fall 2022 Semester
 */
package cellphoneassignment;
import java.util.Scanner;
public class CellPhoneAgain {
    // ****Method to print out the header****
    public static void header(){
        System.out.println("****************************************************");
        System.out.println("        CORPORATE CELL PHONE ORDERING SYSTEM");
        System.out.println("****************************************************\n");
        System.out.println("Welcome to the coorproate cell phone ordering system.");
        System.out.println("Here you can order multiple phones of different kinds");
        System.out.println("with various add-ons for your employees.\n");
        }
    // ****Main class to organize the methods in.****
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        header();

        // Variables 
        String phoneSpecs;
        String phoneType = "";
        int iphoneCost = 849;
        int androidCost = 799;
        double finalTotal = 0;
        String totalOrder = "";
        String screenDimensions = "";

        // Asking the user how many phones they want to purchase
        System.out.print("How many phones will you purchase? ");
        int numOfPhones = sc.nextInt();
        System.out.println();
        for (int i = 0; i <numOfPhones;i++){
        // Each phone cost.
        double phoneCost = 0;
        // Asking user for what brand of phone
        System.out.print("Enter A for Android or I for iPhone: ");
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
        phoneCost = phoneCost * 1.2;
        }
        System.out.print("How much storage? Enter 64, 128, or 256: ");
        int storageAmount = sc.nextInt();
        if (storageAmount == 64){
        } else if (storageAmount == 128){
          phoneCost = phoneCost * 1.2;
        } else if (storageAmount == 256){
          phoneCost = phoneCost * 1.4;
        }
        totalOrder = totalOrder + String.format("%s %s %dGB / ($%.2f) \n",phoneType, screenDimensions, storageAmount, phoneCost);
        finalTotal = finalTotal + phoneCost;
      }

      // Printing summary
      System.out.println("\nHere is a summary of your order:");
      System.out.println(totalOrder);
      System.out.printf("Your total cost is $%.2f.\n",finalTotal);
      System.out.println("\nThank you for your order.");
    }
  }
