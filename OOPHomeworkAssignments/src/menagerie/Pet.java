/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Pet Class
 */
package menagerie;
import java.util.Random;

public abstract class Pet implements Comparable<Pet> {
    // Variables/features all pets have
    private String name;
    private int age;
    private double weight;
    private Random rnd;
    private int eatProb;
    private int sleepProb;
    private int seekAttProb;

    // Getters and setters
    public int getEatProb() {
        return eatProb;
    }
    public void setEatProb(int eatProb) {
        this.eatProb = eatProb;
    }
    public int getSleepProb() {
        return sleepProb;
    }
    public void setSleepProb(int sleepProb) {
        this.sleepProb = sleepProb;
    }
    public int getSeekAttProb() {
        return seekAttProb;
    }
    public void setSeekAttProb(int seekAttProb) {
        this.seekAttProb = seekAttProb;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0) {
            age = 0;
        } else {
        this.age = age;
        }
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        if (weight < 0) {
            weight = 0;
        }else {
        this.weight = weight;
        }
    }
    public Random getRnd() {
        return rnd;
    }
    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }
    // Functions to determine if the pet is sleeping, needs food, or needs attention
    public boolean needsFood() {
        if (getEatProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean needsSleep() {
        if (getSleepProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean needsAtt() {
        if (getSeekAttProb() > rnd.nextInt(24)) {
            return true;
        } else {
            return false;
        }
    }
    // Act function: This will return a String explaining everything the pet has done since the last time it was called. 
    public String act() {
        String hourlyActivities = "";
        if (needsFood()){
            hourlyActivities = hourlyActivities.concat("The " + getAnimalType() + ", " + getName() + ", was hungry and ate.\n"); 
        } 
        if (needsAtt()){
             hourlyActivities = hourlyActivities.concat("The " + getAnimalType() + ", " + getName() + ", sought your attention.\n"); 
        }
        if (needsSleep()){
            hourlyActivities = hourlyActivities.concat("The " + getAnimalType() + ", " + getName() + ", was sleepy and took a nap.\n"); 
        }
        return hourlyActivities;
    }
    // Default constructor
    public Pet(){
        name = "";
        age = 0;
        weight = 0;
    }
    // Nondefault constructor 
    public Pet (String name, int age, double weight){
        setName(name);
        setAge(age);
        setWeight(weight);
        rnd = new Random();
    }
    // Abstract classes
    public abstract String getAnimalType();
    public abstract void animalCutoffs();
    // toString method
    @Override
    public String toString() {
        // Had to add some more room for names in case someone enters an excessively long name.
        return String.format("%s\t%d\t%.2f", name, age, weight);
    }
    // compareTo method
    @Override 
    public int compareTo(Pet other){
        String myPetName = name;
        String otherPetName = other.name;
        return myPetName.compareTo(otherPetName);
    }
}
