package muse;
import java.util.LinkedHashMap;
public class Movie extends RecordedArtisticWork {
    // Variables
    private int frameRate; // frames per second
    private String resolution;  // 720p, 1040p, 2048p, etc
    // Getters and setters
    public int getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(int frameRate) {
        if (frameRate < 0) {
            frameRate = 0;
        } else {
            this.frameRate = frameRate;
        }
    }
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String res) {
        resolution = res;
    }
    // Default constructor
    public Movie() {
        frameRate = 30;
        resolution = "720p";
    }
    // Non-default constructor
    public Movie(String creator, String date, String title, String description, int duration, String fileName, double fileSize, int frameRate, String resolution) {
        super(creator,date,title,description,duration,fileName,fileSize);
        setFrameRate(frameRate);
        setResolution(resolution);
    }
    // Non-default constructor
    public Movie(LinkedHashMap<String,String> settings) {
       super(settings);
       setFrameRate(Integer.parseInt(settings.get("framerate")));
       setResolution(settings.get("resolution"));
    }
    // Overriding the getType method 
    @Override
    public String getType() {
        return "movie";
    }
    // Overriding the specific info 
    @Override
    public String getSpecificInfoString() {
        return String.format("filmed with %s resolution at %d frames per second", resolution, frameRate);
    }
    @Override
    public String toTabDelimitedString() {
        return String.format("%s\t%s\t%d", super.toTabDelimitedString(),resolution, frameRate);
    }
}
