import javax.swing.*;
import java.awt.*;

public class HangmanPanel extends JPanel {

    JLabel label = new JLabel();
    boolean drawHead = false;
    boolean drawBody = false;
    boolean drawRightArm = false;
    boolean drawLeftArm = false;
    boolean drawRightLeg = false;
    boolean drawLeftLeg = false;
    HangmanPanel() {
        ImageIcon originalImageIcon = new ImageIcon("C:\\Users\\farou\\IdeaProjects\\Hangman\\face.png");
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

        label.setBounds(500, 0, 80, 80);
        label.setIcon(resizedImageIcon);

        this.setLayout(null);
        //this.add(label);
        this.setBounds(0, 150, 800, 200);
    }

    public void setDrawHead(boolean drawHead) {
        this.drawHead = drawHead;
    }

    public void setDrawBody(boolean drawBody) {
        this.drawBody = drawBody;
    }

    public void setDrawRightArm(boolean drawRightArm) {
        this.drawRightArm = drawRightArm;
    }

    public void setDrawLeftArm(boolean drawLeftArm) {
        this.drawLeftArm = drawLeftArm;
    }

    public void setDrawRightLeg(boolean drawRightLeg) {
        this.drawRightLeg = drawRightLeg;
    }

    public void setDrawLeftLeg(boolean drawLeftLeg) {
        this.drawLeftLeg = drawLeftLeg;
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        g.drawLine(200, 0, 200, 350);
        g.drawLine(200, 0, 350, 0);
        g.drawLine(350, 0, 350, 25);
        if(drawHead){
            g.drawOval(325, 25, 50, 50);
        }
        if(drawBody){
            g.drawLine(350, 75, 350, 150);
        }
        if(drawRightArm){
            g.drawLine(350, 85, 385, 115);
        }
        if(drawLeftArm){
            g.drawLine(350, 85, 315, 115);
        }
        if(drawLeftLeg){
            g.drawLine(350, 140, 315, 170);
        }
        if(drawRightLeg){
            g.drawLine(350, 140, 385, 170);
        }
    }
}
