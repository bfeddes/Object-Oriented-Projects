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
        String petChoice, fileName;
        ArrayList<Pet> pets = new ArrayList<Pet>();
        // Calling the header method
        header();
        
        // Asking the user what they'd like to do while number choice is not 7. (Skeleton code right now)
        do{
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a new pet.");
            System.out.println("2. Print list of pets.");
            System.out.println("3. Save pets to a file.");
            System.out.println("4. Load pets from a file.");
            System.out.println("5. Simulate a day in the life of your pets.");
            System.out.println("6. Clear your list of pets.");
            System.out.println("7. Exit");
            System.out.print("Enter the number of your choice: ");
            userChoice = sc.nextInt();
            if (userChoice < 1 || userChoice > 7){
                System.out.println("Invalid selection.");
            }
            // This option allows a user to add a pet to the ArrayList "pets"
            if (userChoice == 1){
                System.out.print("Enter d for dog, c for cat, or f for fish: ");
                petChoice = sc.next();
                if (!petChoice.equalsIgnoreCase("d") && !petChoice.equalsIgnoreCase("c") && !petChoice.equalsIgnoreCase("f")){
                    System.out.println("Invalid pet type.");
                } else {
                System.out.print("Enter name, age, and weight: ");
                String petName = sc.next();
                int petAge = sc.nextInt();
                double petWeight = sc.nextDouble();
                if (petChoice.equalsIgnoreCase("d")) {
                    pets.add(new Dog(petName, petAge, petWeight));
                } else if (petChoice.equalsIgnoreCase("c")) {
                    pets.add(new Cat(petName, petAge, petWeight));
                } else if (petChoice.equalsIgnoreCase("f")) {
                    pets.add(new Fish(petName, petAge, petWeight));
                }
                Collections.sort(pets);
                }
            }
            // This option will print out the list of pets in alphabetical order by name
            if (userChoice == 2) {
                System.out.println("\nHere is your list of pets:");
                for (Pet pet : pets) {
                    System.out.println(pet);
                }
            }
            // This option will allow the user to save their list of pets to a file.
            if (userChoice == 3) {
                System.out.print("Enter name of file to save: ");
                sc.nextLine();
                fileName = sc.nextLine();
                if (PetWriter.writeToFile(pets, fileName)) {
                    System.out.println("The pets were saved to the file.");
                } else {
                    System.out.println("The pets were unable to be saved to the file.");
                }
            }
            // This option will allow users to load a list of pets from a file.
            if (userChoice == 4) {
                try{
                System.out.print("\nEnter name of file to load: ");
                sc.nextLine();
                fileName = sc.nextLine();
                pets = PetReader.readPetsFromText(fileName);
                System.out.println("The pets were read from the file.");
                } catch (Exception ex) {
                    System.out.println("The pets were unable to be read from the file.");
                }
            }
            // This option will simulate a day in the life of all pets in the ArrayList of pets.
            if (userChoice == 5) {
                if (pets.isEmpty()){
                    System.out.println("There are no pets in your list.");
                } else{
                    System.out.println("\nHere is a simulation of a day in the life of your pets:");
                    for (int i = 1; i <= 24; i++) {
                        System.out.printf("\nHOUR  %d\n-------\n", i);
                        for (Pet pet : pets) {
                            System.out.print(pet.act());
                        }
                    }
                }
            }
            // This option will clear the ArrayList of pets
            if (userChoice == 6){
                pets.clear();
            }
        } while (userChoice != 7);

        // Goodbye message
        System.out.println("\nThank you for using Menagerie. We hope you had fun.");
    }
}
