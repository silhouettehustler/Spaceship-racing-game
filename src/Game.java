import javax.swing.*;

/**
 * Created by G33 on 28/03/2017.
 */
public class Game {

    public static void main(String[] args){

        //Initialize frame and panel
        Frame frame = new Frame();
        Panel panel = new Panel();

        //add panel to the frame
        frame.addPanel(panel);
        frame.addKeyListener(panel);
        panel.requestFocus();

        //initialize timer and start it
        Timer timer = new Timer(80,panel);
        timer.start();

    }
}
