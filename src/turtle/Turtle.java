package turtle;

import turtle.utils.Rotation;

/**
 * interface that is implemented by abstract turtle and
 * cluster turtle (eventually)
 */
public interface Turtle {

  public void penStateDown();

  public void penStateUp();

  public void changeBrushState(char newBrush);

  public void rotate(Rotation rotation, int repetitions);

  public void markPage();

}
