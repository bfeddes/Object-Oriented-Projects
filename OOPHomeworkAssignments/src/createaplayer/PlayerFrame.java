package createaplayer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class PlayerFrame extends JFrame {
    // Variables
    private JLabel yourChoice;
    private JTextField enteredChoice;
    private JButton btnSubmit;
    private JButton btnNext;
    private Player player;
    private ArrayList<Player> myPlayers;
    private JTextArea screenMessage;
    // setupMenu method 
    public void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File");
        JMenu mnuMyPlayer = new JMenu("MyPlayer");
        mbar.add(mnuFile);
        mbar.add(mnuMyPlayer);
        JMenuItem mnuSaveText = new JMenuItem("Save MyPlayers to txt");
        JMenuItem mnuLoadText = new JMenuItem("Load Players to txt");
        JMenuItem mnuSaveBin = new JMenuItem("Save MyPlayers to binary");
        JMenuItem mnuLoadBin = new JMenuItem("Load Players to binary");
        JMenuItem mnuExit = new JMenuItem("Exit");
        mnuFile.add(mnuSaveText);
        mnuFile.add(mnuLoadText);
        mnuFile.add(mnuSaveBin);
        mnuFile.add(mnuLoadBin);
        mnuFile.add(mnuExit);
        JMenuItem mnuCreatePlayer = new JMenuItem("Create a MyPlayer");
        JMenuItem mnuDeletePlayer = new JMenuItem("Delete a MyPlayer");
        mnuMyPlayer.add(mnuCreatePlayer);
        mnuMyPlayer.add(mnuDeletePlayer);

        mnuSaveBin.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    File fileName;
                    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        fileName = fileChooser.getSelectedFile();
                        if (PlayerWriter.writeToBinary(fileName, myPlayers)) {
                            JOptionPane.showMessageDialog(null, "Your myPlayers were saved!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Could not save your myPlayers.\nPlease try again.");
                        }
                    }
                }
            }
        );

        mnuLoadBin.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    File fileName;
                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        fileName = fileChooser.getSelectedFile();
                        if (PlayerReader.readFromBinary(fileName, myPlayers)) {
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "Could not read in MyPlayers");
                        }
                    }
                }
            }
        );
        mnuLoadText.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    File fileName;
                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        fileName = fileChooser.getSelectedFile();
                        if (PlayerReader.readFromText(fileName, myPlayers)) {
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "Could not read in MyPlayers");
                        }
                    }
                }
            }
        );
        mnuExit.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "We hope you enjoyed!");
                    System.exit(0);
                }
            }
        );
        mnuCreatePlayer.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    screenMessage.setText("Please select your player's sport from the list of options below:\n\nA. Baseball\nB. Basketball\nC. Football");
                    repaint();

                }
            }
        );

        mnuSaveText.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    File fileName;
                    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        fileName = fileChooser.getSelectedFile();
                        if (PlayerWriter.writeToText(myPlayers, fileName)) {
                            JOptionPane.showMessageDialog(null, "Your myPlayers were saved!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Could not save your myPlayers.\nPlease try again.");
                        }
                    }
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
        screenMessage = new JTextArea("Welcome to MyPlayer creator!\nClick on the MyPlayer tab --> Create a MyPlayer to create a new player\nOr click on File tab and select Load Players to load in previous MyPlayer builds");
        screenMessage.setFont(new Font("Elephant", Font.PLAIN, 16));
        screenMessage.setForeground(Color.BLACK);
        screenMessage.setEditable(false);
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

        // Action Listeners
        btnSubmit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            }
        );
    }

    // Constructor
    public PlayerFrame () {
        //this.player = player;
        setupGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
