package storytelling;
import java.util.Scanner;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.ArrayList;
public class WordFileReader {

    public static LinkedHashMap<String, ArrayList<String>> readFile(String fileName) {
        Scanner sc = new Scanner(System.in);
        // Variables
        String line, word, typeOfWord;
        String[] parts;
        ArrayList<String> nouns = new ArrayList<String>();
        ArrayList<String> verbs = new ArrayList<String>(); 
        ArrayList<String> adv = new ArrayList<String>(); 
        ArrayList<String> adj = new ArrayList<String>(); 
        ArrayList<String> prep = new ArrayList<String>(); 
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
                } else if (typeOfWord.equalsIgnoreCase("v")){
                    verbs.add(word);
                } else if (typeOfWord.equalsIgnoreCase("adj")){
                    adj.add(word);
                } else if (typeOfWord.equalsIgnoreCase("adv")){
                    adv.add(word);
                } else if (typeOfWord.equalsIgnoreCase("prep")){
                    prep.add(word);
                }
            }
            fsc.close();
        } catch (Exception ex){
            System.out.println("Invalid file name.");
        }
        // Adding the ArrayLists of nouns, verbs, adverbs, and adjectives to wordList map.
        wordList.put("n", nouns);
        wordList.put("v", verbs);
        wordList.put("adv", adv);
        wordList.put("adj", adj);
        wordList.put("prep", prep);
        return wordList;
    }
}