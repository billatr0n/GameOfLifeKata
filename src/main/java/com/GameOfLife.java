package com;

/**
 * Created by vasilis on 30-5-17.
 */
public class GameOfLife {
    public static final int ALIVE = 1;
    public static final int DEAD = 0;
    public static final String ALIVE_STRING = "*";
    public static final String DEAD_STRING = "-";

    private LifeForm[][] grid;

    public GameOfLife(LifeForm[][] grid) {

       setGrid(grid);
    }

    public String renderGrid(LifeForm[][] grid) {
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

    public LifeForm[][] getGrid() {
        return grid;
    }

    public void setGrid(LifeForm[][] grid) {
        this.grid = grid;
    }

}

