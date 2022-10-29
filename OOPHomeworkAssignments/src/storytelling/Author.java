/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * StoryTelling Assignment, Author Class
 */
package storytelling;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Author {
    // Variables for this class
    private LinkedHashMap<String, ArrayList<String>> wordList;
    private int adjFrequency;
    private int advFrequency;
    private int prepFrequency;
    private Random rnd = new Random();
    // Getters and setters
    public LinkedHashMap<String, ArrayList<String>> getWordList() {
        return wordList;
    }
    public void setWordList(LinkedHashMap<String, ArrayList<String>> wordList) {
        this.wordList = wordList;
    }

    public int getAdjFrequency() {
        return adjFrequency;
    }
    public void setAdjFrequency(int adjFrequency) {
        if (adjFrequency < 0 || adjFrequency > 10) {
            adjFrequency = 0;
        } else {
        this.adjFrequency = adjFrequency;
        }
    }
    public int getAdvFrequency() {
        return advFrequency;
    }
    public void setAdvFrequency(int advFrequency) {
        if (advFrequency < 0 || advFrequency > 10){
            advFrequency = 0;
        } else{
        this.advFrequency = advFrequency;
        }
    }
    public int getPrepFrequency() {
        return prepFrequency;
    }
    public void setPrepFrequency(int prepFrequency) {
        if (prepFrequency < 0 || prepFrequency > 10) {
            prepFrequency = 0;
        } else {
        this.prepFrequency = prepFrequency;
        }
    }
    // Gets either a noun, adjective, adverb, verb, or preposition at random.
    public String getWord(String word){
        String wordType = wordList.get(word).get(rnd.nextInt(wordList.get(word).size()));
        return wordType;
    }
    // Creates a sentence using the getWord function
    public String getSentence() {
        String sentence = "The";
        int bound = rnd.nextInt(10);
        if (adjFrequency > bound){
        sentence = sentence.concat(" " + getWord("adj"));
        }
        // Part of the sentence that will always be there
        sentence = sentence.concat(" " + getWord("n") + " " + getWord("v"));
        if (advFrequency > bound) {
            sentence = sentence.concat(" " + getWord("adv"));
        }
        if (prepFrequency > bound) {
            sentence = sentence.concat(" " + getWord("prep") + " the " + getWord("n"));
        }
        sentence = sentence.concat(".");
        return sentence;
    }
    // Creates a story by creating n number of sentences, depending on the value the user chooses.
    public void tellStory(int numOfSentences){
        for (int i = 0 ; i < numOfSentences; i++){
            System.out.println(getSentence());
        }
    }
    // Constructor for Author
    public Author(LinkedHashMap<String, ArrayList<String>> wordList) {
        setWordList(wordList);
    }
    // Default Constructor
    public Author() {
        adjFrequency = 0;
        advFrequency = 0;
        prepFrequency = 0;
        wordList = new LinkedHashMap<String, ArrayList<String>>();
    }
}
