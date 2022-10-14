package wnba;
import java.util.Scanner;
import java.io.File;
public class Standings {
    public static void easternConference(String fileName){
        // Variables
        String line;
        String[] parts;
        String[] eastern = new String[6];
        String[] target;
        String teamName = "";
        double wins, losses, winningPct, gamesBack;
        try {
            // Initializing Scanner object for the user to select a file path
            Scanner fsc = new Scanner(new File(fileName));
            while(fsc.hasNextLine()){
                line = fsc.nextLine();
                if (line.length() > 0){
                    parts = line.split("\t");
                    teamName = parts[0]; 
                }
                System.out.println(teamName);
            }
        } catch (Exception ex) {
            System.out.println("The file you entered is invalid");
        }
}
    public static void header(){
        System.out.println("***************************************************");
        System.out.println("\t       2022 WNBA STANDINGS");
        System.out.println("***************************************************\n");
    }
    /* Create header (done)
     * Offer the user options to see eastern conference standings
     * Offer the user options to see western conference standings
     * Offer the user options to see overall standings
     * Each display of standings will show the team name, number of wins, number of losses, winning percentage, and games behind, teams sorted by winning percentage
     */
    public static void main(String[] args){
        // Initializing Scanner object for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        String fileName = sc.nextLine();
        easternConference(fileName);
    }
}
