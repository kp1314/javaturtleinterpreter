package turtle;

public class Paper {

  private final static char EMPTY_CELL = ' ';
  private int width;
  private int height;
  char[][] grid;

  public Paper(int width, int height) {
    this.width = width;
    this.height = height;
    grid = new char[height][width];
    populateGrid();
  }

  /**
   * fills grid with spaces
   */
  private void populateGrid() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        grid[i][j] = EMPTY_CELL;
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  /**
   * checks if a turtle at (xVal, yVal) is in bounds
   * with respect to the page.
   * @param xVal
   * @param yVal
   * @return false if out of bounds
   */
  public boolean inBounds(int xVal, int yVal) {
    return (xVal < width  &&
            xVal >= 0      &&
            yVal < height &&
            yVal >= 0);
  }

  public void markPosition(int xVal, int yVal, char c) {
    if (inBounds(xVal,yVal)) {
      grid[yVal][xVal] = c;
    }
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        sb.append(grid[i][j]);
      } sb.append("\n");
    } return sb.toString();
  }

}
