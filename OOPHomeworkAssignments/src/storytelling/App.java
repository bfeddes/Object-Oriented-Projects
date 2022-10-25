/* Brian Feddes
 * StoryTelling Programming Assignment
 * Object Oriented Programming
 * Professor Klump
 * Fall 2022
 */
package storytelling;
import java.util.Scanner;
import java.util.LinkedHashMap;
public class App {
    // Method for printing out the program's header
    public static void header(){
        System.out.println("****************************************************");
        System.out.println("\t\t  STORYTELLER V1.0");
        System.out.println("****************************************************");
        System.out.println("\nWelcome to StoryTeller, a sophisticated electronic\nauthor. This program reads from a list of words of\nvarious parts of speech and creates a story from\nthem. You can tune the richness of the writing by\nchanging how frequently adjectives, adverbs, and\nprepositions should be included.\n");
    }
    public static void main(String[] args){
        // Initializing Scanner object
        Scanner sc = new Scanner(System.in);
        String fileName;

        // Calling the header method
        header();
        // Initializing the functionality from WordFileReader class
        System.out.print("Enter name of file: ");
        fileName = sc.nextLine();
        WordFileReader.readFile(fileName);

    }
}
