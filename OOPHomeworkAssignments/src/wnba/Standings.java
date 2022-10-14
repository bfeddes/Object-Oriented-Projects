package wnba;
import java.util.Scanner;
import java.io.File;
public class Standings {
    public static void header(){
        System.out.println("***************************************************");
        System.out.println("\t       2022 WNBA STANDINGS");
        System.out.println("***************************************************\n");
    }
    /* Create header (done)
     * Offer the user options to see eastern conference standings
     * Offer the user options to see western conference standings
     * Offer the user options to see overall standings
     * Each display of standings will show the team name, number of wins, number of losses, winning percentage, and games behind. Teams sorted by winning percentage
     */
    public static void main(String[] args){
        // Initializing Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Variables
        String fileName;
        String line;
        String teamName;
        String[] parts;
        String[] eastern = new String[6];
        String[] western = new String[6];
        int wins, losses;
        double winningPct, gamesBack;

        // Calling header function to print the program header
        header();
        // Asking the user to enter the file name
        System.out.print("Enter the standings filename: ");
        fileName = sc.nextLine();

        // Initializing Scanner object for the user to select a file path
        try {
            Scanner fsc = new Scanner(new File(fileName));
            while(fsc.hasNextLine()){
                line = fsc.nextLine();
                if (line.length() > 0){
                parts = line.split("\t");
                teamName = parts[0]; 
                System.out.println(teamName);
                }
            }
        } catch (Exception ex) {
            System.out.println("The file you entered is invalid");
        }
    }
}
