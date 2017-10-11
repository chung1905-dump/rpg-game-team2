public class Game implements Runnable{
  public void run(){
    while (true) {
      TaoPlayer.player.update();
      Draw drawing = new Draw();
      try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
    }
  }
}
