/* Brian Feddes
 * Professor Klump
 * Object-Oriented Programming
 * Fall 2022
 * Menagerie Assignment, PetReader Class
 */
package menagerie;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class PetReader {
    public static ArrayList<Pet> readPetsFromText(String fileName) {
        try {
            ArrayList<Pet> allAnimals = new ArrayList<Pet>();
            Scanner fsc = new Scanner(new File(fileName));
            String line, name, petType; 
            int age;
            double weight;
            Dog d;
            Cat c;
            Fish f;
            String[] parts;
            // Note: parts[0] will get the type of animal (dog, cat, fish); parts[1] will get the name; parts[2] will get the age; parts[3] will get the weight
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                parts = line.split("\t");
                petType = parts[0];
                name = parts[1];
                age = Integer.parseInt(parts[2]);
                weight = Double.parseDouble(parts[3]);
                // Checking if it is a dog adding it to the ArrayList of all animals
                if (petType.equalsIgnoreCase("dog")) {
                    d = new Dog(name, age, weight);
                    allAnimals.add(d);
                    // Checking if it is a cat adding it to the ArrayList of all animals
                } else if (petType.equalsIgnoreCase("cat")) {
                    c = new Cat(name, age, weight);
                    allAnimals.add(c);
                    // Checking if it is a fish and adding it to the ArrayList of all animals
                } else if (petType.equalsIgnoreCase("fish")) {
                    f = new Fish(name, age, weight);
                    allAnimals.add(f);
                }
            }
            fsc.close();
            return allAnimals;
        } catch (Exception ex) {
            return null;
        }
    }
}
