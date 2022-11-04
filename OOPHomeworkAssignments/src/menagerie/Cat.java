/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Cat Class
 */
package menagerie;

public class Cat extends Pet {


    @Override
    public String getType() {
        return "Cat";
    }
    @Override
    public String toString() {
        return String.format("%s\t%s", getType(), super.toString());
    }
    
}
