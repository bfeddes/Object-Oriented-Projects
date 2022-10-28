package storytelling;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
public class Author {
    // Add a LinkedHashMap to house the collection of words it can use from WordFileReader
    // Test functionality from the getters/setters and constructors 
    private LinkedHashMap<String, ArrayList<String>> wordList;
    private int adjFrequency;
    private int advFrequency;
    private int prepFrequency;
    private String word;
    private String sentence;
    private Random rnd = new Random();


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
        if (adjFrequency < 0) {
            adjFrequency = 0;
        } else {
        this.adjFrequency = adjFrequency;
        }
    }
    public int getAdvFrequency() {
        return advFrequency;
    }
    public void setAdvFrequency(int advFrequency) {
        if (advFrequency < 0){
            advFrequency = 0;
        } else{
        this.advFrequency = advFrequency;
        }
    }
    public int getPrepFrequency() {
        return prepFrequency;
    }
    public void setPrepFrequency(int prepFrequency) {
        if (prepFrequency < 0) {
            prepFrequency = 0;
        } else {
        this.prepFrequency = prepFrequency;
        }
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getSentence() {
        return sentence;
    }
    public void setSentence(String sentence) {
        this.sentence = wordList.get("n").get(rnd.nextInt(wordList.get("n").size()));
    }
    // Constructor for Author
    public Author(LinkedHashMap<String, ArrayList<String>> wordList) {
        setWordList(wordList);
        setSentence(sentence);
    }
    // Default Constructor
    public Author() {
        adjFrequency = 0;
        advFrequency = 0;
        prepFrequency = 0;
        word = "";
        wordList = new LinkedHashMap<String, ArrayList<String>>();
    }
    @Override
    public String toString() {
        return String.format("The %s", sentence);
    }
}
