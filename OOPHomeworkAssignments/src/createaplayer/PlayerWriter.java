package createaplayer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PlayerWriter {

    // Write to text method
    public static boolean writeToText(ArrayList<Player> myPlayers, File fileName) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (Player p : myPlayers){
            pw.println(p);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Write to binary method
    public static boolean writeToBinary(File fileName, ArrayList<Player> myPlayers) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(fileName);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(myPlayers);
            objectOutput.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     /*
     * ADD CODE FOR XML WRITER
     */
    
     /*
     * ADD CODE FOR JSON WRITER
     */
}
