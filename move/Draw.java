import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw{
  // public Draw drawing = new Draw();
  JFrame frame;
  Canvas canvas;
  BufferStrategy bufferStrategy;

  private int width =600;
  private int height =600;
  Draw(){
    // TAO CUA SO GAME
    frame = new JFrame("Rpg by team 2");
    JPanel panel = (JPanel) frame.getContentPane();
    panel.setPreferredSize(new Dimension(width, height ));
    panel.setLayout(null);

    canvas = new Canvas();
    canvas.setBounds(0,0,width,height);
    canvas.setIgnoreRepaint(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();

    //lam` cho frame khong resizable
    //d biet de lam gi nhung ma cac ban tren mang. day Thread
    frame.setResizable(false);
    frame.setVisible(true);

    //add canvas
    panel.add(canvas);
    canvas.createBufferStrategy(2);
    bufferStrategy = canvas.getBufferStrategy();

    // nhan input tu ban phim
    canvas.requestFocus();

    //lam` background mau` den nhung ma t thik mau` xanh nen t de mau xanh
    canvas.setBackground(Color.blue);

    //add contrller vao GAME
    canvas.addKeyListener(new Controller());
  }
  void render(){
    Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
    g.clearRect(0,0,width,height);
    render(g);
    g.dispose();
    bufferStrategy.show();
  }
  protected void render(Graphics2D g){
    //render thoi
    g.setColor(Color.red);
    g.fillRect(TaoPlayer.player.getX(), TaoPlayer.player.getY(),15,15);
  }
}
