package flooring;

public class App {
    public static void main(String[] args) {
        // Brian Feddes Flooring Assignment CPSC 25000

        // Calculating the areas of the 3 rectangles and 1 right triangle

        int areaOfRectangle1 = (8*15);
        int areaOfRectangle2 = (7*9);
        int areaOfRectangle3 = (8*7);
        double areaOfTriangle = (0.5*(9*8));

        // Calculating the area of the room and printing it.
        double areaOfRoom = (areaOfRectangle1 + areaOfRectangle2 + areaOfRectangle3 + areaOfTriangle);
        System.out.println("The area of the room is: " + (int)areaOfRoom + " square feet.");

        // Note: Each package comes with 8 boards. Each board is 2 feet long, 0.5 feet wide.
        double boardDimensions = 1; // Each board will take up 1 square foot. 
        double packageSize = (boardDimensions*8); 

        // Calculating the number of packages that will be needed to cover the floor. Includes the 25% extra.
        double numOfPackages = (areaOfRoom/packageSize)*(1.25);
        // Rounding the amount of packages up.
        numOfPackages = Math.ceil(numOfPackages);
        System.out.println("The number of packages needed is: " + (int)numOfPackages);

        // Calculating the total price of the packages. Price per package = $24.99
        double priceOfPackages = ((numOfPackages * 24.99));
        // MAKE THIS ROUNDED TO 2 DECIMAL POINTS
        System.out.printf("The total price for %.0f packages is $%.2f",numOfPackages, priceOfPackages);


    }
    
}
