import javax.swing.JFrame;

public class Main{
  public static void main(String[] args) {

    JFrame obj = new JFrame(); //create java JFrame

    // set JFrame properties
    obj.setBounds(10, 10, 700, 600);
    Gameplay game = new Gameplay();
    obj.setTitle("Ball Game");
    obj.setResizable(false);
    obj.setVisible(true);
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    obj.add(game);


  } //end of main
} //end of class
