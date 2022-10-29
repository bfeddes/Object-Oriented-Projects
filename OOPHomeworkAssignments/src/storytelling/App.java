/* Brian Feddes
 * StoryTelling Programming Assignment
 * Object Oriented Programming
 * Professor Klump
 * Fall 2022
 */
package storytelling;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.ArrayList;
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
        // Variables
        int adjFrequency, advFrequency, prepFrequency, numOfSentences;
        String fileName, decision;

        // Calling the header method
        header();

        System.out.print("Enter the name of the word file: ");
        fileName = sc.nextLine();
        WordFileReader.readFile(fileName);
        // This grabs the wordList from the WordFileReader method.
        LinkedHashMap<String, ArrayList<String>> wordList = WordFileReader.readFile(fileName);
        Author story = new Author(wordList);
        do {
            System.out.print("\nHow many sentences would you like in your story? ");
            numOfSentences = sc.nextInt();
            System.out.println("Here it is:");
            story.tellStory(numOfSentences);
            System.out.print("\nWould you like another story (y or n)? ");
            decision = sc.next();
        } while (decision.equalsIgnoreCase("y"));
        System.out.println("\nThank you for using StoryTeller!");
    }
}
