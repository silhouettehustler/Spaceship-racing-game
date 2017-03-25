

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/**
 * Created by G33 on 24/03/2017.
 */
public class Ship{

    private float speed;
    private int maxSpeed;
    private String prefix;
    private ImageIcon[] icons;
    private ImageIcon currentIcon;
    private int currentXLocation;
    private int currentYLocation;
    private double currentAngle;


    public Ship(String prefix,int x,int y){

        //load ship images
        icons = new ImageIcon[16];
        for (int i = 0; i < 16; i++){
        icons[i] = new ImageIcon("images/"+prefix+(i+1)+".png");
        }

        //set initial values
        speed = 0;
        maxSpeed = 2;
        this.prefix = prefix;
        currentIcon = icons[4];
        currentXLocation = x;
        currentYLocation = y;
        currentAngle = 90;
    }

    public void slowDown(){
        if (speed != 0){this.speed -= 0.1;}
    }

    public void speedUp(){
        if (speed != maxSpeed){speed += 0.1;}
    }

    public void rotateLeft(){
        if (currentAngle == 0) {
            currentIcon = icons[15];
            currentAngle = 337.5;
        }
        currentIcon = icons[java.util.Arrays.asList(icons).indexOf(currentIcon) - 1];
        currentAngle -=22.5;
    }

    public void rotateRight(){
        if (currentAngle == 337.5) {
            currentIcon = icons[0];
            currentAngle = 0;
        }
        currentIcon = icons[java.util.Arrays.asList(icons).indexOf(currentIcon) + 1];
        currentAngle +=22.5;
    }

    public void drawShip(Graphics g){

        Graphics2D ship = (Graphics2D) g;

            if (speed > 0){
                currentXLocation +=  cos(currentAngle);
                currentYLocation +=  sin(currentAngle);
            }

        g.drawImage(currentIcon.getImage(),currentXLocation,currentYLocation,null);

    }

}
