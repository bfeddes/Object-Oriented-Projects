package cellphoneassignment.testingarea;
import java.util.Scanner;
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Variables
        String initialString = "";
        int cost1 = 500;
        int cost2 = 750;
        int cost3 = 1000;
        int iterationNum = 0;

        System.out.print("Enter how many times you want the loop to go for: ");
        int userNum  = sc.nextInt();
    do{
        iterationNum += 1;
        initialString = initialString + cost1;
        System.out.println(initialString);
    } while(iterationNum < userNum);
    System.out.println(initialString);
}
}
