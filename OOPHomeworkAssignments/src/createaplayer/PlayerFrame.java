package createaplayer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerFrame extends JFrame {
    // Variables
    private JLabel yourChoice;
    private JTextField enteredChoice;
    private JButton btnSubmit;
    private JButton btnNext;
    private Player player;
    private ArrayList myPlayers;
    private JLabel screenMessage;
    // setupMenu method 
    public void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File");
        JMenu mnuMyPlayer = new JMenu("MyPlayer");
        mbar.add(mnuFile);
        mbar.add(mnuMyPlayer);
        JMenuItem mnuSave = new JMenuItem("Save MyPlayers");
        JMenuItem mnuLoad = new JMenuItem("Load Players");
        JMenuItem mnuExit = new JMenuItem("Exit");
        mnuFile.add(mnuSave);
        mnuFile.add(mnuLoad);
        mnuFile.add(mnuExit);
        JMenuItem mnuCreatePlayer = new JMenuItem("Create a MyPlayer");
        JMenuItem mnuDeletePlayer = new JMenuItem("Delete a MyPlayer");
        mnuMyPlayer.add(mnuCreatePlayer);
        mnuMyPlayer.add(mnuDeletePlayer);
        mnuExit.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "We hope you enjoyed!");
                    System.exit(0);
                }
            }
        );
        
        // Checking if there are any players to delete, if not, delete option will not be enabled 
        if (myPlayers == null) {
            mnuDeletePlayer.setEnabled(false);
        } else {
            mnuDeletePlayer.setEnabled(true);
        }
    }

    // setupGUI method
    public void setupGUI() {
        setupMenu();
        setTitle("MyPlayer Creator");
        setBounds(250, 100, 800, 500);
        Container c = getContentPane();
        c.setBackground(Color.DARK_GRAY);
        c.setLayout(new BorderLayout());
        screenMessage = new JLabel("<html> Welcome to MyPlayer creator!<br/>Please select the sport you would like to create a player in from the options below</html>");
        screenMessage.setFont(new Font("Elephant", Font.PLAIN, 16));
        screenMessage.setForeground(Color.WHITE);
        c.add(screenMessage);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        yourChoice = new JLabel("Your choice: ");
        enteredChoice = new JTextField(3);
        btnSubmit = new JButton("Submit choice");
        btnNext = new JButton("Next");
        btnNext.setEnabled(false);
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
