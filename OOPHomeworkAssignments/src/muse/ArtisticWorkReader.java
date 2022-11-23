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
            String line;
            String[] parts;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
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
    // POTENTIAL CODE FOR JSON
}
