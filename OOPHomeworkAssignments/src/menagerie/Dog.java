/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Dog Class
 */
package menagerie;
public class Dog extends Pet {

    public Dog(String name, int age, double weight){
        super(name, age, weight);
    }
    @Override
    public void animalCutoffs(){
        setEatProb(3);
        setSleepProb(10);
        setSeekAttProb(16);
    }
    @Override
    public String getAnimalType() {
        return "Dog";
    }
    @Override
    public String toString() {
        return String.format("%s\t%s", getAnimalType(), super.toString());
    }
}
