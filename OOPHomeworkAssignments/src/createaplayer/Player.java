package createaplayer;

public abstract class Player {

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAthleticism() {
        return athleticism;
    }
    public void setAthleticism(int athleticism) {
        this.athleticism = athleticism;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    // Abstract methods 
    public abstract String getPlayerSport();
    public abstract String getPlayerPosition();

    // Default constructor (Default player build)
    public Player () {
        height = 72; // 72 inches aka 6 foot
        athleticism = 55; // 55 on a scale of 55-99
        weight = 185.0;
        name = "No name";
        position = "Waterboy";
    }
    // Non-default constructor 
    public Player(String name,  String position, int height, double weight, int athleticism) {
        setName(name);
        setPosition(position);
        setHeight(height);
        setWeight(weight);
        setAthleticism(athleticism);
    }
    // toString method 
    @Override 
    public String toString() {
        return String.format("%-8s\t%-8s\t%-5d\t%-5.2f\t%-5d", name, position, height, weight, athleticism);
    }
}
