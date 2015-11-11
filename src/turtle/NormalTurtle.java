package turtle;

import turtle.utils.Direction;
import turtle.utils.Pen;

/**
 * Creates a Normal turtle.
 */
public class NormalTurtle extends AbstractTurtle {

  public NormalTurtle(int xVal, int yVal, Direction direction,
                      Pen penState, Paper currentPage) {
    super(xVal,yVal,direction,penState,currentPage);
  }

  @Override
  public void moveTurtleHelper() {
      moveTurtleBackInBounds();
    }
  }
