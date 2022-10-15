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
    /* Create header (done)
     * Offer the user options to see eastern conference standings
     * Offer the user options to see western conference standings
     * Offer the user options to see overall standings
     * Each display of standings will show the team name, number of wins, number of losses, winning percentage, and games behind, teams sorted by winning percentage
     */
    public static void main(String[] args){
        // Initializing Scanner object for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the standings filename: ");
        String fileName = sc.nextLine();

        // Variables
        ArrayList<String> eastern = new ArrayList<String>();
        ArrayList<String> western = new ArrayList<String>();
        String[] target;
        String line;
        String[] parts;
        double wins, losses, winningPct, gamesBack;
        header();
    }
}
