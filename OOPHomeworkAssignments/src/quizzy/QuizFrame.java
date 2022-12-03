package quizzy;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Graphics;

public class QuizFrame extends JFrame{
    // Variables 
    private Question question;

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
        exitApp.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            }
        );
        menuFile.add(fileLoad);
        fileLoad.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JFileChooser fileChoice = new JFileChooser(); 
                    File fileName;
                    if (fileChoice.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        fileName = fileChoice.getSelectedFile();
                        if (QuestionsReader.readFromTextFile(fileName, question) != null) {
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "Could not read question.");
                        }
                    }
                }
            }
        );
        menuFile.add(fileLoad);
    }
    // setupGUI method 
    public void setupGUI() {
        setTitle("Object-Oriented Quiz Tool");
        setBounds(100,100,850,275);
        setupMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JTextArea welcomeMessage = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\nSelect File >> Load Questions to begin.");
        welcomeMessage.setEditable(false);
        c.add(welcomeMessage);
    }
    // Constructor
    public QuizFrame(Question question) {
        this.question = question;
        setupGUI(); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
