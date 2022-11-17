package muse;

import java.util.LinkedHashMap;
public class Poem extends WrittenArtisticWork {
    // Variable
    private String meter;
    //Getters and setters
    public String getMeter() {
        return meter;
    }
    public void setMeter(String meter) {
        this.meter = meter;
    }
    // Default constructor
    public Poem() {
        meter = "N/A";
    }
    // Non-default constructor
    public Poem(String creator, String date, String title, String description,
            String language, String text, String meter) {
        super(creator,date,title,description,language,text);
        setMeter(meter);
    }
    // Non-default constructor
    public Poem(LinkedHashMap<String,String> settings) {
        super(settings);
        setMeter(settings.get("meter"));
    }
    // Overriding the getType method
    @Override
    public String getType() {
        return "poem";
    }
    // Overriding the specific info for poems
    @Override
    public String getSpecificInfoString() {
        return String.format("Meter: %s\n%s", meter, super.getSpecificInfoString());
    }
}