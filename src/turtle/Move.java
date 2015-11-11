package turtle;

/**
* Created by kp1314 on 05/02/15.
*/
public class Move implements TurtleAction {

  private int steps;

  public Move(int steps) {
    this.steps = steps;
  }

  public AbstractTurtle interpretAction(AbstractTurtle currentTurtle) {
    currentTurtle.moveTurtle(steps);
    return currentTurtle;
  }
}
