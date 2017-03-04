import javax.swing.*;
import java.awt.*;

/**
 * Created by G33 on 04/03/2017.
 */
public class SelectionMenu {

    public static void main(String[] args) {

        CustomPanel panel = new CustomPanel();
        Frame frame = new Frame(panel);
        Timer stopwatch = new Timer(70, panel);
        frame.Show();
        stopwatch.start();
    }

}
