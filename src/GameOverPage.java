import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPage extends JFrame implements ActionListener {

    ImageIcon gameIcon = new ImageIcon("C:\\Users\\farou\\IdeaProjects\\Hangman\\Game Image Icon.png");
    JLabel label = new JLabel("Game Over");
    JLabel answerLabel = new JLabel();
    JButton playAgain = new JButton("Play Again");
    JButton exitButton = new JButton("Exit");
    JButton homeButton = new JButton("Home");

    GameOverPage(String answer){

        label.setBounds(250, 120, 700, 200);
        label.setFont(new Font("Arial", Font.BOLD, 50));

        answerLabel.setText("The answer was: " + answer + "!");
        answerLabel.setBounds(250, 250, 500, 50);
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 25));

        playAgain.setBounds(350, 350, 100, 25);
        playAgain.setFocusable(false);
        playAgain.addActionListener(this);

        homeButton.setBounds(350, 390, 100, 25);
        homeButton.setFocusable(false);
        homeButton.addActionListener(this);

        exitButton.setBounds(350, 430, 100, 25);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Hangman");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(800, 540);
        this.setLocationRelativeTo(null);
        this.setIconImage(gameIcon.getImage());
        this.add(label);
        this.add(answerLabel);
        this.add(playAgain);
        this.add(homeButton);
        this.add(exitButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playAgain){
            new GamePage();
            this.dispose();
        }
        if(e.getSource() == homeButton){
            new HomePage();
            this.dispose();
        }
        if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
}
