package turtle;

import java.io.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    PrintStream printStream = new PrintStream(System.out);

    printStream.println("Input the commands line by line.\n" +
        "Please choose from the list of commands below...\n" +
        "ignoring Brackets. The initial size of the paper is\n" +
        "assumed to be a 10 by 10 blank grid\n");
    printStream.println("new (turtle type) (turtle name) (x Co-ordinate)" +
        " (y Co-ordinate)\n(left/right) (turtle name) (angle in degrees)" +
        "\nmove (turtle name) (distance in units)" +
        "\npen (turtle name) (brushChar/up/down)" +
        "\npaper (width) (height)" +
        "\nshow");


    switch (args.length) {
      case (0):
        TurtleCommander tC = new TurtleCommander();
        tC.interpretAction();
         break;
      case (1):
        TurtleCommander tC1 = new TurtleCommander(new File(args[0]));
        tC1.interpretAction();
          break;
      case (2):
        TurtleCommander tC2 = new TurtleCommander(new File(args[0]),new File(args[1]));
          tC2.interpretAction();
      default:
        printStream.print("Please enter a valid number of" +
            "arguments\ne.g (0, 1 or 2)");

    }
  }
}