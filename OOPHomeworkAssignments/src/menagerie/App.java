/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, App Class
 */
package menagerie;
public class App {
    public static void header(){
        System.out.println("************************************************************");
        System.out.println("\t      Menagerie V1.0: The Pet Simulator");
        System.out.println("************************************************************\n");
    }
    public static void main(String[] args){
        // Calling the header method
        header();
        System.out.println("What would you like to do?");
        String name = "Brian";
        int age = 20;
        double weight = 180.1;
        Pet testPet = new Pet(name, age, weight);
        System.out.println(testPet);
        // Goodbye message
        System.out.println("\nThank you for using Menagerie. We hope you had fun.");
    }
    
}
