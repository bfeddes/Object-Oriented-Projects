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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.Random;

public class QuizFrame extends JFrame{
    // Variables 
    private Question question;
    private ArrayList<Question> questionList;
    private JTextArea tarQuestion;
    private Random rnd = new Random();
    private int questionsAsked;
    private int questionsCorrect;
    private double quizScore;
    JLabel yourAnswer;
    JTextField txtAnswer;
    JButton btnSubmit;
    JButton btnNext;
    JMenuItem quizStop;
    // setupMenu method 
    public void setupMenu() {
        JMenuBar menuBar = new JMenuBar(); 
        setJMenuBar(menuBar);
        // Creating and adding File and Quiz menus
        JMenu menuFile = new JMenu("File");
        JMenu menuQuiz = new JMenu("Quiz");
        menuQuiz.setEnabled(false);
        menuBar.add(menuFile);
        menuBar.add(menuQuiz);
        // Creating and adding the file and quiz menu items 
        JMenuItem fileLoad = new JMenuItem("Load questions");
        JMenuItem exitApp = new JMenuItem("Exit");
        JMenuItem quizStart = new JMenuItem("Start");
        quizStop = new JMenuItem("Stop");
        menuFile.add(exitApp);
        menuQuiz.add(quizStart);
        menuQuiz.add(quizStop);

        // Action listeners
        // Exit app
        exitApp.addActionListener( // Exiting app
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Thanks for a great semester!\n Was a blast :)");
                    System.exit(0);
                }
            }
        );

        // Load questions option
        menuFile.add(fileLoad); 
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
                            menuQuiz.setEnabled(true);
                            quizStop.setEnabled(false);
                            repaint();
                        } else {
                            tarQuestion.setText("The questions could not be read. Please try again.");
                            repaint();
                        }
                    }
                }
            }
        );

        // Start quiz menu option
        quizStart.addActionListener( // Starting quiz
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    questionsCorrect = 0; // This will reset the answers if the user wants to take a second quiz
                    questionsAsked = 0; // This will reset the answers if the user wants to take a second quiz
                    question = questionList.get(rnd.nextInt(14));
                    tarQuestion.setText(question.toString());
                    quizStart.setEnabled(false);
                    fileLoad.setEnabled(false);
                    btnSubmit.setEnabled(true);
                    txtAnswer.setEnabled(true);
                    quizStop.setEnabled(false);
                    repaint();
                }
            }
        );

    // Stop quiz menu option 
    quizStop.addActionListener(
        new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                quizScore = ((double)questionsCorrect / questionsAsked) * 100;
                    JOptionPane.showMessageDialog(null, String.format("You answered %d out of %d correctly.\n That is a percent score of %.2f.",
                    questionsCorrect, questionsAsked, quizScore));
                    menuQuiz.setEnabled(true);
                    btnNext.setEnabled(false);
                    btnSubmit.setEnabled(false);
                    txtAnswer.setEnabled(false);
                    fileLoad.setEnabled(true);
                    quizStart.setEnabled(true);
                    quizStop.setEnabled(false);
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
        yourAnswer = new JLabel("Your answer: ");
        txtAnswer = new JTextField(3);
        btnSubmit = new JButton("Submit Answer");
        btnNext = new JButton("Next question");
        btnNext.setEnabled(false);
        btnSubmit.setEnabled(false);
        txtAnswer.setEnabled(false);
        panSouth.add(yourAnswer);
        panSouth.add(txtAnswer);
        panSouth.add(btnSubmit);
        panSouth.add(btnNext);
        c.add(panSouth,BorderLayout.SOUTH);

        // Next Question option
        btnNext.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    question = questionList.get(rnd.nextInt(14));
                    tarQuestion.setText(question.toString());
                    btnSubmit.setEnabled(true);
                    txtAnswer.setEnabled(true);
                    quizStop.setEnabled(true);
                    btnNext.setEnabled(false);
                    repaint();
                }
            }
        );

        // Submit answer button
        btnSubmit.addActionListener (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String answer = txtAnswer.getText();
                    questionsAsked += 1;
                    if (answer.equalsIgnoreCase(question.getAnswer())){
                        questionsCorrect += 1;
                        tarQuestion.setText(question + "\n\nCorrect. The correct answer is " + question.getAnswer());
                    } else {
                        tarQuestion.setText(question + "\n\nIncorrect. The correct answer is " + question.getAnswer());
                    }
                    btnSubmit.setEnabled(false);
                    btnNext.setEnabled(true);
                    txtAnswer.setText("");
                    txtAnswer.setEnabled(false);
                }
            }
        );
    }
    // Constructor
    public QuizFrame(Question question) {
        this.question = question;
        setupGUI(); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
