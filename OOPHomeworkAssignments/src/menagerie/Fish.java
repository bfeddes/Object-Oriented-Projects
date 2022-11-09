/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Fish Class
 */
package menagerie;
import java.util.Random;
public class Fish extends Pet{
    // Variables
    private int swimInCirclesProb;
    private int splashWaterProb;
    private int playDeadProb;
    private Random rnd;

    // Getters and setters
    public int getSwimInCirclesProb() {
        return swimInCirclesProb;
    }
    public void setSwimInCirclesProb(int swimInCirclesProb) {
        this.swimInCirclesProb = swimInCirclesProb;
    }
    public int getSplashWaterProb() {
        return splashWaterProb;
    }
    public void setSplashWaterProb(int splashWaterProb) {
        this.splashWaterProb = splashWaterProb;
    }
    public int getPlayDeadProb() {
        return playDeadProb;
    }
    public void setPlayDeadProb(int playDeadProb) {
        this.playDeadProb = playDeadProb;
    }
    public boolean swimCircles() {
        if (getSwimInCirclesProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean splashWater() {
        if (getSplashWaterProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean playDead() {
        if (getPlayDeadProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    // Default constructor
    public Fish(){
        super();
    }
    // Non-default constructor 
    public Fish(String name, int age, double weight) {
        super(name, age, weight);
        animalCutoffs();
        rnd = new Random();
    }
    // Initializing the cutoffs for a dog
    @Override
    public void animalCutoffs(){
        setEatProb(6);
        setSleepProb(8);
        setSeekAttProb(2);
        setSwimInCirclesProb(10);
        setSplashWaterProb(7);
        setPlayDeadProb(4);
    }
    // Act method for fish that will print out the fish's activities each hour.
    @Override 
    public String act() {
        String extraActivities = "";
        extraActivities = extraActivities.concat(super.act());
        if (swimCircles()) { 
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", got excited and swam in circles.\n");
        }
        if (splashWater()) {
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", swam too agressively and splashed water.\n");
        }
        if (playDead()) {
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", played dead in hopes of being flushed down the toilet.\n");
        }
        return extraActivities;
    }
    // Overriding the getAnimalType() method so it will return fish
    @Override
    public String getAnimalType() {
        return "fish";
    }
    // Overriding toString method for fish
    @Override
    public String toString() {
        return String.format("%s\t%s", getAnimalType(), super.toString());
    }
}
