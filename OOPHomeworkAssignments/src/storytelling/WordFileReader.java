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
        Scanner sc = new Scanner(System.in);
        String line, word, typeOfWord;
        String[] parts;
        ArrayList<String> nouns = new ArrayList<String>();; //Utilizing kinda as a pointer
        LinkedHashMap<String, ArrayList<String>> wordList= new LinkedHashMap<String, ArrayList<String>>();
        try{
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                parts = line.split(" "); // Will split each word. Word at index 0 will be the actual word. Index 1 will be the type of word.
                word = parts[0];
                typeOfWord = parts[1];
                if (typeOfWord.equalsIgnoreCase("n")){
                    nouns.add(word);
                }
            }
            wordList.put("Nouns", nouns);
            System.out.println(wordList);
            fsc.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return wordList;
    }
    public static void main(String[] args){
        String fileName;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        fileName = sc.nextLine();
        readFile(fileName);
    }


}