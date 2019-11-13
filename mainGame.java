import javax.swing.JPanel;
import java.awt.*;
import java.util.Timer;


public class gameplay extends JPanel implements KeyListener, ActionListener{

  //instance variables

  private boolean play = false;
  private int score = 0;

  private int totalBricks = 21;

  private Timer time;
  private int delay = 8;

  private int playerX = 310;

  private int ballPositionX = 120;
  private int ballPositionY = 350;
  private int ballXdirection = -1;
  private int ballYdirection = -2;

  //main constructor

  public gameplay(){

    //work with the KeyListener
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    // timer = new Timer(delay, this);
    // timer.start(); //starts the Timer

  }

  //function to recieve the graphics object g
  public void paint(Graphics g){

    //add background
    g.setColor(Color.black);
    g.fillRect(1, 1, 692, 592);

    //borders
    g.setColor(Color.yellow);
    g.fillRect(0, 0, 3, 592);
    g.fillRect(0, 0, 692, 3);
    g.fillRect(691, 0, 3, 592);

    //paddle
    g.setColor(Color.blue);
    g.fillRect(playerX, 550, 100, 8);

    //ball
    g.setColor(Color.yellow);
    g.fillRect(ballPositionX, ballPositionY, 20, 20);

  }

  public void keyTyped(KeyEvent e){}
  public void keyReleased(KeyEvent e){}

  public void actionPerformed(ActionEvent e){

  }


  public void keyPressed(KeyEvent e){

    if (e.getKeyCode() == KeyEvent.VK_RIGHT){
      if (playerX >= 600){
        playerX = 600;
      } else {
        moveRight();
      }

    }

    if (e.getKeyCode() == KeyEvent.VK_LEFT){
      if (playerX < 10){
        playerX = 10;
      }
      else {
        moveLeft();
      }

    }

  }

  public void moveRight(){
    play = true;
    playerX += 20;
  }
  public void moveLeft(){
    player = true;
    playerX -= 20;
  }



}
