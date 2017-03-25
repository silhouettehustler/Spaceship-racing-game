import javax.swing.*;

/**
 * Created by G33 on 24/03/2017.
 */
public class Manager {

    public static Frame frame = new Frame(); // Main Frame


    public static void main(String[] args){
        Arena arena = new Arena();
        frame.addPanel(arena);
        frame.setVisible(true);
        frame.addKeyListener(arena);
        Timer timer = new Timer(10,arena);
        timer.start();
    }
}
