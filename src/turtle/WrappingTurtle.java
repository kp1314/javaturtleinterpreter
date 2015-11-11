package turtle;

import turtle.utils.Direction;
import turtle.utils.Pen;

/**
 * Creates Wrapping turtle
 */
public class WrappingTurtle extends AbstractTurtle{

  public WrappingTurtle(int xVal, int yVal, Direction direction,
                          Pen penState,Paper currentPage) {
    super(xVal,yVal,direction,penState,currentPage);
  }

  @Override
  public void moveTurtleHelper() {
    if (outOfBounds(currentPage)) {
      moveTurtleBackInBounds();
      switch (direction) {
        case SOUTH:
        case NORTH:
          position.setY(currentPage.getHeight() - (position.getY()));
          break;
        case EAST:
        case WEST:
          position.setX(currentPage.getWidth() - position.getX());
          break;
        case NORTHWEST:
        case NORTHEAST:
        case SOUTHWEST:
        case SOUTHEAST:
          position.setX(currentPage.getWidth() - (position.getX() + 1));
          position.setY(currentPage.getHeight() - (position.getY() + 1));
          break;
        default:
          break;
      }
    }
  }
}
