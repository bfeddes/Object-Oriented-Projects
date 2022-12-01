package muse;

import java.util.LinkedHashMap;
public class ShortStory extends WrittenArtisticWork {
    // Variable
    public String setting;
    // Getters and setters
    public String getSetting() {
        return setting;
    }
    public void setSetting(String setting) {
        this.setting = setting;
    }
    // Default contructor
    public ShortStory() {
        setting = "";
    }
    // Non-default constructor
    public ShortStory(String creator, String date, String title, String description,
            String language, String text, String setting) {
        super(creator,date,title,description,language,text);
        setSetting(setting);
    }
    // Non-default constructor
    public ShortStory(LinkedHashMap<String,String> settings) {
        super(settings);
        setSetting(settings.get("setting"));
    }
    // Overriding the getType method from the super class
    @Override
    public String getType() {
        return "short story";
    }
    // Overriding the specific info string method from the super class
    @Override
    public String getSpecificInfoString() {
        return String.format("Setting: %s\n%s", setting, super.getSpecificInfoString());
    }
    @Override
    public String toTabDelimitedString() {
        return String.format("%s\t%s", super.toTabDelimitedString(), setting);
    }
}