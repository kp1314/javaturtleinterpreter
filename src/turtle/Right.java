package turtle;

import turtle.utils.Rotation;


/**
 * Created by kp1314 on 05/02/15.
 */
public class Right implements TurtleAction {

    private int turns;
    private static final int ROTATEBY = 45;

    public Right(int angle) {
      this.turns = angle / ROTATEBY;
    }

    public AbstractTurtle interpretAction(AbstractTurtle currentTurtle) {
      currentTurtle.rotate(Rotation.CLOCKWISE, turns);
      return currentTurtle;
    }

  }
