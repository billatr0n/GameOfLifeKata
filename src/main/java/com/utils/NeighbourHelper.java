package com.utils;

import com.LifeForm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vasilis on 7-6-17.
 */
public final class NeighbourHelper {
    private NeighbourHelper() {

    }

    public static List<LifeForm> identifyNeighbours(LifeForm[][] grid, Point myLocation) {
        if (grid == null) {
            return Collections.emptyList();
        }
        List<LifeForm> neighbours = new ArrayList<LifeForm>();
        //Need to somehow reduce cyclomatic complexity
        if (myLocation.x - 1 >= 0) {
            neighbours.add(grid[myLocation.x - 1][myLocation.y]);
            if (myLocation.y - 1 >= 0) {
                neighbours.add(grid[myLocation.x - 1][myLocation.y - 1]);
            }
            if (myLocation.y + 1 < grid[myLocation.x].length) {
                neighbours.add(grid[myLocation.x - 1][myLocation.y + 1]);
            }
        }
        if (myLocation.y - 1 >= 0) {
            neighbours.add(grid[myLocation.x][myLocation.y - 1]);
        }
        if (myLocation.y + 1 < grid[myLocation.x].length) {
            neighbours.add(grid[myLocation.x][myLocation.y + 1]);
        }

        if (myLocation.x + 1 < grid.length) {
            neighbours.add(grid[myLocation.x + 1][myLocation.y]);
            if (myLocation.y - 1 >= 0) {
                neighbours.add(grid[myLocation.x + 1][myLocation.y - 1]);
            }
            if (myLocation.y + 1 < grid[myLocation.x].length) {
                neighbours.add(grid[myLocation.x + 1][myLocation.y + 1]);
            }
        }
        return neighbours;
    }
}
