package createaplayer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

public class PlayerFrame extends JFrame {
    // Variables
    private JLabel yourChoice;
    private JTextField enteredChoice;
    private JButton btnSubmit;
    private JButton btnNext;
    private Player player;
    private ArrayList myPlayers;
    private JTextArea screenMessage;
    // setupMenu method 
    public void setupMenu() {

    }

    // setupGUI method
    public void setupGUI() {
        setTitle("MyPlayer Creator");
        setBounds(250, 100, 800, 500);
        Container c = getContentPane();
        c.setBackground(Color.DARK_GRAY);
        c.setLayout(new BorderLayout());
        screenMessage = new JTextArea("Welcome to MyPlayer creator. Please select one of the options below to select your sport.");
        screenMessage.setSize(500, 100);
        screenMessage.setEditable(false);
        screenMessage.setFont(new Font("Impact", Font.PLAIN,15));
        c.add(screenMessage);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        yourChoice = new JLabel("Your choice: ");
        enteredChoice = new JTextField(3);
        btnSubmit = new JButton("Submit choice");
        btnNext = new JButton("Next");
        panSouth.add(yourChoice);
        panSouth.add(enteredChoice);
        panSouth.add(btnSubmit);
        panSouth.add(btnNext);
        c.add(panSouth, BorderLayout.SOUTH);
    }

    // Constructor
    public PlayerFrame () {
        //this.player = player;
        setupGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
