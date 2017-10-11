public class Player{
  private int x,y;
  private boolean left,right,up,down;

  public void update(){
    move();
  }

  public void setLeft(boolean newLeft){
    this.left = newLeft;
  }
  public void setRight(boolean newRight){
    this.right =newRight;
  }
  public void setUp(boolean newUp){
    this.up = newUp;
  }
  public  void setDown(boolean newDown){
    this.down = newDown;
  }

  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public void move(){
    if (left) {
      x--;
    }if (right) {
      x++;
    }if (down) {
      y--;
    }if (up) {
      y++;
    }
  }

}
