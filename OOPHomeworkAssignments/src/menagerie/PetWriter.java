/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, PetWriter Class
 */
package menagerie;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;  
import java.io.FileWriter;

public class PetWriter {
    // Method to write the information to a file. Returns true if it works, returns false if it does not
    public static boolean writeToFile(ArrayList<Pet> pets, String fname) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
            for (Pet pet : pets) {
                pw.println(pet);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}