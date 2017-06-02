/**
 * Created by vasilis on 30-5-17.
 */
public class GameOfLife {
    public static final int ALIVE = 1;
    public static final int DEAD = 0;
    public static final String ALIVE_STRING = "*";
    public static final String DEAD_STRING = "-";

    private FormOfLife[][] grid;

    public GameOfLife(FormOfLife[][] grid) {

       setGrid(grid);
    }

    public String renderGrid(FormOfLife[][] grid) {
        String gridString = "";
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
               gridString += grid[x][y].printExistence();
            }
            gridString += "\n";
        }
        System.out.println(gridString);
        return gridString;

    }

    public FormOfLife[][] getGrid() {
        return grid;
    }

    public void setGrid(FormOfLife[][] grid) {
        this.grid = grid;
    }

}

