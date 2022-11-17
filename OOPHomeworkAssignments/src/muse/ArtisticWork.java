package muse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
public abstract class ArtisticWork {
    // Variables
    private String creator;
    private String date;
    private String title;
    private String description;
    private ArrayList<Comment> comments;
    // Getters and setters
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    // Default constructor
    public ArtisticWork() {
        date = "1/1/1900";
        title = "title";
        creator = "anonymous";
        description = "description";
        comments = new ArrayList<Comment>();
    }
    // Non-default constructor
    public ArtisticWork(String creator, String date, String title, String description) {
        setCreator(creator);
        setDate(date);
        setTitle(title);
        setDescription(description);
        comments = new ArrayList<Comment>();
    }
    // Method for adding settings to the LinkedHashMap
    public ArtisticWork(LinkedHashMap<String,String> settings) {
        this(settings.get("creator"),settings.get("date"),settings.get("title"),settings.get("description"));
    }
    // Abstract getType method which will be overriden in subclasses to get the type
    public abstract String getType();
    public String getGeneralInfoString() {
        return String.format("%s, a %s by %s, posted on %s",title,getType(),creator,date);
    }
    // Abstract getSpecificInfoString method which will be overidden in subclasses to get specific info
    public abstract String getSpecificInfoString();
    // Method for adding comments to a post
    public String getCommentsAsString() {
        String result = "";
        for (Comment comment : comments) {
            result = result + comment + "\n";
        }
        if (result.isBlank()) {
            return "No comments";
        }
        return result;
    }
    // Overriding the toString function
    @Override
    public String toString() {
        return getGeneralInfoString() + "\n" + getSpecificInfoString() + "\nComments: \n" + getCommentsAsString();
    }
    // Method for adding a comment to a post
    public void addComment(String postedBy, String date, String content) {
        Comment comment = new Comment(postedBy, date, content);
        comments.add(comment);
    }
    // This method seems redundant to the one above. Not positive of its purpose
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    // Method for printing out a post's title, type, and who created the post
    public String getShortString() {
        return String.format("\"%s\", a %s by %s", title, getType(), creator);
    }
}