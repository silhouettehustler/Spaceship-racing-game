import javax.swing.*;
import java.awt.*;

/**
 * Created by G33 on 04/03/2017.
 */
public class Frame extends JFrame {

    public Frame(JPanel panel) {
        this.setSize(new Dimension(850, 650));
        this.getContentPane().add(panel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Spaceship Selection Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Show() {
        this.setVisible(true);
    }


}
