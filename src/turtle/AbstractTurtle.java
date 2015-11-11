package turtle;

import turtle.utils.Coordinate;
import turtle.utils.Direction;
import turtle.utils.Pen;
import turtle.utils.Rotation;

/**
 * Created by kp1314 on 05/02/15.
 */
public abstract class AbstractTurtle implements Turtle {

  public static final int ROTATE_BY = 45;
  protected char currentBrush = '*';
  protected Coordinate position;
  protected Direction direction;
  protected Pen penState;
  protected Paper currentPage;

  /**
   * This is the basic layout for a turtle which is extended.
   * @param xVal
   * @param yVal
   * @param direction
   * @param penState
   * @param currentPage
   */
  public AbstractTurtle(int xVal, int yVal, Direction direction,
                      Pen penState, Paper currentPage) {
    this.direction = direction;
    this.position = new Coordinate(xVal,yVal);
    this.penState = penState;
    this.currentPage = currentPage;
  }

  public void penStateDown() {
    penState = Pen.DOWN;
  }

  public void penStateUp() {
    penState = Pen.UP;
  }

  /**
   *
   * @param newBrush
   */
  public void changeBrushState(char newBrush) {
    currentBrush = newBrush;
  }

  /**
   *
   * @param rotation
   * @param repetitions
   */
  public void rotate(Rotation rotation, int repetitions) {
    for (int i = 0; i < repetitions; i++) {
      direction = direction.rotate(rotation);
    }
  }

  /**
   *
   */
  public void markPage() {
    if (penState == Pen.DOWN) {
      currentPage.markPosition(position.getX(),
          position.getY(), currentBrush);
    }
  }

  /**
   *
   * @param currentPage
   * @return false if turtle is out of bounds with respect to paper.
   */
  public Boolean outOfBounds(Paper currentPage) {
    return !(currentPage.inBounds(position.getX(), position.getY()));
  }

  /**
   *must be positive number of steps
   */
  public void moveTurtle(int steps) {
    for (int i = 0; i < steps; i++) {
      switch (direction) {
        case SOUTH:
          position.setY(position.getY() + 1);
          break;
        case NORTH:
          position.setY(position.getY() - 1);
          break;
        case EAST:
          position.setX(position.getX() + 1);
          break;
        case WEST:
          position.setX(position.getX() - 1);
          break;
        case NORTHEAST:
          position.setX(position.getX() + 1);
          position.setY(position.getY() - 1);
          break;
        case NORTHWEST:
          position.setX(position.getX() - 1);
          position.setY(position.getY() - 1);
          break;
        case SOUTHEAST:
          position.setX(position.getX() + 1);
          position.setX(position.getY() + 1);
          break;
        case SOUTHWEST:
          position.setX(position.getX() - 1);
          position.setY(position.getY() + 1);
          break;
        default:
          break;
      }
      moveTurtleHelper();
      markPage();
    }
  }

  /** This function moves the turtle directly back in bounds*/
  public void moveTurtleBackInBounds() {
      switch (direction) {
        case SOUTH:
          position.setY(position.getY() - 1);
          break;
        case NORTH:
          position.setY(position.getY() + 1);
          break;
        case EAST:
          position.setX(position.getX() - 1);
          break;
        case WEST:
          position.setX(position.getX() + 1);
          break;
        case NORTHWEST:
          position.setX(position.getX() + 1);
          position.setY(position.getY() + 1);
          break;
        case NORTHEAST:
          position.setX(position.getX() - 1);
          position.setY(position.getY() + 1);
          break;
        case SOUTHWEST:
          position.setX(position.getX() + 1);
          position.setY(position.getY() - 1);
          break;
        case SOUTHEAST:
          position.setX(position.getX() - 1);
          position.setY(position.getY() - 1);
          break;
        default:
          break;
      }
    }

  /**
   * different implementation with different turtles.
   */
  public abstract void moveTurtleHelper();

}
