package muse;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;

public class ArtisticWorkWriter {

    // ADD TEXT WRITE

    // Method for writing to XML
    public static boolean writeToXML(ArrayList<ArtisticWork> artWorks, String fileName) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(fileName))));
            encoder.writeObject(artWorks);
            encoder.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    // Method for writing to Binary
    public static boolean writeToBinary(ArrayList<ArtisticWork> artWorks, String fileName) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(new File(fileName));
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(artWorks);
            objectOutput.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    // ADD JSON WRITER
}
