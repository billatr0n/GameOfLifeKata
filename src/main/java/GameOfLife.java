/**
 * Created by vasilis on 30-5-17.
 */
public class GameOfLife {
    public static final int ALIVE = 1;
    public static final int DEAD = 0;
    public static final String ALIVE_STRING = "*";
    public static final String DEAD_STRING = "-";

    private int[][] grid;

    public GameOfLife(int[][] grid) {

       setGrid(grid);
    }

    public String renderGrid(int[][] grid) {
        String gridString = "";
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == DEAD)
                    gridString += DEAD_STRING;
                else
                    gridString += ALIVE_STRING;
            }
            gridString += "\n";
        }
        System.out.println(gridString);
        return gridString;

    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

}

