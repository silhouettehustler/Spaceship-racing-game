import javax.swing.*;
import java.awt.*;

/**
 * Created by G33 on 24/03/2017.
 */
public class Ship{

    private int currentXLocation;
    private int currentYLocation;
    private float speed;
    private float maxSpeed;
    private ImageIcon[] icons;
    private ImageIcon currentIcon;
    private int direction;

    public Ship(String prefix){

        //load ship images
        icons = new ImageIcon[16];
        for (int i = 0; i < 16; i++){
        icons[i] = new ImageIcon("images/ships/"+prefix+(i+1)+".png");
        }

        //set initial values
        speed = 0;
        maxSpeed = 10;
        currentIcon = icons[4];
        direction =4;
        currentXLocation = 300;
        currentYLocation = 500;
    }

    public Rectangle getBounds() {
        return new Rectangle(currentXLocation, currentYLocation, 50, 50);
    }

    public void slowDown(){
        if (speed != 0){this.speed -= 1;}
    }

    public void speedUp(){
        if (speed != maxSpeed){this.speed += 1;}
    }

    public void rotateLeft(){

        if (java.util.Arrays.asList(icons).indexOf(currentIcon) == 0){
            currentIcon = icons[15];
        }

        currentIcon = icons[java.util.Arrays.asList(icons).indexOf(currentIcon) - 1];
        direction = java.util.Arrays.asList(icons).indexOf(currentIcon);
        if (direction < 0) {
            direction = 16;
        }
    }

    public void rotateRight(){

        if (java.util.Arrays.asList(icons).indexOf(currentIcon) == 15){
            currentIcon = icons[0];
        }
        currentIcon = icons[java.util.Arrays.asList(icons).indexOf(currentIcon) + 1];
        direction = java.util.Arrays.asList(icons).indexOf(currentIcon);
        if (direction > 16) {
            direction = 0;
        }
    }

    public void render(Graphics g){

            if (speed > 0){

                double delta = speed * 0.8;

                if (direction == 0){
                    currentYLocation -= 2 * delta;
                }
                else if (direction == 1){
                    currentYLocation -= 2 * delta;
                    currentXLocation += 1 * delta;
                }
                else if (direction == 2){
                    currentYLocation -= 2 * delta;
                    currentXLocation += 2 * delta;
                }
                else if (direction == 3){
                    currentXLocation += 2 * delta;
                    currentYLocation -= 1 * delta;
                }
                else if (direction == 4){
                    currentXLocation += 2 * delta;
                }
                else if(direction == 5){
                    currentXLocation += 2 * delta;
                    currentYLocation += 1 * delta;
                }
                else if(direction == 6){
                    currentXLocation += 2 * delta;
                    currentYLocation += 2 * delta;
                }
                else if(direction == 7){
                    currentXLocation += 1 * delta;
                    currentYLocation += 2 * delta;
                }
                else if(direction == 8){
                    currentYLocation += 2 * delta;
                }
                else if(direction == 9){
                    currentXLocation -= 1 * delta;
                    currentYLocation += 2 * delta;
                }
                else if(direction == 10){
                    currentXLocation -= 2 * delta;
                    currentYLocation += 2 * delta;
                }
                else if(direction == 11){
                    currentXLocation -= 2 * delta;
                    currentYLocation += 1 * delta;
                }
                else if(direction == 12){
                    currentXLocation -= 2 * delta;
                }
                else if(direction == 13){
                    currentXLocation -= 2 * delta;
                    currentYLocation -= 1 * delta;
                }
                else if(direction == 14){
                    currentXLocation -= 2 * delta;
                    currentYLocation -= 2 * delta;
                }
                else if(direction == 15){
                    currentXLocation -= 1 * delta;
                    currentYLocation -= 2 * delta;
                }


            }

        g.drawImage(currentIcon.getImage(),currentXLocation,currentYLocation,null);

    }
}
