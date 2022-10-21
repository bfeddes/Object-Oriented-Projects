package storytelling;
import java.io.File;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.ArrayList;
/* COME BACK TO THIS. CURRENTLY ABLE TO PRINT OUT ALL THE TYPES OF WORDS AT INDEX 1. WORDS ARE AT INDEX 0.
 * Need to adjust it accordingly. The split and trim function works as I hoped.
 * Need to save certain words to certain ArrayLists. Example: Nouns, Verbs, Adverbs, etc.
 * Once I get the actual function functioning, remove main method from this.
*/
public class WordFileReader {

    public static LinkedHashMap<String, ArrayList<String>> readFile(String fileName) {
        String line, word, typeOfWord;
        String[] parts;
        ArrayList<String> wordTypes; //Utilizing kinda as a pointer
        ArrayList<String> nouns = new ArrayList<String>();
        LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<String, ArrayList<String>>();
        try{
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                parts = line.split(" "); // Will split each word. Word at index 0 will be the actual word. Index 1 will be the type of word.
                word = parts[0]; // Gets the word
                typeOfWord = parts[1]; //Gets what type of word it is: noun, verb, adverb
                wordTypes = new ArrayList<String>();
                System.out.println(word); // This prints the typeOfWord it is.
            }
            fsc.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return words;
    }
    public static void main(String[] args){
        String fileName;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        fileName = sc.nextLine();
        readFile(fileName);
    }


}