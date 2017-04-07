import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by G33 on 27/03/2017.
 */
public class Panel extends JPanel implements ActionListener,KeyListener {

    //possible game stages and states
    private enum gameState {
        MENU_STATE,
        SELECTION_STATE,
        GAME_STATE,
        PAUSE_STATE,
        GAMEOVER_STATE
    }

    private int counter = 1;
    private ImageIcon[] ship1;
    private ImageIcon[] ship2;

    //stores the value of the current state and sets the current state to menu_state
    private gameState currentState = gameState.MENU_STATE;
    private gameState previousState;

    public Panel(){
        //load ship images
        ship1 = new ImageIcon[16];
        for (int i = 0; i < 16; i++){
            ship1[i] = new ImageIcon("images/ships/a"+(i+1)+".png");
        }

        ship2 = new ImageIcon[16];
        for (int i = 0; i < 16; i++){
            ship2[i] = new ImageIcon("images/ships/"+(i+1)+".png");
        }

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {

        //draws the panel default components
        super.paintComponent(g);

        g.drawImage(new ImageIcon("images/arena.jpg").getImage(), 0, 0, null);

        //paints the panel according to the appropriate current state
        switch (currentState){

            case MENU_STATE:
                renderMainMenu(g);
                break;
            case SELECTION_STATE:
                renderSelectionMenu(g);
                break;
            case GAME_STATE:
                renderGame(g);
                break;
            case PAUSE_STATE:
                renderPause(g);
                break;
            case GAMEOVER_STATE:
                break;
                default:
                    break;

        }
    }

    private void renderMainMenu(Graphics g){

       JButton start = renderMenuButton("Start Game",25,this.getHeight() / 2 - 80);
       JButton exit = renderMenuButton("Exit Game",25 ,this.getHeight() / 2  - 30);
       this.add(start);
       this.add(exit);

        start.addActionListener(e -> {
            currentState = gameState.SELECTION_STATE;
        });

        exit.addActionListener(e -> {
            System.exit(0);
        });
    }
    private void renderSelectionMenu(Graphics g){
        this.removeAll();
        this.setName("Selection Panel");

        if (counter == 16) counter = 1;
        g.drawImage(ship1[counter].getImage(),340,50,null);
        g.drawImage(ship2[counter].getImage(),440,50,null);
        counter++;

    }
    private void renderGame(Graphics g){}
    private void renderPause(Graphics g){
    JLabel pauseLabel = new JLabel("PAUSE");
    this.add(pauseLabel);

    }
    private void renderGameOver(Graphics g){}

    private JButton renderMenuButton(String text,int x,int y){
        JButton button = new JButton();
        button.setLayout(null);
        button.setBounds(x,y,this.getWidth() -50,40);
        button.setText(text);
        button.setBackground(new Color(61, 233, 63));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyChar()){
            case 'w':
                //speedUp();
                break;
            case 'd':
                //rotateRight();
                break;
            case 'a':
                //rotateLeft();
                break;
            case 's':
                //slowDown();
                break;
            case 'p':
                if (currentState == gameState.PAUSE_STATE){
                    currentState = previousState;
                    break;
                }else{
                    previousState = currentState;
                    currentState = gameState.PAUSE_STATE;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
