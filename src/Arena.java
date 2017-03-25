import javafx.scene.layout.BorderStroke;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by G33 on 23/03/2017.
 */
public class Arena extends JPanel implements ActionListener,KeyListener {

    public Ship ship1 = new Ship("",430,490);
    public Ship ship2 = new Ship("a",430,545);

    public Arena(){
        this.setName("Space Race");
        this.requestFocus();
    }

    public void drawArena(Graphics g){

        //draw background
        g.drawImage(new ImageIcon("images/arena.jpg").getImage(),0,0,null);

        //start line
        g.setColor( Color.white );
        g.drawLine( 425, 500, 425, 600 );
    }

    @Override
    public void paintComponent(Graphics g){
        drawArena(g);
        ship1.drawShip(g);
        ship2.drawShip(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w':
                ship1.speedUp();
                break;
            case 'd':
                ship1.rotateRight();
                break;
            case 'a':
                ship1.rotateLeft();
                break;
            case 's':
                ship1.slowDown();
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

