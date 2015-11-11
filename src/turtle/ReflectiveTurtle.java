package turtle;

import turtle.utils.Direction;
import turtle.utils.Pen;
import turtle.utils.Rotation;

/**
 * Makes a new abstract turtle of type reflective turtle.
 */
public class ReflectiveTurtle extends AbstractTurtle {

  private static final int ROTATE_180 = 180;
  private static final int ROTATE_90 = 90;

  public ReflectiveTurtle(int xVal, int yVal, Direction direction,
                          Pen penState, Paper currentPage) {
    super(xVal, yVal, direction, penState, currentPage);
  }

  /**
   * My reflective turtle reflects in the sides of the paper
   * but not the top edge.
   */
  @Override
  public void moveTurtleHelper() {
    if (outOfBounds(currentPage)) {
      moveTurtleBackInBounds();
      switch (direction) {
        case SOUTH:
        case NORTH:
        case EAST:
        case WEST:
          rotate(Rotation.ANTICLOCKWISE, ROTATE_180 / ROTATE_BY);
          break;
        case NORTHWEST:
          if (position.getY() >= currentPage.getHeight()) {
            rotate(Rotation.ANTICLOCKWISE, ROTATE_90 / ROTATE_BY);
          } else {
            rotate(Rotation.CLOCKWISE, ROTATE_90 / ROTATE_BY);
          }
          break;
        case SOUTHEAST:
          if (position.getY() < 0) {
            rotate(Rotation.ANTICLOCKWISE, ROTATE_90 / ROTATE_BY);
          } else {
            rotate(Rotation.CLOCKWISE, ROTATE_90 / ROTATE_BY);
          }
          break;
        case SOUTHWEST:
          if (position.getY() < 0) {
            rotate(Rotation.CLOCKWISE, ROTATE_90 / ROTATE_BY);
          } else {
            rotate(Rotation.ANTICLOCKWISE, ROTATE_90 / ROTATE_BY);
          }
          break;
        case NORTHEAST:
          if (position.getY() >= currentPage.getHeight()) {
            rotate(Rotation.CLOCKWISE, ROTATE_90 / ROTATE_BY);
          } else {
            rotate(Rotation.ANTICLOCKWISE, ROTATE_90 / ROTATE_BY);
          }
          break;
        default:
          break;
      }
    }
  }
}
