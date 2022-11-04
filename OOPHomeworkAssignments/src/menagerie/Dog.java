/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Dog Class
 */
package menagerie;
public class Dog extends Pet {
    private int dogSleeps;
    private int dogEats;
    private int dogSeeksAtt;


    public int getDogSleeps() {
        return dogSleeps;
    }
    public void setDogSleeps(int dogSleeps) {
        this.dogSleeps = dogSleeps;
    }
    public int getDogEats() {
        return dogEats;
    }
    public void setDogEats(int dogEats) {
        this.dogEats = dogEats;
    }
    public int getDogSeeksAtt() {
        return dogSeeksAtt;
    }
    public void setDogSeeksAtt(int dogSeeksAtt) {
        this.dogSeeksAtt = dogSeeksAtt;
    }
    public Dog(String name, int age, double weight){
        super(name, age, weight);
        setDogEats(10);
        setDogSleeps(3);
        setDogSeeksAtt(9);
    }
    @Override
    public String getAnimalType() {
        return "Dog";
    }
    @Override 
    public String act() {
        getDogEats();
        if (getDogEats() > getPetBrain()){
            return "The dog has decided to eat.";
        } else {
            return "The dog is bored.";
        }
    }
    @Override
    public String toString() {
        return String.format("%s\t%s\n%s", getAnimalType(), super.toString(), act());
    }
    
}
