package quizzy;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class QuestionsReader {
    // Method to read in the questions from the question file
    public static ArrayList<Question> readFromTextFile(File fileName, Question question) {
        try {
            ArrayList<Question> questions = new ArrayList<Question>();
            Scanner fsc = new Scanner(fileName);
            String line; 
            String[] parts; 
            String questionText, answer, optA, optB, optC, optD;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                parts = line.split("\t");
                if (parts.length < 6) { // If the parts is less than 6, ex: does not include option D, it will create a question without D as an option
                    questionText = parts[0];
                    optA = parts[1];
                    optB = parts[2];
                    optC = parts[3]; 
                    answer = parts[4];
                    question = new Question(questionText, answer, optA, optB, optC);
                    questions.add(question);
                } else { // If it does have D, it will include D as an option here. I would change this if there were true/false options etc, but for this program this does the trick
                    questionText = parts[0];
                    optA = parts[1];
                    optB = parts[2];
                    optC = parts[3]; 
                    optD = parts[4];
                    answer = parts[5];
                    question = new Question(questionText, answer, optA, optB, optC, optD);
                    questions.add(question);
                }
            }
            fsc.close();
            return questions;
        } catch (Exception e) { // Will print this in the terminal if there is an error. tarQuestion message that will post in the panel if it isn't read correctly
            System.out.println("Could not read questions in.");
            return null;
        }
    }
}
