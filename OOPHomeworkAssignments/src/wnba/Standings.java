/*Brian Feddes
 * WNBA Programming Assignment
 * Object Oriented Programming
 * Professor Klump
 * Fall 2022
 */
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
    public static int userMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to see?");
        System.out.println("1. Eastern Conference");
		System.out.println("2. Western Conference");
		System.out.println("3. Combined");
		System.out.println("4. Exit");
		System.out.print("Enter the number of your choice: "); 
        int userChoice = sc.nextInt();
        return userChoice;
    }
    public static void printConference(ArrayList<String> conference){
        String[] parts;
        double gamesBack;
        double winPct;
        String teamName;
        int wins, losses, pct, gb;
        // Printing out the WNBA conference, including their wins, losses, win percent, and games back.
        System.out.println("Team name\t\tWins\tLosses\tPCT\tGB");
        for(String team : conference){
            parts = team.split("\t");
            teamName = parts[0];
			wins = (Integer.parseInt(parts[1]));
			losses = (Integer.parseInt(parts[2]));
            pct = wins / (wins + losses);
            System.out.printf("%-15s%-10s%-10s%6.3s\t\n",teamName,wins, losses, pct);
			System.out.print("");
        }
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
        // Asking the user to inser the correct file.
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
        boolean proceed = false;
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
            // The boolean I set earlier will turn to true, which will enable the user to now select teams.
            proceed = true;
            fsc.close();
            // Printing out that the teams have been read if everything functions properly
            System.out.println("The teams have been read.");
        } catch(Exception e){
            // Informing the user the file they input is invalid.
            System.out.println("Invalid file name.");
        }
        // This part of the program will only run IF the file is valid. Otherwise the program will end immediately if the file is invalid.
        if (proceed == true) {
            do{
            // This try ... catch is for if the user inputs something that would cause the program to break. Example: "one".
            try{
            userChoice = userMenu();
            } catch (Exception ex){
                System.out.println("\nInvalid input\n");
                userChoice = userMenu();
            }
            // Displaying Eastern, Western, or overall WNBA standings based on the user's input.
            if(userChoice == 1){
                System.out.println("\nStandings for the Eastern Conference");
                printConference(eastern);
                System.out.println();
            } else if (userChoice == 2){
                System.out.println("\nStandings for the Western Conference");
                printConference(western);
                System.out.println();
            } else if (userChoice == 3){
                System.out.println("\nCombined Conference Standings");
                // Display total WNBA standings
                System.out.println();
            } else if (userChoice > 4 || userChoice < 1){
                System.out.println("\nInvalid input\n");
            }
        } while (userChoice != 4);
    }
        System.out.println("\nThank you for using this program.");
    }
}
