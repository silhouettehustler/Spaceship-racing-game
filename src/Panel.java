import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private int fpsCounter = 0;
    private ImageIcon[] ship1;
    private ImageIcon[] ship2;

    //store the value of the current state and set the current state to menu_state
    private gameState currentState = gameState.MENU_STATE;
    private gameState previousState;
    private Ship currentContextShip;
    private boolean screenIsRendered;
    private Timer timer;

    public Panel(){

        loadShips();
        setFocusable(true);
        addKeyListener(this);

        //initialize timer and start it
        timer = new Timer(40,this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {

        //draw the panel default components
        super.paintComponent(g);

        //draw the racing arena
        renderArena(g);


        //paint the panel according to the appropriate game state
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
                renderGameOver();
                break;
                default:
                    break;

        }
    }

    private void loadShips(){

        //load ship images
        ship1 = new ImageIcon[16];
        for (int i = 0; i < 16; i++){
            ship1[i] = new ImageIcon("images/ships/a"+(i+1)+".png");
        }

        ship2 = new ImageIcon[16];
        for (int i = 0; i < 16; i++){
            ship2[i] = new ImageIcon("images/ships/"+(i+1)+".png");
        }
    }
    private void renderMainMenu(Graphics g){

        this.removeAll();

        g.drawImage(new ImageIcon("images/selection-menu.jpg").getImage(), 0, 0, null);


       JButton start = renderMenuButton("Start Game",this.getWidth() / 2  -100,this.getHeight() / 2 - 80);
       JButton exit = renderMenuButton("Exit Game",this.getWidth() / 2 -100 ,this.getHeight() / 2  - 30);
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

        g.drawImage(new ImageIcon("images/selection-menu.jpg").getImage(), 0, 0, null);
        this.setName("Selection Panel");

        if (counter == 16) counter = 1;

            g.drawImage(ship1[counter].getImage(),240,50,null);
            JButton selectShip1 = renderMenuButton("SELECT",170,120);
            this.add(selectShip1);

            g.drawImage(ship2[counter].getImage(),540,50,null);
            JButton selectShip2 = renderMenuButton("SELECT",470,120);
            this.add(selectShip2);

            selectShip1.addActionListener(e -> {
                currentContextShip = new Ship("a");
                currentState = gameState.GAME_STATE;
            });

            selectShip2.addActionListener(e -> {
                currentContextShip = new Ship("");
                currentState = gameState.GAME_STATE;
            });


        fpsCounter++;

        if (fpsCounter % 2 == 0) {
            counter++;
        }
    }
    private void renderGame(Graphics g){

        this.removeAll();

        if (collision()){
            currentState = gameState.GAMEOVER_STATE;
            return;
        }

        if (screenIsRendered == false){
            //clear current panel
            this.removeAll();
            //draw arena
            renderArena(g);
            //draw ships
        }

        currentContextShip.render(g);
        screenIsRendered = true;
    }

    private void renderPause(Graphics g){
    JLabel pauseLabel = new JLabel("PAUSE");
    this.add(pauseLabel);

    }
    private void renderGameOver(){

        timer.stop();

        int result = JOptionPane.showConfirmDialog(null,
                "Start a New Game?","GAME OVER", JOptionPane.YES_NO_OPTION);

        if(result == JOptionPane.YES_OPTION) {
            currentState = gameState.SELECTION_STATE;
            timer.start();
        }else{
            System.exit(0);
        }
    }
    private void renderArena(Graphics  g){

        Color c1 = Color.black;
        g.setColor( c1 );
        g.fillRect( 50, 100, 750, 500 ); //surrounding space
        Color c2 = new Color(210, 105, 30); // RGB brown mix
        g.setColor( c2 );
        g.fillRect(200, 225, 450, 200); // asteroid
        Color c3 = Color.white;
        g.setColor( c3 );
        g.drawLine( 425, 500, 425, 600 ); // start line
    }

    private JButton renderMenuButton(String text,int x,int y){
        JButton button = new JButton();
        button.setLayout(null);
        button.setBounds(x,y,200,40);
        button.setText(text);
        button.setBackground(new Color(209, 255, 198));
        return button;
    }

    private boolean collision() {

        //arena space collider
        Rectangle arena = new Rectangle(50, 100, 750, 500);
        //arena asteroid collider
        Rectangle asteroid = new Rectangle(200, 225, 450, 200);

        //check for collision with asteroid
        if (currentContextShip.getBounds().intersects(asteroid.getBounds()))
        {
            return true;
        }
        else if ( currentContextShip.getBounds().getMaxX() >= arena.getMaxX() || currentContextShip.getBounds().getMinX() <= arena.getMinX()
                ||currentContextShip.getBounds().getMaxY() >= arena.getMaxY() || currentContextShip.getBounds().getMinY() <= arena.getMinY()){

            return true;
        }

        return false;
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
                currentContextShip.speedUp();
                break;
            case 'd':
                currentContextShip.rotateRight();
                break;
            case 'a':
                currentContextShip.rotateLeft();
                break;
            case 's':
                currentContextShip.slowDown();
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
