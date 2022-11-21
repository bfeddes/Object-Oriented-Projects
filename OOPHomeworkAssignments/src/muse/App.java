package muse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class App {
    // method for printing the header
    public static void printHeading() {
        System.out.println("********************************************************************************");
        System.out.println("                        MUSE Social Media Platform, v1.0");
        System.out.println("********************************************************************************");
        System.out.println();
        System.out.println("Welcome to MUSE, the social media platform where artists and authors of all");
        System.out.println("kinds and from all over the world come together to share their inspirations and");
        System.out.println("ideas. Post your own original works and comment on what others are doing. Only");
        System.out.println("one rule: be kind!");
    }
    // Method for printing the menu
    public static void showMainMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Create a new post");
        System.out.println("2. Comment on a post");
        System.out.println("3. Read posts from a file");
        System.out.println("4. Write posts to a file");
        System.out.println("5. List all posts to screen");
        System.out.println("6. Clear posts");
        System.out.println("7. Quit");
        System.out.print("Enter the number of your choice: ");
    }
    // Method for printing new post options.
    public static void showNewPostMenu() {
        System.out.println("\nWhat would you like to a post?");
        System.out.println("1. Song");
        System.out.println("2. Movie");
        System.out.println("3. Poem");
        System.out.println("4. Short story");
        System.out.print("Enter the number of your choice: ");
    }
    // Method for getting the user's inputs that apply to all options
    public static LinkedHashMap<String,String> getCommonInputs(Scanner sc) {
        LinkedHashMap<String,String> result = new LinkedHashMap<String,String>();
        System.out.print("Enter the name of the creator: ");
        result.put("creator", sc.nextLine());
        System.out.print("Enter the date: ");
        result.put("date", sc.nextLine());
        System.out.print("Enter the title: ");
        result.put("title", sc.nextLine());
        System.out.print("Enter a description: ");
        result.put("description", sc.nextLine()); 
        return result;
    }
    // Method for inputs that apply to songs & movies
    public static LinkedHashMap<String,String> getCommonRecordedInputs(Scanner sc) {
        LinkedHashMap<String,String> result = getCommonInputs(sc);
        System.out.print("Enter duration: ");
        result.put("duration", sc.nextLine());
        System.out.print("Enter filename: ");
        result.put("filename",sc.nextLine());
        System.out.print("Enter file size: ");
        result.put("filesize", sc.nextLine());
        return result;
    }
    // Method for inputs that apply to poems and short stories
    public static LinkedHashMap<String,String> getCommonWrittenInputs(Scanner sc) {
        LinkedHashMap<String,String> result = getCommonInputs(sc);
        System.out.print("Enter language: ");
        result.put("language", sc.nextLine());
        System.out.print("Enter text: ");
        result.put("text", sc.nextLine());
        return result;
    }
    // Method for printing out what has been posted to MUSE
    public static void listWorks(ArrayList<ArtisticWork> works) {
        System.out.println("Here is what has been posted to MUSE: ");
        int count = 1;
        for (ArtisticWork work : works) {
            System.out.printf("%2d. %s\n",count,work.getShortString());
            count = count + 1;
        }
    }
    // Main method
    public static void main(String[] args) {
        // Printing out the header
        printHeading();
        // Variables
        int choice, artType;
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,String> responses;
        ArrayList<ArtisticWork> works = SampleArtisticWorks.generate();
        Song song;
        Poem poem;
        ShortStory story;
        Movie movie;
        int workNum;
        String commenterName, commenterDate, commentText, decision;
        Comment comment;
        ArtisticWork theWork;  // the work chosen to comment on

        // Do loop while the user's choice is not quit
        do {
            showMainMenu();
            choice = sc.nextInt();
            if (choice == 1) { // Option for a user to create a new post
                showNewPostMenu();
                artType = sc.nextInt();
                sc.nextLine();
                if (artType == 1) { // Option for a user to create a new song post
                    responses = getCommonRecordedInputs(sc);
                    System.out.print("Enter beats per minute: ");
                    responses.put("bpm",sc.nextLine());
                    System.out.print("Enter the key: ");
                    responses.put("key", sc.nextLine());
                    song = new Song(responses);
                    works.add(song);
                } else if (artType == 2) { // Option for a user to create a new movie post
                    responses = getCommonRecordedInputs(sc);
                    System.out.print("Enter framerate: ");
                    responses.put("framerate", sc.nextLine());
                    System.out.print("Enter resolution: ");
                    responses.put("resolution", sc.nextLine());
                    movie = new Movie(responses);
                    works.add(movie);
                } else if (artType == 3) { // Option for a user to create a new poem post
                    responses = getCommonWrittenInputs(sc);
                    System.out.print("Enter meter: ");
                    responses.put("meter",sc.nextLine());
                    poem = new Poem(responses);
                    works.add(poem);
                } else if (artType == 4) { // Option for a user to create a new short story post
                    responses = getCommonWrittenInputs(sc);
                    System.out.print("Describe the setting: ");
                    responses.put("setting", sc.nextLine());
                    story = new ShortStory(responses);
                    works.add(story);
                }
            } else if (choice == 2) { // Option for a user to add a comment to a post
                listWorks(works);
                if (works.isEmpty()){
                    System.out.println("Nothing has been posted.");
                } else {
                System.out.print("Which one do you want to comment on? ");
                workNum = sc.nextInt() - 1;
                sc.nextLine();
                theWork = works.get(workNum);
                System.out.println("\nHere is the work you have chosen to comment on: ");
                System.out.println(theWork);
                System.out.print("\nEnter your name: ");
                commenterName = sc.nextLine();
                System.out.print("Enter the date: ");
                commenterDate = sc.nextLine();
                System.out.print("Enter your comment: ");
                commentText = sc.nextLine();
                comment = new Comment(commenterName,commenterDate,commentText);
                theWork.addComment(comment);
                System.out.println("The new comment has been added. Here is the updated post:\n ");
                System.out.println(theWork);
                }
            }
            else if (choice == 3) {
                // ADD CODE TO READ POSTS FROM A FILE
            }
            else if (choice == 4) {
                // ADD CODE TO WRITE POSTS TO A FILE
            }
            else if (choice == 5) {
                // ADD CODE TO LIST ALL POSTS TO SCREEN
            }
            else if (choice == 6) {
                System.out.print("Are you sure (y or n)? ");
                decision = sc.next();
                if (decision.equalsIgnoreCase("y")){
                    System.out.println("All posts have been cleared.");
                    works.clear();
                }
            }
        } while (choice != 7);
        // Printing out the goodbye message
        System.out.println();
        System.out.println("Thank you for using MUSE. Be inspired to inspire everyone everywhere always.");
    }
}
