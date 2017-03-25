import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by G33 on 04/03/2017.
 */
public class SelectionMenu extends JPanel implements ActionListener {


    JLabel holder = new JLabel();
    int counter = 0;
    ImageIcon customImage;

    public SelectionMenu(Color color) {
        add(holder);
        this.setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter += 1;
        customImage = new ImageIcon("images/a" + counter + ".png");
        this.remove(holder);
        holder = new JLabel(customImage);
        add(holder);
        if (counter == 16) {
            counter = 0;
        }

        revalidate();
    }

    @Override
    public void paintComponent(Graphics g){

    }
}