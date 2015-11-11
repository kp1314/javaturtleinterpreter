package turtle;

import turtle.utils.Direction;
import turtle.utils.Pen;

import java.util.HashMap;

/**
* This class holds the state of the paper and turtle hashMap
* for the turtleCommander.
*/
public class State {

  private Paper page;
  private HashMap<String, AbstractTurtle> turtleMap = new HashMap<>();

  public State() {

  }

  public void setPage(Paper newPage) {
    page = newPage;
  }

  public Paper getPage() {
    return page;
  }

  public void clearHashMap() {
    turtleMap = new HashMap<>();
  }

  public AbstractTurtle getTurtle(String name) {
    return turtleMap.get(name);
  }

  public void putTurtle(String name, AbstractTurtle turtle) {
    turtleMap.put(name, turtle);
  }

  public void setNewTurtle(String name, int x, int y, String type) {
    if (type.equals("normal")) {
      AbstractTurtle normalTurtle = new NormalTurtle(x, y, Direction.NORTH, Pen.UP, page);
      turtleMap.put(name, normalTurtle);
    }
    if (type.equals("bouncy")) {
      AbstractTurtle bouncyTurtle = new BouncyTurtle(x, y, Direction.NORTH, Pen.UP, page);
      turtleMap.put(name, bouncyTurtle);
    }

    if (type.equals("continuous")) {
      AbstractTurtle continuousTurtle = new ContinuousTurtle(x, y, Direction.NORTH, Pen.UP, page);
      turtleMap.put(name, continuousTurtle);
    }

    if (type.equals("wrapping")) {
      AbstractTurtle wrappingTurtle = new WrappingTurtle(x, y, Direction.NORTH, Pen.UP, page);
      turtleMap.put(name, wrappingTurtle);
    }

    if (type.equals("reflective")) {
      AbstractTurtle reflectiveTurtle = new ReflectiveTurtle(x, y, Direction.NORTH, Pen.UP, page);
      turtleMap.put(name, reflectiveTurtle);
    }


  }
}

