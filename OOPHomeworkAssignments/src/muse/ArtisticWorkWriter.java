package muse;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
public class ArtisticWorkWriter {

    // Method for writing to .txt
    public static boolean writeToText(ArrayList<ArtisticWork> artWorks, String fileName) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
            for (ArtisticWork work : artWorks) {
                pw.println(work.toTabDelimitedString() + "\t" + work.getCommentsAsTabDelimited());
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
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
}
