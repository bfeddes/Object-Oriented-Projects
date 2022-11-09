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
        System.out.println("************************************************************");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Variables
        int userChoice;
        String petChoice;
        ArrayList<Pet> pets = new ArrayList<Pet>();
        // Calling the header method
        header();
        
        // Asking the user what they'd like to do while number choice is not 7. (Skeleton code right now)
        do{
            System.out.println("\nWhat would you like to do?");
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
            // This option allows a user to add a pet to the ArrayList "pets"
            if (userChoice == 1){
                System.out.print("Enter d for dog, c for cat, or f for fish: ");
                petChoice = sc.next();
                System.out.print("Enter name, age, and weight: ");
                String petName = sc.next();
                int petAge = sc.nextInt();
                double petWeight = sc.nextDouble();
                if (petChoice.equalsIgnoreCase("d")){
                    pets.add(new Dog(petName, petAge, petWeight));
                }
                Collections.sort(pets);
            }
            // This option will print out the list of pets in alphabetical order by name
            if (userChoice == 2) {
                for (Pet pet : pets) {
                    System.out.println(pet);
                }
                if (pets.isEmpty()){
                    System.out.println("\nThe list of pets is empty.");
                }
            }
            if (userChoice == 5) {
                for (Pet pet : pets) {
                    System.out.println(pet.act());
                }
            }
            // This choice will clear the ArrayList of pets
            if (userChoice == 6){
                pets.clear();
            }
        } while (userChoice != 7);

        // Goodbye message
        System.out.println("\nThank you for using Menagerie. We hope you had fun.");
    }
    
}
