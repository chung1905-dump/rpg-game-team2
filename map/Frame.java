import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

 class Frame extends JFrame{


  public static void main(String[] args) {

    JFrame rpg = new JFrame("Best rpg game by team 2");
    rpg.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    rpg.setSize(1204,768);
    rpg.setLocation(300,200);
    JButton button1 = new JButton("New Game");
    JButton button2 = new JButton("Load Game");
    JButton button3 = new JButton("Exit");
    add(button1);
    add(button2);
    add(button3);
    rpg.setVisible(true);
  //   new Frame().setVisible(true);
  // }
  //
  // private Frame(){
  //   super("Best rpg game by team 2");
  //   setSize(600,600); // day la 1204x768, 800x600
  //   setDefaultCloseOperation(EXIT_ON_CLOSE );
  //   setLayout(new FlowLayout());
  //   JButton button1 = new JButton("New game");
  //   JButton button2 = new JButton("Load game");
  //   JButton button3 = new JButton("credit");
  //   add(button1);
  //   add(button2);
  //   add(button3);
  // }

}
}
