package CircleCalc;
import java.util.Random;
public class CircleCalc {

	public static void main(String[] args) {
		
		// Creates a random number between 0 and 50.
		Random radius = new Random();
		
		int radiusOfCircle = radius.nextInt(51);
		// Selects a random radius from 0-50.
		System.out.println("The randomly selected radius was " + radiusOfCircle);
		
		// Calculating Circumference of the circle .
		double circumferenceOfCircle = (2*Math.PI*radiusOfCircle);
		System.out.println("The circumference of a circle with radius " + radiusOfCircle + " is " + circumferenceOfCircle);
		
		// Calculating the area of the circle.
		double areaOfCircle = (Math.PI*(radiusOfCircle*radiusOfCircle));
		System.out.println("The area of a circle with radius " + radiusOfCircle + " is " + areaOfCircle);


	}

}