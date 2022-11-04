/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, Fish Class
 */
package menagerie;

public class Fish extends Pet{



    @Override
    public String getType() {
        return "Fish";
    }
    @Override
    public String toString() {
        return String.format("%s\t%s", getType(), super.toString());
    }
}
