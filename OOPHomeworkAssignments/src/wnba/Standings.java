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
    // Method that just prints out the header to the program
    public static void header(){
        System.out.println("***************************************************");
        System.out.println("\t       2022 WNBA STANDINGS");
        System.out.println("***************************************************\n");
    }
    // This is just a simple userMenu which prints out the user's options. Exception handling and invalid number input is in the main method.
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
    // This is just a short function that calculatues team win percentage.
    public static double calcWinPct(String line) {
		String[] parts = line.split("\t");
        int wins = (Integer.parseInt(parts[1]));
        int losses = (Integer.parseInt(parts[2]));
        double winPct = wins / (wins + (double)losses); // I had to cast one of the values as a double, otherwise it would return 0 as it reads it as an int.
		return winPct;
	}
    // I created this function to display all 12 teams in order. It iterates through all teams and compares their winPct and arranges them based on it.
    public static void arrangeTeamsByPct(ArrayList<String> allTeams, String line){
        // Variables
        double ogWinPct = calcWinPct(line);
        double compareAverage;
        int place = 0;
        // Loop iterating through the teams in the allTeams ArrayList. It calculates each team's winPct and compares it.
        for (int i = 0; i < allTeams.size(); i++) {
            compareAverage = calcWinPct(allTeams.get(i));
            if (ogWinPct > compareAverage) {
            place = i;
            break;
            }
        }
        if (place <1) {
            allTeams.add(line);
        }else {
            allTeams.add(place, line);
        }
    }
    // This function prints out the teams in a nicely formatted table and handles the games back calculation.
    public static void printConference(ArrayList<String> conference){
        // Variables
        String[] parts;
        double winPct, gb;
        double leadTeamWins = 0;
        double leadTeamLosses = 0;
        String teamName;
        int wins, losses;
        // Printing out the each team's stats on the season and printing it out in a nice format.
        System.out.println("Team name\t\tWins\tLosses\t   PCT\t   GB");
        for(String team : conference){
            parts = team.split("\t");
            teamName = parts[0];
			wins = (Integer.parseInt(parts[1]));
			losses = (Integer.parseInt(parts[2]));
            if(wins > leadTeamWins){
            leadTeamWins = wins;
            leadTeamLosses = losses;
            }
            // I took the winPct calculation out of this method and made it its own method so I could use that method to organize teams with.
            winPct = calcWinPct(team);
            gb = ((leadTeamWins - wins)+(losses - leadTeamLosses))/2;
            // This if.. else statement will print a - if if it the lead team, as they don't have any games back.
            if(gb == 0){
            System.out.printf("%-25s%3d%10d%8.3f\t   -\n",teamName, wins, losses, winPct);
            System.out.print("");
            }else{
            System.out.printf("%-25s%3d%10d%8.3f%7.1f\n",teamName, wins, losses, winPct, gb);
			System.out.print("");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Calling header method to print out the header
        header();

        // Asking the user to inser the correct file.
        System.out.print("Enter the standings filename: ");
        String fileName = sc.nextLine();

        // Variables
        ArrayList<String> eastern = new ArrayList<String>();
        ArrayList<String> western = new ArrayList<String>();
        ArrayList<String> allTeams = new ArrayList<String>();
        ArrayList<String> target = null;
        String line;
        String[] parts;
        int userChoice;
        // Setting a default boolean value to false, meaning if the file input is invalid, it will remain false and the program will shut down.
        boolean proceed = false;
        try{
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine();
                // parts splits the file into parts. Because the file content is seperated by tabs, \t is how I want to split everything up
                parts = line.split("\t");
                if (parts[0].equalsIgnoreCase("Conference: Eastern")){
                    target = eastern;
                    // Skips the empty line between conferences
                } else if (parts[0].length() == 0){
                    continue;
                } else if (parts[0].equalsIgnoreCase("Conference: Western")){
                    target = western;
                }else{
                    target.add(line);
                    arrangeTeamsByPct(allTeams, line);
                }
            }
            // The boolean I set earlier will turn to true, which will enable the user to now select teams.
            proceed = true;
            fsc.close();
            // Printing out that the teams have been read if everything functions properly
            System.out.println("The teams have been read.");
        } catch(Exception ex){
            // Informing the user the file they input is invalid and shuts down the program.
            System.out.println("Invalid file name.");
        }
        // This part of the program will only run IF the file is valid. Otherwise the program will end immediately if the file is invalid.
        if (proceed == true) {
            do{
            // This try ... catch is for if the user inputs something that would cause the program to break. Example: "one".
            try{
            userChoice = userMenu();
            } catch (Exception ex){
                System.out.println("\nThat is an invalid choice.\n");
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
                printConference(allTeams);
                System.out.println();
            } else if (userChoice > 4 || userChoice < 1){
                System.out.println("\nThat is an invalid choice.\n");
            }
        } while (userChoice != 4);
    }
        System.out.println("\nThank you for using this program.");
    }
}