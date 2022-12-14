package createaplayer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PlayerWriter {

    public static boolean writeToText(ArrayList<Player> myPlayers, File f) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            for (Player p : myPlayers){
            pw.println(p);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /*
     * ADD CODE FOR Binary WRITER
     */
    
     /*
     * ADD CODE FOR XML WRITER
     */
    
     /*
     * ADD CODE FOR JSON WRITER
     */
}
