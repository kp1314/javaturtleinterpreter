package turtle;

import turtle.utils.Rotation;


/**
 * Created by kp1314 on 05/02/15.
 */
public class Left implements TurtleAction {

    private int steps;
    private static final int ROTATEBY = 45;

    public Left(int angle) {
      this.steps = angle / ROTATEBY;
    }

    public AbstractTurtle interpretAction(AbstractTurtle currentTurtle) {
      currentTurtle.rotate(Rotation.ANTICLOCKWISE, steps);
      return currentTurtle;
    }
}
