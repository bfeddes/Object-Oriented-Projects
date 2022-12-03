package quizzy;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class QuestionsReader {
    public static ArrayList<Question> readFromTextFile(String fileName, Question question) {
        return readFromTextFile(new File(fileName), question);
    }
    
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
                if (parts.length < 6) {
                    questionText = parts[0];
                    optA = parts[1];
                    optB = parts[2];
                    optC = parts[3]; 
                    answer = parts[4];
                    question = new Question(questionText, answer, optA, optB, optC);
                    questions.add(question);
                } else {            
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
        } catch (Exception e) {
            System.out.println("Could not read questions in.");
            return null;
        }
    }
}
