/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Dog Class
 */
package menagerie;
import java.util.Random;
public class Dog extends Pet {
    private int biteProb;
    private int comfortedHuman;
    private int chewedUpShoe;
    private int ateHomework;
    private Random rnd;

    public int getBiteProb() {
        return biteProb;
    }
    public void setBiteProb(int biteProb) {
        this.biteProb = biteProb;
    }
    public int getComfortedHuman() {
        return comfortedHuman;
    }
    public void setComfortedHuman(int comfortedHuman) {
        this.comfortedHuman = comfortedHuman;
    }
    public int getChewedUpShoe() {
        return chewedUpShoe;
    }
    public void setChewedUpShoe(int chewedUpShoe) {
        this.chewedUpShoe = chewedUpShoe;
    }
    public int getAteHomework() {
        return ateHomework;
    }
    public void setAteHomework(int ateHomework) {
        this.ateHomework = ateHomework;
    }
    public boolean ateHomework() {
        if (getAteHomework() > rnd.nextInt(24)) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean chewedUpShoe() {
        if (getChewedUpShoe() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean comfortedHuman() {
        if (getComfortedHuman() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean biteHuman() {
        if (getBiteProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
        // Constructors
        public Dog(){
            super();
        }
        public Dog(String name, int age, double weight) {
            super(name, age, weight);
            animalCutoffs();
            rnd = new Random();
        }
    @Override
    public void animalCutoffs(){
        setEatProb(8);
        setSleepProb(5);
        setSeekAttProb(12);
        setAteHomework(4);
        setChewedUpShoe(5);
        setComfortedHuman(11);
        setBiteProb(1); 
    }
    @Override 
    public String act() {
        String extraActivities = "";
        extraActivities = extraActivities.concat(super.act());
        if (chewedUpShoe()) { 
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", was bored and chewed up your new shoes.\n");
        }
        if (ateHomework()) {
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", ate your homework the night before it was due.\n");
        }
        if (comfortedHuman()) {
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", saw you were sad and comforted you.\n");
        }
        if (biteHuman()) {
            extraActivities = extraActivities.concat("The " + getAnimalType() + ", " + getName() + ", playfully bit you.\n");
        }
        return extraActivities;
    }
    @Override
    public String getAnimalType() {
        return "dog";
    }
    @Override
    public String toString() {
        return String.format("%s\t%s", getAnimalType(), super.toString());
    }
}
