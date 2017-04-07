import javax.swing.*;
import java.awt.*;

/**
 * Created by G33 on 04/03/2017.
 */
public class Frame extends JFrame {

    public Frame() {

        this.setSize(new Dimension(850, 650));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("images/1.png").getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addPanel(JPanel panel){
        this.getContentPane().add(panel);
        this.setTitle(panel.getName());
        this.setVisible(true);
    }
}
