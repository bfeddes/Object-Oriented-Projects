package quizzy;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class QuizFrame extends JFrame{
    // Variables 
    Question question;

    // setupMenu method 
    public void setupMenu() {
        JMenuBar menuBar = new JMenuBar(); 
        setJMenuBar(menuBar);
        // Creating and adding File and Quiz menus
        JMenu menuFile = new JMenu("File");
        JMenu menuQuiz = new JMenu("Quiz");
        menuBar.add(menuFile);
        menuBar.add(menuQuiz);
        // Creating and adding the file and quiz menu items 
        JMenuItem fileLoad = new JMenuItem("Load questions");
        JMenuItem fileExit = new JMenuItem("Exit");
        JMenuItem quizStart = new JMenuItem("Start");
        JMenuItem quizStop = new JMenuItem("Stop");
        menuFile.add(fileLoad);
        menuFile.add(fileExit);
        menuQuiz.add(quizStart);
        menuQuiz.add(quizStop);
    }
    // setupGUI method 
    public void setupGUI() {
        setTitle("Object-Oriented Quiz Tool");
        setBounds(100,100,850,275);
        setupMenu();
    }
    // Constructor
    public QuizFrame(Question question) {
        this.question = question;
        setupGUI(); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
