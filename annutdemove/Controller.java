import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter{
  // public Controller(){
  //   System.out.print("Tay cam` da~ duoc cai` dat");
  // }

  public void keyPressed(KeyEvent key){
    if (key.getKeyCode() == KeyEvent.VK_LEFT) {
      TaoPlayer.player.setLeft(true);
    }if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
      TaoPlayer.player.setRight(true);
    }if (key.getKeyCode() == KeyEvent.VK_UP) {
      TaoPlayer.player.setUp(true);
    }if (key.getKeyCode() == KeyEvent.VK_DOWN) {
      TaoPlayer.player.setDown(true);
    }
  }

  public void keyReleased(KeyEvent key){
    if (key.getKeyCode() == KeyEvent.VK_LEFT) {
      TaoPlayer.player.setLeft(false);
      System.out.println("trai'");
    }if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
      TaoPlayer.player.setRight(false);
      System.out.print("phai");
    }if (key.getKeyCode() == KeyEvent.VK_UP) {
      TaoPlayer.player.setUp(false);
      System.out.print("len");
    }if (key.getKeyCode() == KeyEvent.VK_DOWN) {
      TaoPlayer.player.setDown(false);
      System.out.print("xuong");
    }
  }
}
