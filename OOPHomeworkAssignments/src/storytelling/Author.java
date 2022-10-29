package storytelling;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Author {
    private LinkedHashMap<String, ArrayList<String>> wordList;
    private int adjFrequency;
    private int advFrequency;
    private int prepFrequency;
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
    public String getWord(String word){
        String wordType = wordList.get(word).get(rnd.nextInt(wordList.get(word).size()));
        return wordType;
    }
    public String getSentence() {
        String sentence = String.format("The %s %s %s %s %s the %s.", getWord("adj"), getWord("n"), getWord("v"),
        getWord("adv"), getWord("prep"), getWord("n"));
        return sentence;
    }
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
