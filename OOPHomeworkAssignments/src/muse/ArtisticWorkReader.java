package muse;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("unchecked") // I got annoyed by the warning that casting it as an ArrayList of ArtisticWorks give, so I added this in.
public class ArtisticWorkReader {
    // Method for reading from XML
    public static ArrayList<ArtisticWork> readFromXML (String fileName) {
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(new File(fileName))));
            ArrayList<ArtisticWork> artWorks = (ArrayList<ArtisticWork>)decoder.readObject();
            decoder.close();
            return artWorks;
        } catch (Exception ex) {
            return null;
        }
    }
    // Method for reading from text
    public static ArrayList<ArtisticWork> readFromText(String fileName) {
        try {
            ArrayList<ArtisticWork> artWorks = new ArrayList<ArtisticWork>();
            Scanner fsc = new Scanner(new File(fileName));
            // Variables
            String line,title,artType,creator,date,description,fName, key, resoulution, language, text, meter, setting, commentDate, commentName, commentDesc;
            String[] parts;
            int duration, bpm, frameRate;
            double fileSize;
            Song song;
            Movie movie;
            Poem poem;
            ShortStory shortStory;
            Comment comment;
            while (fsc.hasNextLine()) {
                // Variables that apply to all posts, seperated by tabs
                line = fsc.nextLine().trim();
                parts = line.split("\t");
                title = parts[0];
                artType = parts[1];
                creator = parts[2];
                date = parts[3];
                description = parts[4];
                if (artType.equalsIgnoreCase("song")) { // Variables that apply to songs
                    duration = Integer.parseInt(parts[5]);
                    fName = parts[6];
                    fileSize = Double.parseDouble(parts[7]);
                    bpm = Integer.parseInt(parts[8]);
                    key = parts[9];
                    song = new Song(creator, date, title, description, duration, fName, fileSize, bpm, key);
                    artWorks.add(song);
                    for (int i = 10; i < parts.length; i+=3 ){
                        commentDate = parts[i];
                        commentName = parts[i+1];
                        commentDesc = parts[i+2];
                        comment = new Comment(commentName, commentDate, commentDesc);
                        song.addComment(comment);
                    }
                }
                else if (artType.equalsIgnoreCase("Movie")){ // Variables that apply to movies
                    duration = Integer.parseInt(parts[5]);
                    fName = parts[6];
                    fileSize = Double.parseDouble(parts[7]);
                    resoulution = parts[8];
                    frameRate = Integer.parseInt(parts[9]);
                    movie = new Movie(creator, date, title, description, duration, fName, fileSize, frameRate, resoulution);
                    artWorks.add(movie);
                    for (int i = 10; i < parts.length; i+=3 ){
                        commentDate = parts[i];
                        commentName = parts[i+1];
                        commentDesc = parts[i+2];
                        comment = new Comment(commentName, commentDate, commentDesc);
                        movie.addComment(comment);
                    }
                }
                else if (artType.equalsIgnoreCase("Poem")){ // Variables that apply to poems
                    language = parts[5];
                    text = parts[6];
                    meter = parts[7];
                    poem = new Poem(creator, date, title, description, language, text, meter);
                    artWorks.add(poem);
                    for (int i = 8; i < parts.length; i+=3 ){
                        commentDate = parts[i];
                        commentName = parts[i+1];
                        commentDesc = parts[i+2];
                        comment = new Comment(commentName, commentDate, commentDesc);
                        poem.addComment(comment);
                    }
                }
                else if (artType.equalsIgnoreCase("short story")) { // Variables that apply to short stories
                    language = parts[5];
                    text = parts[6];
                    setting = parts[7];
                    shortStory = new ShortStory(creator, date, title, description, language, text, setting);
                    artWorks.add(shortStory);
                    for (int i = 8; i < parts.length; i+=3 ){
                        commentDate = parts[i];
                        commentName = parts[i+1];
                        commentDesc = parts[i+2];
                        comment = new Comment(commentName, commentDate, commentDesc);
                        shortStory.addComment(comment);
                    }
                }
            }
            fsc.close();
            return artWorks;
        } catch (Exception ex) {
            return null;
        }
    }
    // Method for reading a binary file
    public static ArrayList<ArtisticWork> readFromBinary (String fileName) {
        try {
            FileInputStream fileInput = new FileInputStream(new File(fileName));
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            ArrayList<ArtisticWork> artWorks = (ArrayList<ArtisticWork>)objectInput.readObject();
            objectInput.close();
            return artWorks;
        } catch (Exception ex) {
            return null;
        }
      }
}
