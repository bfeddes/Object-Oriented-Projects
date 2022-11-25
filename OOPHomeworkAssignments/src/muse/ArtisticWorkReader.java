package muse;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
@SuppressWarnings("unchecked") // I got annoyed by the warning that casting it as an ArrayList of ArtisticWorks give, so I added this in.
public class ArtisticWorkReader {

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

    public static ArrayList<ArtisticWork> readFromText(String fileName) {
        try {
            ArrayList<ArtisticWork> artWorks = new ArrayList<ArtisticWork>();
            Scanner fsc = new Scanner(new File(fileName));
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
                line = fsc.nextLine().trim();
                parts = line.split("\t");
                title = parts[0];
                artType = parts[1];
                creator = parts[2];
                date = parts[3];
                description = parts[4];
                if (artType.equalsIgnoreCase("song")) {
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
                        
                    }
                }
                else if (artType.equalsIgnoreCase("Movie")){
                    duration = Integer.parseInt(parts[5]);
                    fName = parts[6];
                    fileSize = Double.parseDouble(parts[7]);
                    resoulution = parts[8];
                    frameRate = Integer.parseInt(parts[9]);
                    movie = new Movie(creator, date, title, description, duration, fName, fileSize, frameRate, resoulution);
                    artWorks.add(movie);
                }
                else if (artType.equalsIgnoreCase("Poem")){
                    language = parts[5];
                    text = parts[6];
                    meter = parts[7];
                    poem = new Poem(creator, date, title, description, language, text, meter);
                    artWorks.add(poem);
                }
                else if (artType.equalsIgnoreCase("short story")) {
                    language = parts[5];
                    text = parts[6];
                    setting = parts[7];
                    shortStory = new ShortStory(creator, date, title, description, language, text, setting);
                    artWorks.add(shortStory);
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
      public static ArrayList<ArtisticWork> readFromJSON(String fileName) {
        try {
            ArrayList<ArtisticWork> artWorks = new ArrayList<ArtisticWork>();
            FileReader reader = new FileReader(new File(fileName));
            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray)parser.parse(reader);
            Iterator<JSONObject> itr = arr.iterator();
            JSONObject obj;
            String title, type, author, date, description, fName, key;
            int duration, bpm;
            double fileSize;
            Song song;
            while (itr.hasNext()) {
                obj = itr.next();
                title = obj.get("Title").toString();
                type = obj.get("Type").toString();
                author = obj.get("Author").toString();
                date = obj.get("Date").toString();
                description = obj.get("Description").toString();
                fName = obj.get("File Name").toString();
                duration = Integer.parseInt(obj.get("Duration").toString());
                fileSize = Double.parseDouble(obj.get("File Size").toString());
                bpm = Integer.parseInt(obj.get("bpm").toString());
                key = obj.get("Key").toString();
                if (type.equalsIgnoreCase("song")) {
                    song = new Song(author, date, title, description, duration, fName, fileSize, bpm, key);
                    artWorks.add(song);
                }
            }
            reader.close();
            return artWorks;
        } catch(Exception ex) {
            return null;
        }
    }
}
