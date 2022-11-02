/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Pet Class
 */
package menagerie;
/*TO-DO:
 * Add info to setters.
 * Declare a Random number generator object that will function as the pet's brain deciding what it will do each hour.
 * Create int variables that are used to determine whether the pet will eat, sleep, or seek attention. (similar to the storyteller thing i created)
 * Add constructors 
 * Add a ToString function.
 * Must have an abstract getType() function that returns a String that indicates what type of animal it is.
 * Create functions to indicate whether it is eating, sleeping, or seeking attention by comparing a randomly generated number against the eat, sleep, and attention behavior cutoffs.
 * Above functions must be called during the simulation for each hour of the day.
 * Pet class must also have an abstract function called act() that subclasses will implement to choose among a variety of tasks specific to that kind of pet.
 */

public abstract class Pet {
    // Variables/features all pets have
    private String name;
    private int age;
    private double weight;
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
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
}
