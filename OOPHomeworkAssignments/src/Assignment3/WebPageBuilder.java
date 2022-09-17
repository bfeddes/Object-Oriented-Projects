package Assignment3;
import java.util.Scanner;
public class WebPageBuilder 
{
/*
 * Brian Feddes
 * CPSC 24500 Fall 2022
 * Assignment 3 - Web Page Builder
 */
    public static void main(String[] args)
    {
        // Initializing sc using the Scanner class.
        Scanner sc = new Scanner(System.in);

        // The intro to the webpage.
        System.out.println("***************************************************");
        System.out.println("               WEBPAGE BUILDER V1.0                ");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("This application helps you build a besic web page\nby asking you a series of questions. Just answer\neach question, and I'll populate your new web page\nwith your responses.");

        // Prompting the user to enter their name
        System.out.print("What is your name? ");
        String name = sc.nextLine();

        // Prompting the user to enter their age
        System.out.print("How old are you? ");
        int age = sc.nextInt();
        sc.nextLine();
        // Prompting the user to enter where they live
        System.out.print("Where do you live? ");
        String location = sc.nextLine();

        // Asking the user what they want to be when they grow up
        System.out.print("When you grow up, you want to be ... ");
        String job = sc.nextLine();
        // Asking the user their two favoite integers
        System.out.print("What are your two favorite integers? ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        sc.nextLine();

        // Converting the user's age from years input above to months to be displayed below, as well as finding the individual's two favorite number's quotient.
        int yearsToMonths = (age * 12);
        double quotient = (num1 / num2);
        // Code for web page:
        System.out.println("Here is the code for your web page:");
        System.out.println("<html>");
        System.out.printf("<head><title>%s's Web Page</title</head>\n", name);
        System.out.println("<body>");
        System.out.printf("<h1>Welcome to %s's Web Page</h1>\n", name);
        System.out.printf("<p>I am %d years (or %d months!) old and live in %s.</p>\n", age, yearsToMonths, location);
        System.out.printf("<p>When I grow up, I want to be a %s.</p>\n", job);
        System.out.printf("My two favorite integers are %d and %d. Their quotient is %.3f.</p>\n", (int)num1, (int)num2, quotient);
        System.out.println("<p>Thank you for visiting my page!</p>");
        System.out.println("</body>");
        System.out.println("</html>");


    }
    
}
