package storytelling;
import java.io.File;
import java.util.Scanner;
public class WordFileReader {
    // Testing out fileReading functionality
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String line;

        System.out.print("Enter the name of the word file: ");
        String fileName = sc.nextLine();
        try{ Scanner fsc = new Scanner(new File(fileName));
                while(fsc.hasNextLine()){
                    line = fsc.nextLine();
                    System.out.println(line);
                }
            fsc.close();
        } catch (Exception ex){
            System.out.println("Invalid file name.");
        }
    }
}
