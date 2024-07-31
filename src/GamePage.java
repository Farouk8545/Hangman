import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePage extends JFrame implements ActionListener {

    String[] words = {
            "APPLE", "BANANA", "ORANGE", "GRAPE", "MELON",
            "CHERRY", "BERRY", "PEACH", "LEMON", "LIME",
            "KIWI", "MANGO", "PEAR", "PLUM", "FIG",
            "DATE", "WATER", "JUICE", "BREAD", "BUTTER",
            "CHEESE", "MILK", "CREAM", "HONEY", "JAM",
            "EGG", "PASTA", "PIZZA", "SALAD", "SOUP",
            "RICE", "BEANS", "CHICKEN", "MEAT", "FISH",
            "SUGAR", "SALT", "PEPPER", "ONION", "GARLIC",
            "POTATO", "TOMATO", "CARROT", "CUCUMBER", "PEPPER",
            "LETTUCE", "SPINACH", "BROCCOLI", "CABBAGE", "PEAS"
    };
    String[] hints = {
            "A fruit, usually red or green, small to medium size.",
            "A fruit, yellow, long and curved.",
            "A fruit, orange in color, medium size.",
            "A fruit, purple or green, small and round.",
            "A fruit, green or yellow, large and round.",
            "A fruit, red, small, often used in desserts.",
            "A fruit, small, varies in color from blue to red.",
            "A fruit, orange or pink, small to medium size.",
            "A fruit, yellow, small to medium size.",
            "A fruit, green, small.",
            "A fruit, brown on the outside, green inside, small.",
            "A fruit, yellow-orange, medium size.",
            "A fruit, green or yellow, small to medium size.",
            "A fruit, purple or yellow, small.",
            "A fruit, purple or green, very small.",
            "A fruit, brown, small.",
            "A liquid, clear, essential for life.",
            "A liquid, varies in color, often sweet.",
            "A food, beige, often used in sandwiches.",
            "A food, yellow, spreadable.",
            "A food, yellow or white, dairy product.",
            "A liquid, white, dairy product.",
            "A food, white, thick and spreadable.",
            "A food, golden, sweet and viscous.",
            "A food, varies in color, sweet and spreadable.",
            "A food, oval, white or brown shell, small.",
            "A food, varies in shape, often used in Italian dishes.",
            "A food, round, often topped with cheese and tomato.",
            "A food, green or mixed colors, often leafy.",
            "A food, liquid, varies in color and ingredients.",
            "A food, small grains, often white or brown.",
            "A food, small, often green or brown.",
            "A meat, often white, versatile in cooking.",
            "A meat, red or white, varies in cut.",
            "A meat, varies in color, found in the sea.",
            "A food, white, crystalline, sweet.",
            "A food, white, crystalline, savory.",
            "A spice, black or white, often ground.",
            "A vegetable, white or red, round.",
            "A vegetable, white, aromatic.",
            "A vegetable, brown or yellow, tuber.",
            "A vegetable, red or yellow, round.",
            "A vegetable, orange, long and thin.",
            "A vegetable, green, long and cylindrical.",
            "A vegetable, varies in color, often spicy.",
            "A vegetable, green, leafy.",
            "A vegetable, green, leafy and nutritious.",
            "A vegetable, green, tree-like.",
            "A vegetable, green or purple, leafy.",
            "A vegetable, green, small and round."
    };
    Random rand = new Random();
    JPanel panel = new JPanel();
    HangmanPanel myPanel = new HangmanPanel();
    String letter;
    String letters = "QWERTYUIOPASDFGHJKL ZXCVBNM";
    JButton[] buttons = new JButton[27];
    JLabel[] labels;
    JTextArea hintsText = new JTextArea();
    int i = rand.nextInt(words.length);
    int mistakes = 1;
    int counter = 0;
    ImageIcon gameIcon = new ImageIcon("C:\\Users\\farou\\IdeaProjects\\Hangman\\Game Image Icon.png");
    GamePage(){

        panel.setLayout(new FlowLayout());
        panel.setBounds(150, 400, 500, 100);
        panel.setBackground(Color.BLACK);

        labels = new JLabel[words[i].length()];
        for(int j = 0; j < words[i].length(); j++){
            labels[j] = new JLabel("_");
            labels[j].setBounds(j*30+30, 30, 20, 30);
            labels[j].setForeground(Color.WHITE);
            labels[j].setOpaque(true);
            labels[j].setBackground(Color.BLACK);
            labels[j].setFont(new Font("Arial", Font.PLAIN, 24));
            this.add(labels[j]);
        }

        hintsText.setLayout(new FlowLayout());
        hintsText.setBounds(450, 20, 300, 50);
        hintsText.setText("Hint: " + hints[i]);
        hintsText.setFont(new Font("Arial", Font.PLAIN, 15));
        hintsText.setEditable(false);
        hintsText.setFocusable(false);
        hintsText.setOpaque(false);

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(String.valueOf(letters.charAt(i)));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            panel.add(buttons[i]);
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Hangman");
        this.setSize(800, 540);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(gameIcon.getImage());
        this.add(panel);
        this.add(myPanel);
        this.add(hintsText);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean found = false;
        for(int c = 0; c < buttons.length; c++){
            if(e.getSource() == buttons[c]){
                letter = String.valueOf(letters.charAt(c));
                buttons[c].setEnabled(false);
                for(int j = 0; j < words[i].length(); j++) {
                    if (letter.equals(String.valueOf(words[i].charAt(j)))){
                        labels[j].setText(letter);
                        found = true;
                        counter++;
                    }
                }
            }
        }
        if(!found){
            switch (mistakes){
                case 1:
                    myPanel.setDrawHead(true);
                    myPanel.repaint();
                    break;
                case 2:
                    myPanel.setDrawBody(true);
                    myPanel.repaint();
                    break;
                case 3:
                    myPanel.setDrawRightArm(true);
                    myPanel.repaint();
                    break;
                case 4:
                    myPanel.setDrawLeftArm(true);
                    myPanel.repaint();
                    break;
                case 5:
                    myPanel.setDrawRightLeg(true);
                    myPanel.repaint();
                    break;
                case 6:
                    myPanel.setDrawLeftLeg(true);
                    myPanel.repaint();
                    new GameOverPage(words[i]);
                    this.dispose();
            }
            mistakes++;
        }
        if(counter == words[i].length()){
            new WinPage(words[i]);
            this.dispose();
        }
    }
}