package muse;

import java.util.LinkedHashMap;
public abstract class WrittenArtisticWork extends ArtisticWork {
    // Variables
    private String language;
    private String text;  // the actual content
    // Getters and setters
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String lang) {
        language = lang;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    // Default constructor
    public WrittenArtisticWork() {
        language = "English";
        text = "This is the text of the written work.";
    }
    // Non-default constructor
    public WrittenArtisticWork(String creator, String date, String title, String description, String language, String text) {
        super(creator,date,title,description);
        setLanguage(language);
        setText(text);
    }
    // Non-default constructor
    public WrittenArtisticWork(LinkedHashMap<String,String> settings) {
        super(settings);
        setLanguage(settings.get("language"));
        setText(settings.get("text"));
    }
    // Overriding general info string from the super class
    @Override
    public String getGeneralInfoString() {
        return String.format("%s\nLanguage: %s",super.getGeneralInfoString(),language);
    }
    // Overriding the general info string from the super class
    @Override
    public String getSpecificInfoString() {
        return text;
    }
    @Override
    public String toTabDelimitedString() {
        return String.format("%s\t%s\t%s", super.toTabDelimitedString(), language, text);
    }
}