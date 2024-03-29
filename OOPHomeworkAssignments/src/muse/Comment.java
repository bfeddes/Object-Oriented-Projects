package muse;

import java.io.Serializable;

public class Comment implements Serializable{
    // Variables
    private String postedBy;
    private String dateTime;
    private String content;
    // Getters and setters
    public String getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    // Default constructor
    public Comment() {
        postedBy = "";
        dateTime = "";
        content = "";
    }
    // Non-default constructor
    public Comment(String postedBy, String dateTime, String content) {
        setPostedBy(postedBy);
        setDateTime(dateTime);
        setContent(content);
    }
    // Overriding toString function
    @Override
    public String toString() {
        return String.format("On %s, %s commented ...\n\t\"%s\"", dateTime, postedBy, content);
    }
    public String toTabDelimitedString() {
        return  String.format("%s\t%s\t%s", dateTime, postedBy, content);
    }
}