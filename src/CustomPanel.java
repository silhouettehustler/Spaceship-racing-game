import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by G33 on 04/03/2017.
 */
public class CustomPanel extends JPanel implements ActionListener {


    JLabel holder = new JLabel();
    int counter = 0;
    ImageIcon customImage;

    public CustomPanel() {
        add(holder);
        this.setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter += 1;
        customImage = new ImageIcon("images/black-ship-" + counter + ".png");
        this.remove(holder);
        holder = new JLabel(customImage);
        add(holder);
        if (counter == 16) {
            counter = 0;
        }

        revalidate();

    }
}
