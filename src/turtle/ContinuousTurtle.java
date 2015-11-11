package turtle;

import turtle.utils.Direction;
import turtle.utils.Pen;

/**
 * Created by kp1314 on 06/02/15.
 */
public class ContinuousTurtle extends AbstractTurtle{

  public ContinuousTurtle(int xVal, int yVal, Direction direction,
                      Pen penState, Paper currentPage) {
    super(xVal,yVal,direction,penState,currentPage);
  }

  /**
   * The continuous turtle carries on when out of bounds.
   */
  @Override
  public void moveTurtleHelper() {
  }
}
