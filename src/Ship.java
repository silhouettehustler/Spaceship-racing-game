import javax.swing.*;
import java.awt.*;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/**
 * Created by G33 on 24/03/2017.
 */
public class Ship{

    private int id;
    private String name;
    private float speed, maxSpeed;
    private ImageIcon[] icons;
    private ImageIcon currentIcon;
    private int currentXLocation,currentYLocation;
    private double currentAngle;



    public Ship(){

        //load ship images
        icons = new ImageIcon[16];
        for (int i = 0; i < 16; i++){
        icons[i] = new ImageIcon("images/"+id+(i+1)+".png");
        }

        //set initial values
        speed = 0;
        maxSpeed = 20;
        currentIcon = icons[4];
        currentAngle = 0;
    }

    private void slowDown(){
        if (speed != 0){this.speed -= 2;}
    }

    private void speedUp(){
        if (speed != maxSpeed){this.speed += 2;}
    }

    private void rotateLeft(){

        if (java.util.Arrays.asList(icons).indexOf(currentIcon) == 0){
            currentIcon = icons[15];
        }

        currentIcon = icons[java.util.Arrays.asList(icons).indexOf(currentIcon) - 1];
        currentAngle -=22.5;
        if (currentAngle < 0) {
            currentAngle = 360;
        }
    }

    private void rotateRight(){

        if (java.util.Arrays.asList(icons).indexOf(currentIcon) == 15){
            currentIcon = icons[0];
        }
        currentIcon = icons[java.util.Arrays.asList(icons).indexOf(currentIcon) + 1];
        currentAngle +=22.5;
        if (currentAngle > 360) {
            currentAngle = 0;
        }
    }

    public void drawShip(Graphics g){

            if (speed > 0){

                currentXLocation +=  speed * cos(Math.toRadians(currentAngle)) * 0.08;
                currentYLocation +=  speed * sin(Math.toRadians(currentAngle)) * 0.08;
            }

        g.drawImage(currentIcon.getImage(),currentXLocation,currentYLocation,null);

    }
}
