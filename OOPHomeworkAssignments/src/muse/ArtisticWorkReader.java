package muse;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
@SuppressWarnings("unchecked") // I got annoyed by the warning that casting it as an ArrayList of ArtisticWorks give, so I added this in.
public class ArtisticWorkReader {

    // CODE FOR XML

    // CODE FOR TEXT

    // Method for reading a binary file
    public static ArrayList<ArtisticWork> readFromBinary (String fname) {
        try {
            FileInputStream fileInput = new FileInputStream(new File(fname));
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
