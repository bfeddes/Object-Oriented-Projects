package wnba;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Standings {
    public static void header(){
        System.out.println("***************************************************");
        System.out.println("\t       2022 WNBA STANDINGS");
        System.out.println("***************************************************\n");
    }
    public static int userMenu(Scanner sc){
        System.out.println("What would you like to see?");
        System.out.println("1. Eastern Conference");
		System.out.println("2. Western Conference");
		System.out.println("3. Combined");
		System.out.println("4. Exit");
		System.out.print("Enter the number of your choice: "); 
        int userChoice = sc.nextInt();
        return userChoice;
    }
    /* Create header (done)
     * Offer the user options to see eastern conference standings
     * Offer the user options to see western conference standings
     * Offer the user options to see overall standings
     * Each display of standings will show the team name, number of wins, number of losses, winning percentage, and games behind, teams sorted by winning percentage
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Calling header method to print out the header
        header();
        // Initializing Scanner object for user input
        System.out.print("Enter the standings filename: ");
        String fileName = sc.nextLine();

        // Variables
        ArrayList<String> allTeams = new ArrayList<String>();
        ArrayList<String> eastern = new ArrayList<String>();
        ArrayList<String> western = new ArrayList<String>();
        ArrayList<String> target = null;
        String teamName, line;
        String[] parts;
        int userChoice;
        double wins, losses, winningPct, gamesBack;
        try{
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine();
                // parts splits the file into parts. Because the file content is seperated by tabs, \t is how I want to split everything up
                parts = line.split("\t");
                if (parts[0].equalsIgnoreCase("Conference: Eastern")){
                    target = eastern;
                } else if (parts[0].equalsIgnoreCase("Conference: Western")){
                    target = western;
                }else{
                    target.add(line);
                    // **Add function to add the total combined list and arrange them in order**
                }
            }
            // Printing out that the teams have been read if everything functions properly
            System.out.println("The teams have been read.");
        } catch(Exception e){
            // Informing the user the file they input is invalid.
            System.out.println("Invalid file name.");
        }
        do{
            // Add exception handling to handle if the numbers are input as a string like "one"
            // Add the functional aspects for printing the standings information for each conference.
            userChoice = userMenu(sc);
            if(userChoice == 1){
                // Display Eastern Conference standings
            } else if (userChoice == 2){
                // Display Western Conference standings
            } else if (userChoice == 3){
                // Display total WNBA standings
            } else if (userChoice > 4 || userChoice < 1){
                System.out.println("\nInvalid input\n");
            }
        } while (userChoice != 4);
    }
}
