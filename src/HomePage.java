import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    ImageIcon originalIcon = new ImageIcon("C:\\Users\\farou\\IdeaProjects\\Hangman\\Home page photo.jpg");
    Image originalImage = originalIcon.getImage();
    Image scaledImage = originalImage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    ImageIcon gameIcon = new ImageIcon("C:\\Users\\farou\\IdeaProjects\\Hangman\\Game Image Icon.png");
    JLabel welcomeLabel = new JLabel(scaledIcon);
    JButton playButton = new JButton("Play");
    JButton exitButton = new JButton("Exit");

    HomePage(){

        playButton.setBounds(350, 350, 100, 25);
        playButton.setFocusable(false);
        playButton.addActionListener(this);

        exitButton.setBounds(350, 390, 100, 25);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        welcomeLabel.setText("Welcome to Hangman!");
        welcomeLabel.setBounds(200, 0, 400, 300);
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setVerticalTextPosition(JLabel.TOP);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        this.setTitle("Hangman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 540);
        this.setLocationRelativeTo(null);
        this.setIconImage(gameIcon.getImage());
        this.add(welcomeLabel);
        this.add(playButton);
        this.add(exitButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playButton){
            new GamePage();
            this.dispose();
        }
        if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
}
