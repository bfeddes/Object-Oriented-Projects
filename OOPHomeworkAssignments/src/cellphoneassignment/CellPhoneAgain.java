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
    // **test method***
    public static int phoneSetup(int numOfPhones){
        // Variables
        Scanner sc = new Scanner(System.in);
         String phoneType = "";
        int iphoneCost = 849;
        int androidCost = 799;
        int iterationNum = 1;
        double totalCost=0;
        // Iterations for each overall phone
        while (iterationNum <=numOfPhones){
        iterationNum += 1;
        System.out.printf("Lets configure phone #%d\n",(iterationNum-1));
                      // Asking user for what brand of phone
                      System.out.print("Enter A for Android or I for iPhone: ");
                      phoneType = sc.next();
                      if (phoneType.equalsIgnoreCase("I")){
                          totalCost = totalCost + iphoneCost;
                          phoneType = "IPhone";
                          } else if (phoneType.equalsIgnoreCase("A")){
                          totalCost = totalCost + androidCost;
                          phoneType = "Android";
                          }
                      // Asking user for screen size
                      System.out.print("What screen size? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
                      int screenSize = sc.nextInt();
                      if (screenSize == 1){
                      } else if (screenSize == 2){
                          totalCost = totalCost * 1.2;
                      } else if (screenSize == 3){
                          totalCost = totalCost * 1.2;
                      }
                      System.out.println(totalCost);
                   } 
        return numOfPhones;
    }
    // ****Main class to organize the methods in.****
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        header();
        // Asking the user how many phones they want to purchase
        System.out.print("How many phones will you purchase? ");
        int numOfPhones = sc.nextInt();
        System.out.println();
        phoneSetup(numOfPhones);
    }
}
