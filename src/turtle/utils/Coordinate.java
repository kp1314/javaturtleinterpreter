package turtle.utils;

public class Coordinate {

  private int x;
  private int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }  

  public void setX(int newX) {
    x = newX; 
  }

  public void setY(int newY) {
    y = newY;
  }

}
