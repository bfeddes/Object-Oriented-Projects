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
    public String getType() {
        return "Dog";
    }
    @Override
    public String toString() {
        return String.format("%s\t%s", getType(), super.toString());
    }
    
}
