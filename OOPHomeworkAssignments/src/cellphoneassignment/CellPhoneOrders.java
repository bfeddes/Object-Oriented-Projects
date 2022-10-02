/*Brian Feddes
 * CPSC 24500
 * Cell Phone Ordering System
 * Professor Klump
 * Fall 2022 Semester
 */
package cellphoneassignment;
import java.util.Scanner;
public class CellPhoneOrders {
    // ****Method to print out the header****
    public static void header(){
        System.out.println("****************************************************");
        System.out.println("        CORPORATE CELL PHONE ORDERING SYSTEM");
        System.out.println("****************************************************\n");
        System.out.println("Welcome to the coorproate cell phone ordering system.");
        System.out.println("Here you can order multiple phones of different kinds");
        System.out.println("with various add-ons for your employees.\n");
        }
    // ****Method Asking the user what type of phone they want****
    public static String phoneBrand(String phoneType){
    Scanner sc = new Scanner(System.in);
    int phoneCost = 0;
    // Options for an iPhone
    if (phoneType.equalsIgnoreCase("I")){
    phoneCost = phoneCost + 849;
    phoneType = "IPhone";
    } else if (phoneType.equalsIgnoreCase("A")){
    phoneCost = phoneCost + 799;
    phoneType = "Android";
    }
    System.out.println(phoneType);
    System.out.println(phoneCost);
    return phoneType;
}
    // ****Method to check what size screen the user wants****
    public static int sizeScreen(int userNum){
        int screenSizePrice = 0;
        if (userNum == 1){

        }
        return userNum;
    }



    // ****Main class to organize the methods in.****
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Printing the header
        header();
        // Asking the user how many phones they want to purchase
        System.out.print("How many phones will you purchase? ");
        int numOfPhones = sc.nextInt();
        System.out.println();
        // Iterations for each phone
        for (int i=1;i<=numOfPhones;i++){
        System.out.printf("Lets configure phone #%d\n",i);
        // Asking user for what brand of 
        System.out.print("Enter A for Android or I for iPhone: ");
        String phoneType = sc.next();
        phoneBrand(phoneType);
         }
         System.out.print("What screen size? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
         int screenSize = sc.nextInt();
    }  
}