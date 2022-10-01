/*Brian Feddes
 * CPSC 24500
 * Cell Phone Ordering System
 * Professor Klump
 * Fall 2022 Semester
 */

package cellphoneassignment;
import java.util.Scanner;
public class CellPhoneOrderingSystem {
    /*****TO DO LIST*****
     * Create method for asking what amount of storage (64 GB 128 GB 256 GB)
     * 
     */
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
        // Asking the user how many phones they want to purchase
        System.out.print("How many phones will you purchase? ");
        int numOfPhones = sc.nextInt();
        System.out.println();
        // Initializing and declaring variables outside of loops
        String phoneType;
        int iphoneCost = 849;
        int androidCost = 799;
        int totalCost = 0;
        // Asking the user what type of phone they want
        for (int i = 1; i <=numOfPhones; i++){
            System.out.printf("Lets configure phone #%d\n",i);
            System.out.print("Enter A for Android or I for iPhone: ");
            phoneType = sc.next();
            // Options for an iPhone
            if (phoneType.equalsIgnoreCase("I")){
            totalCost += iphoneCost;
            System.out.print("What screen size? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
            int screenSize = sc.nextInt();
            if (screenSize == 1){
            } else if (screenSize == 2){
                totalCost *= 1.2;
            } else if (screenSize == 3){
                totalCost *= 1.4;
            }
            System.out.print("How much storage? Enter 64, 128, 256: ");
            int storage = sc.nextInt();
            if (storage == 64){
            } else if (storage == 128){
                totalCost += 100;
            } else if (storage == 256){
                totalCost += 250;
            }
            System.out.println("What add-ons do you want?");
            System.out.println("[C]ase ($49)\n[S]creen protector ($15)\n[E]ar buds ($99)\n[W]ireless charger ($59)\n[F]inish order");
            


            } // End of iPhone loop
            else if (phoneType.equalsIgnoreCase("A")){
                totalCost += androidCost;
                System.out.print("What screen size? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
                int screenSize = sc.nextInt();
                if (screenSize == 1){
                } else if (screenSize == 2){
                    totalCost *= 1.2;
                } else if (screenSize == 3){
                    totalCost *= 1.4;
                }
                System.out.print("How much storage? Enter 64, 128, 256: ");
                int storage = sc.nextInt();
                if (storage == 64){
                } else if (storage == 128){
                    totalCost += 100;
                } else if (storage == 256){
                    totalCost += 250;
                }
            } // End of Android loop
         }
         System.out.println(totalCost);
    }  
}
