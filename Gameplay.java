// import javax.swing.JPanel;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.KeyListener;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;
// import javax.swing.Timer;
// import java.awt.Graphics;
// import java.awt.Color;
// import java.awt.Rectangle;
// import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Gameplay extends JPanel implements KeyListener, ActionListener{

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

  // private MapGenerator map;

  //main constructor

  public Gameplay(){

    // map = new // mapGenerator(3, 7);

    //work with the KeyListener
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    time = new Timer(delay, this);
    time.start(); //starts the Timer

  }

  //function to recieve the graphics object g
  public void paint(Graphics g){


    // // map.draw((Graphics2D) g);

    // Text for the Score
    g.setColor(Color.white);
    g.setFont(new Font("serif", Font.BOLD, 25));
    g.drawString("" + score, 590, 30);

    //add background
    g.setColor(Color.black);
    g.fillRect(1, 1, 692, 592);

    //borders
    g.setColor(Color.red);
    g.fillRect(0, 0, 3, 592);
    g.fillRect(0, 0, 692, 3);
    g.fillRect(685, 0, 3, 592);

    //paddle
    g.setColor(Color.blue);
    g.fillRect(playerX, 550, 100, 8); //playerX, 550, 100, 8

    //ball
    g.setColor(Color.yellow);
    g.fillOval(ballPositionX, ballPositionY, 20, 20);

    g.dispose();

    // check if the ball falls out of bounds

    if(ballPositionY > 552){
      play = false;
      ballXdirection = 0;
      ballYdirection = 0;
      g.setColor(Color.red);
      g.setFont(new Font("serif", Font.BOLD, 30));
      g.drawString(" --- Game Over --- Score: " + score, 190, 300);

      g.setFont(new Font("serif", Font.BOLD, 30));
      g.drawString("    Press Enter to Restart", 190, 340);

    }

    //when the user wins and breaks all of the bricks

    // if(totalbricks == 0)

  }

  public void keyTyped(KeyEvent e){}
  public void keyReleased(KeyEvent e){}

  public void actionPerformed(ActionEvent e){

    //time starts and we call a method to repaint the whole process
    time.start();

    //check is the variable play is true, detect
    //if the ball is touching the borders

    if (true){
      // check intersection with the paddle
      if (new Rectangle(ballPositionX, ballPositionY, 20, 20).intersects(new Rectangle(playerX, 550,100,8))){
        ballYdirection = -ballYdirection;
      }

      ballPositionX += ballXdirection;
      ballPositionY += ballYdirection;
      if(ballPositionX < 0){
        ballXdirection = -ballXdirection;
      }
      if(ballPositionY < 0){
        ballYdirection = -ballYdirection;
      }
      if(ballPositionX > 662){
        ballXdirection = -ballXdirection;
      }
    }

    repaint();



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
    play = true;
    playerX -= 20;
  }




}
