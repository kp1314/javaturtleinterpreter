package turtle;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by kp1314 on 04/02/15.
 */
 public class TurtleCommander {

  private static final int INITIAL_WIDTH = 10;
  private static final int INITIAL_HEIGHT = 10;
  private static final Paper INITIAL_PAPER = new Paper(
      INITIAL_WIDTH, INITIAL_HEIGHT);

  private TurtleAction command;
  private State state = new State();

  private Scanner scanner;
  private PrintStream printStream = new PrintStream(System.out);

  /**
   * constructor for standard input and standard out.
   */
  public TurtleCommander() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * constructor for input of a file and standard out.
   * @param input file
   * @throws FileNotFoundException
   */
  public TurtleCommander(File input) throws FileNotFoundException {
    this.scanner = new Scanner(input);

  }

  /**
   * constructor for input file and output file
   * @param input file
   * @param output file
   * @throws FileNotFoundException
   */
  public TurtleCommander(File input, File output) throws FileNotFoundException {
    this.printStream = new PrintStream(output);
    this.scanner = new Scanner(input);
  }

  /**
   * This parses the inputted file or standard input using the scanner
   * and other classes that implement commands.
   * @throws FileNotFoundException if file not inputted for outputting.
   */
  public void interpretAction() throws FileNotFoundException {
    state.setPage(INITIAL_PAPER);
    while (scanner.hasNextLine()) {
      String action = scanner.next().toLowerCase();
      switch (action) {
        case "move":
          try {
            String name = scanner.next();
            int steps = scanner.nextInt();
            AbstractTurtle turtle = state.getTurtle(name);
            Move command = new Move(steps);
            turtle = command.interpretAction(turtle);
            state.putTurtle(name, turtle);
            break;
          } catch (InputMismatchException IM) {
            printStream.println("Wrong input.\nPlease use structure move name steps");
            break;
          } catch (NullPointerException NP) {
            printStream.print("Please initialise this turtle");
          }
        case "paper":
          try {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            state.setPage(new Paper(width, height));
            state.clearHashMap();
            break;
          } catch (InputMismatchException IM) {
            printStream.println("Wrong input.\nPlease use structure paper width height");
          }
          break;
        case "right":
          try {
            String name1 = scanner.next();
            int angle1 = scanner.nextInt();
            if (angle1 % 45 == 0) {
              AbstractTurtle turtle1 = state.getTurtle(name1);
              command = new Right(angle1);
              turtle1 = command.interpretAction(turtle1);
              state.putTurtle(name1, turtle1);
              break;
            } else {
              printStream.println("The angle you input must " +
                  "be a multiple of 45");
            }
          } catch (InputMismatchException IM) {
            System.out.println("Wrong input.\nPlease use structure right name angle");
            break;
          } catch (NullPointerException NP) {
            printStream.println("Please use the right turtle name");
          }
          break;
        case "left":
          try {
            String name2 = scanner.next();
            int angle2 = scanner.nextInt();
            AbstractTurtle turtle2 = state.getTurtle(name2);
            command = new Left(angle2);
            turtle2 = command.interpretAction(turtle2);
            state.putTurtle(name2, turtle2);
            break;
          } catch (InputMismatchException IM) {
            System.out.println("Wrong input.\nPlease use structure left name angle");
            break;
          } catch (NullPointerException NP) {
            printStream.println("Please use the right turtle name");
          }
          break;
        case "new":
          try {
            String type = scanner.next().toLowerCase();
            if (type.equals("normal") ||
                type.equals("reflective") ||
                type.equals("bouncy") ||
                type.equals("wrapping") ||
                type.equals("continuous")) {
              String name3 = scanner.next();
              int pageHeight = state.getPage().getHeight();
              int x = scanner.nextInt();
              int y = pageHeight - (scanner.nextInt() + 1);
              state.setNewTurtle(name3, x, y, type);
              break;
            } else {
              printStream.println("There is no such turtle of type " + type + ".");
              break;
            }
          } catch (InputMismatchException IM) {
            printStream.println("Wrong input.\nPlease use structure:\n" +
                "'new (turtle type) (turtle name) (x Co-ord) (y Co-ord)'");
            break;
          } catch (NullPointerException NP) {
            printStream.println("Please initialise the paper.");
          }
          break;
        case "pen":
          try {
            String name4 = scanner.next();
            String upOrDown = scanner.next();
            AbstractTurtle turtle3 = state.getTurtle(name4);
            if (upOrDown.length() == 1) {
              turtle3.changeBrushState(upOrDown.charAt(0));
              break;
            }
            if (upOrDown.equals("up")) {
              turtle3.penStateUp();
              break;
            }
            if (upOrDown.equals("down")) {
              turtle3.penStateDown();
              break;
            } else {
              printStream.print("Wrong input.\nPlease use structure " +
                  "'pen (turtle name) (brushChar/up/down)'");
              break;
            }
          } catch (InputMismatchException IM) {
            printStream.print("Wrong input.\nPlease use structure:\n" +
                "pen name (up/down)");
            break;
          } catch (NullPointerException NP) {
            printStream.print("Sorry there is no turtle stored with this name.\n" +
                "Please initialise this turtle with the following command\n" +
                "new (turtle type) (turtle name) (x Co-ord) (y Co-ord).");
          }
          break;
        case "show":
          if ((scanner.nextLine().length() == 0)) {
            if (state.getPage() == null) {
              printStream.print("No paper initiated");
              break;
            } else {
              printStream.print(state.getPage());
              break;
            }
          } else {
            printStream.print("'show' has no arguments!");
          }
          break;
        default:
          /**
           * This is meant to give suggestions on the command required
           * based on the command that was entered.
           */
          if (action.length() > 0) {
            printStream.println("You didn't enter a valid command.");
            if (action.charAt(0) == 'n' || action.charAt(1) == 'e') {
              printStream.println("Maybe you wanted the method:\n'new " +
                  "(turtle type) (turtle name) (x Co-ord) (y Co-ord)'");
            }
            if (action.charAt(0) == 'l' || action.charAt(1) == 'e') {
              printStream.println("Maybe you wanted the method:\n'left " +
                  "(turtle name) (angle in degrees)'");
            }
            if (action.charAt(0) == 'r' || action.charAt(1) == 'i') {
              printStream.println("Maybe you wanted the method:\n'right " +
                  "(turtle name) (angle in degrees)'");
            }
            if (action.charAt(0) == 'm' || action.charAt(0) == 'n') {
              printStream.println("Maybe you wanted the method:\n'move " +
                  "(turtle name) (distance in units)'");
            }
            if (action.charAt(0) == 's' || action.charAt(1) == 'h') {
              printStream.println("Maybe you wanted the method:\n'show'");
            }
            if (action.charAt(0) == 'p' || action.charAt(1) == 'e') {
              printStream.println("Maybe you wanted the method:\n'pen " +
                  "(turtle name) (brushChar/up/down)'");
            }
            if (action.charAt(0) == 'p' || action.charAt(1) == 'a') {
              printStream.println("Maybe you wanted the method:\n'paper " +
                  "(width) (height)'");
            }
            scanner.nextLine();
            break;
          }
      }
    }
  }
}


