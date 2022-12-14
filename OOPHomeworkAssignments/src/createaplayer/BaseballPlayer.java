package createaplayer;

public class BaseballPlayer extends Player {
    // Variables
    int height; // in inches 
    double weight; // in pounds 
    int athleticism; // scale of 55-99
    String name; 
    String position;

    // Getters and setters

    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAthleticism() {
        return athleticism;
    }

    public void setAthleticism(int athleticism) {
        this.athleticism = athleticism;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Default constructor 
    public BaseballPlayer() {
    }

    // Non-default constructor 
    public BaseballPlayer(String name,  String position, int height, double weight, int athleticism) {
        super(name, position, height, weight, athleticism);
    }

    // Overriding the abstract methods
    @Override 
    public String getPlayerSport() {
        return "Baseball";
    }   

    @Override
    public String toString() {
        return String.format("%s\t%s", getPlayerSport(), super.toString());
    }
}
