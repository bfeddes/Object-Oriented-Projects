package muse;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;
public class ArtisticWorkWriter {
  // Text writer
  
  // XML Writer
  
  public static boolean writeToBinary(ArrayList<ArtisticWork> works, String fname) {
    try {
        FileOutputStream fos = new FileOutputStream(new File(fname));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(works);
        oos.close();
        return true;
    } catch (Exception ex) {
        return false;
    }
}
  // Potentially JSON Writer
}
