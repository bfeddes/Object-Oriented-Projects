package storytelling;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
public class Author {
    // Add a LinkedHashMap to house the collection of words it can use from WordFileReader
    // Test functionality from the getters/setters and constructors 
    private LinkedHashMap<String, ArrayList<String>> wordList;
    private int adjFrequency;
    private int advFequency;
    private int prepFrequency;
    // Constructor for Author
    public Author(LinkedHashMap<String, ArrayList<String>> wordList) {
        wordList = new LinkedHashMap<String, ArrayList<String>>();
    }
    // Default Constructor
    public Author() {
        adjFrequency = 0;
        advFequency = 0;
        prepFrequency = 0;
        wordList = new LinkedHashMap<String, ArrayList<String>>();
    }

    // Getters
    public LinkedHashMap<String, ArrayList<String>> getWordList() {
        return wordList;
    }
    public int getAdjFrequency() {
        return adjFrequency;
    }
    public int getAdvFequency() {
        return advFequency;
    }
    public int getPrepFrequency() {
        return prepFrequency;
    }
    // Setters
    public void setWordList(LinkedHashMap<String, ArrayList<String>> wordList) {
        this.wordList = wordList;
    }
    public void setAdjFrequency(int adjFrequency) {
        if (adjFrequency < 0){
            this.adjFrequency = 0;
        } else {
        this.adjFrequency = adjFrequency;
        }
    }
    public void setAdvFequency(int advFequency) {
        if (advFequency < 0){
            this.advFequency = 0;
        } else {
        this.advFequency = advFequency;
        }
    }
    public void setPrepFrequency(int prepFrequency) {
        if (prepFrequency < 0){
            this.prepFrequency = 0;
        } else {
        this.prepFrequency = prepFrequency;
        }
    }
    

    
}
