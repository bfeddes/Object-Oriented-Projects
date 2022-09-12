package Flooring;

public class App {
    public static void main(String[] args) {
        // floor board dimensons: 24 inches long 6 inches widde. Therefore dimensions in feet: 2 long .5 wide
        // The boards come in packages of 8. So 8 * the 24 inches by 6 inches for coverage area.
        // Each package costs $24.99. So if we need 8 packages, the cost would be $199.92
        // Will have to purchase an extra 25% of flooring to cover the area. That is 1.25 * the initial area.
        // Dimensions shown in feet, board sizes are shown in inches. Convert inches to feet.
        // Can only purchase packages in groups of 8.
        System.out.println("Working on the assignment. Last worked on 9/12 1:50 PM");

        // Calculating the areas of the 3 rectangles and 1 right triangle:

        int areaOfRectangle1 = (8*15);
        int areaOfRectangle2 = (7*9);
        int areaOfRectangle3 = (8*7);
        double areaOfTriangle = (0.5*(9*8));

        // Calculating the area of the room and printing it.
        double areaOfRoom = (areaOfRectangle1 + areaOfRectangle2 + areaOfRectangle3 + areaOfTriangle);
        System.out.println("The area of the room is: " + (int)areaOfRoom + " square feet.");

        //Computing the number of packages needed. Include the 25% extra.
        // Note: Each package comes with 8 boards. Each board is 2 feet long, 0.5 feet wide.
        double boardDimensions = 1; // Each board will take up 1 square foot, as l * w of a board is 2 * 0.5.
        double packageSize = (boardDimensions*8); //The total amount of area one package can cover.
        // Calculating the number of packages that will be needed to cover the floor. + the 25% extra.
        double numOfPackages = ((areaOfRoom/packageSize)*1.25);
        // Rounding the amount of packages up.
        double roundNumOfPackages = (numOfPackages + 1);
        System.out.println("The number of packages needed is: " + (int)roundNumOfPackages);

        // Calculating the total price of the packages. Price per package = $24.99
        double priceOfPackages = (roundNumOfPackages * 24.99);
        // MAKE THIS ROUNDED TO 2 DECIMAL POINTS
        System.out.printf("The total price for %.0f packages is $%.2f.",roundNumOfPackages, priceOfPackages);








    }
    
}
