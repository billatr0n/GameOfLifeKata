package com;

/**
 * Created by vasilis on 30-5-17.
 */
public class GameOfLife {

    private LifeForm[][] grid;

    public GameOfLife(LifeForm[][] grid) {

       setGrid(grid);
    }

    public String renderGrid(LifeForm[][] grid) {
        StringBuffer buffer = new StringBuffer();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                buffer.append(grid[x][y].printExistence());
            }
            buffer.append("\n");
        }
        String gridString = buffer.toString();
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

