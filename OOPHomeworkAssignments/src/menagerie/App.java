/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, App Class
 */
package menagerie;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class App {
    public static void header(){
        System.out.println("************************************************************");
        System.out.println("\t      Menagerie V1.0: The Pet Simulator");
        System.out.println("************************************************************\n");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Variables
        int userChoice;
        // Calling the header method
        header();
        // Asking the user what they'd like to do while number choice is not 7. (Skeleton code right now)
        do{
            System.out.println("What would you like to do?");
            System.out.println("1. Add a new pet."); // Will then ask the user to choose a pet type, and then name, age, and weight
            System.out.println("2. Print list of pets.");
            System.out.println("3. Save pets to a file.");
            System.out.println("4. Load pets from a file.");
            System.out.println("5. Simulate a day in the life of your pets.");
            System.out.println("6. Clear your list of pets.");
            System.out.println("7. Exit");
            System.out.print("Ente the number of your choice: ");
            userChoice = sc.nextInt();
            if (userChoice < 1 || userChoice > 7){
                System.out.println("Invalid selection.");
            }
        } while (userChoice != 7);

        // Goodbye message
        System.out.println("\nThank you for using Menagerie. We hope you had fun.");
    }
    
}
