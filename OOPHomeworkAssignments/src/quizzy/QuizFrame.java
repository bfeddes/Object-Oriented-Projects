package quizzy;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.Random;

public class QuizFrame extends JFrame{
    // Variables 
    private Question question, askedQuestion;
    private ArrayList<Question> questionList;
    private JTextArea tarQuestion;
    private Random rnd = new Random();
    private int questionsAsked;
    private int questionsCorrect;

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
        JMenuItem exitApp = new JMenuItem("Exit");
        JMenuItem quizStart = new JMenuItem("Start");
        JMenuItem quizStop = new JMenuItem("Stop");
        menuFile.add(exitApp);
        menuQuiz.add(quizStart);
        menuQuiz.add(quizStop);

        // Action listeners
        quizStart.addActionListener( // Starting quiz
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    question = questionList.get(rnd.nextInt(14));
                    tarQuestion.setText(question.toString());
                    repaint();
                }
            }
        );
        exitApp.addActionListener( // Exiting app
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    System.exit(0);
                }
            }
        );
        menuFile.add(fileLoad); // Loading the file of questions
        fileLoad.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JFileChooser fileChoice = new JFileChooser(); 
                    File fileName;
                    if (fileChoice.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        fileName = fileChoice.getSelectedFile();
                        if (QuestionsReader.readFromTextFile(fileName, question) != null) {
                            questionList = QuestionsReader.readFromTextFile(fileName, question);
                            tarQuestion.setText("The questions have been read. Select Quiz >> Start to begin. ");
                            repaint();
                        } else {
                            tarQuestion.setText("The questions could not be read. Please try again.");
                            repaint();
                        }
                    }
                }
            }
        );
    }
    // setupGUI method 
    public void setupGUI() {
        setTitle("Object-Oriented Quiz Tool");
        setBounds(100,100,850,275);
        setupMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        tarQuestion = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\nSelect File >> Load Questions to begin.");
        tarQuestion.setEditable(false);
        c.add(tarQuestion);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JLabel yourAnswer = new JLabel("Your answer: ");
        JTextField txtAnswer = new JTextField(3);
        JButton btnSubmit = new JButton("Submit Answer");
        JButton btnNext = new JButton("Next question");
        btnSubmit.setEnabled(false);
        btnNext.setEnabled(false);
        panSouth.add(yourAnswer);
        panSouth.add(txtAnswer);
        panSouth.add(btnSubmit);
        panSouth.add(btnNext);
        c.add(panSouth,BorderLayout.SOUTH);
    }
    // Constructor
    public QuizFrame(Question question) {
        this.question = question;
        setupGUI(); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
