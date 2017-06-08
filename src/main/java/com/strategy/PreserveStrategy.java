package com.strategy;

import com.LifeForm;
import com.utils.NeighbourHelper;

import java.awt.*;
import java.util.List;

/**
 * Created by vasilis on 6-6-17.
 */
public class PreserveStrategy implements NextGenStrategy {

    public boolean strategyApplies(LifeForm[][] grid, int posX, int posY) {
        boolean result = false;
        Point myLifeFormLocation = new Point(posX, posY);
        if (grid[myLifeFormLocation.x][myLifeFormLocation.y].isAlive()) {
            List<LifeForm> neighbours = NeighbourHelper.identifyNeighbours(grid, myLifeFormLocation);
            int amountOfAliveNeighbours = 0;
            for (LifeForm lifeForm : neighbours) {
                if (lifeForm.isAlive())
                    amountOfAliveNeighbours++;
            }
            if (amountOfAliveNeighbours > 1 && amountOfAliveNeighbours < 4) {
                result = true;
            }

        }
        return result;
    }
}
