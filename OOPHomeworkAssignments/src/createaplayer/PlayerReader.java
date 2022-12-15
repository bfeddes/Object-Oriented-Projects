package createaplayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerReader {

    public static boolean readFromText(File fileName, ArrayList<Player> myPlayers ) {
        try {
            myPlayers = new ArrayList<Player>();
            Scanner fsc = new Scanner(fileName);
            String line;
            String[] parts;
            String playerSport, playerName, playerPosition; // Add more once I add more to specific types of players
            double weight; // add more once I add more to specific types of players
            int height, athleticism; // add more once I add more to specific types of players

            // Different kinds of players to read:
            BaseballPlayer baseballPlayer;
            BasketballPlayer basketballPlayer;
            FootballPlayer footballPlayer;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                parts = line.split("\t");
                // Attributes all players have
                playerSport = parts[0];
                playerName = parts[1];
                playerPosition = parts[2];
                height = Integer.parseInt(parts[3]);
                weight = Double.parseDouble(parts[4]);
                athleticism = Integer.parseInt(parts[5]);

                // Attributes only baseball players have
                if (playerSport.equalsIgnoreCase("baseball")) {
                    baseballPlayer = new BaseballPlayer();
                    myPlayers.add(baseballPlayer);
                } else if (playerSport.equalsIgnoreCase("basketball")) {
                    basketballPlayer = new BasketballPlayer();
                    myPlayers.add(basketballPlayer);
                } else if (playerSport.equalsIgnoreCase("football")) {
                    footballPlayer = new FootballPlayer();
                    myPlayers.add(footballPlayer);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Binary reader 
    public static boolean readFromBinary(File fileName, ArrayList<Player> myPlayers) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            myPlayers = (ArrayList<Player>)ois.readObject();
            ois.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
     /*
     * ADD CODE FOR XML READER
     */
    
     /*
     * ADD CODE FOR JSON READER
     */
    
}
