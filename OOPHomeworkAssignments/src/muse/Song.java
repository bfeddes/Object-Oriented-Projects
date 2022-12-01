package muse;
import java.util.LinkedHashMap;
public class Song extends RecordedArtisticWork {
    // Variables
    private int bpm;  // beats per minute
    private String key;
    // Getters and setters
    public int getBPM() {
        return bpm;
    }
    public void setBPM(int bpm) {
        if (bpm < 0) {
            this.bpm = 0;
        } else {
            this.bpm = bpm;
        }
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;   // could add checking for valid key
    }
    // Default setter
    public Song() {
        key = "Cmaj";
        bpm = 120;
    }
    // Non-default constructor
    public Song(String creator, String date, String title, String description,int duration, String fileName, double fileSize, int bpm, String key) {
        super(creator,date,title,description,duration,fileName,fileSize);
        setBPM(bpm);
        setKey(key);
    }
    // Non-default constructor
    public Song(LinkedHashMap<String,String> settings) {
        super(settings);
        setBPM(Integer.parseInt(settings.get("bpm")));
        setKey(settings.get("key"));
    }
    // Overriding the getType method from the super class
    @Override
    public String getType() {
        return "song";
    }
    // Overriding the specific info from the super class
    @Override
    public String getSpecificInfoString() {
        return String.format("%d bpm, key of %s", bpm,key);
    }
    @Override
    public String toTabDelimitedString() {
        return String.format("%s\t%d\t%s", super.toTabDelimitedString(),bpm, key);
    }
}