package turtle;

import turtle.utils.Direction;
import turtle.utils.Pen;
import turtle.utils.Rotation;

/**
 * Creates Bouncy Turtle
 */
public class BouncyTurtle extends AbstractTurtle {

  private static final int ANGLE_OF_ROTATION = 180;

  public BouncyTurtle(int xVal, int yVal, Direction direction,
                      Pen penState, Paper currentPage) {
    super(xVal, yVal, direction, penState, currentPage);
  }

  @Override
  public void moveTurtleHelper() {
    if (outOfBounds(currentPage)) {
      moveTurtleBackInBounds();
      rotate(Rotation.ANTICLOCKWISE, ANGLE_OF_ROTATION / ROTATE_BY);
    }
  }
}

