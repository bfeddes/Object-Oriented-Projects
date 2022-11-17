/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Cat Class
 */
package menagerie;
import java.util.Random;

public class Cat extends Pet {
    // Variables
    private int scratchProb;
    private int pukeInShoeProb;
    private int hissProb;
    private Random rnd;

    // Getters and setters
    public int getScratchProb() {
        return scratchProb;
    }
    public void setScratchProb(int scratchProb) {
        this.scratchProb = scratchProb;
    }
    public int getPukeInShoeProb() {
        return pukeInShoeProb;
    }
    public void setPukeInShoeProb(int pukeInShoeProb) {
        this.pukeInShoeProb = pukeInShoeProb;
    }
    public int getHissProb() {
        return hissProb;
    }
    public void setHissProb(int hissProb) {
        this.hissProb = hissProb;
    }
    // Boolean methods to determine if that specific action should be included in the act() String
    public boolean hissed() {
        if (getHissProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean pukedInShoe() {
        if (getPukeInShoeProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean scratched() {
        if (getScratchProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    // Default constructor
    public Cat() {
        super();
    }
    // Non default constructor
    public Cat(String name, int age, double weight) {
        super(name, age, weight);
        animalCutoffs();
        rnd = new Random();
    }
    // Act method for cat that will print out the cat's activities each hour.
    @Override 
    public String act(){
        String extraActivities = "";
        extraActivities = extraActivities.concat(super.act());
        if (hissed()) { 
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", was angry and hissed.\n");
        }
        if (pukedInShoe()) {
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", saw your new pair of shoes and puked in them.\n");
        }
        if (scratched()) {
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", decided you looked too happy and scratched you.\n");
        }
        return extraActivities;
    }
    // Initializing the cutoffs for a cat
    @Override
    public void animalCutoffs() {
        setEatProb(7);
        setSleepProb(16);
        setSeekAttProb(3);
        setHissProb(7);
        setPukeInShoeProb(7);
        setScratchProb(9);
    }
    // Overriding the animal type for a cat.
    @Override
    public String getAnimalType() {
        return "cat";
    }
    // Override the toString method
    @Override
    public String toString() {
        return String.format("%s\t%s", getAnimalType(), super.toString());
    }
}

