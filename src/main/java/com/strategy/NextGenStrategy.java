package com.strategy;

import com.LifeForm;

import java.util.List;

/**
 * Created by vasilis on 6-6-17.
 */
public interface NextGenStrategy {
     boolean strategyApplies(LifeForm[][] grid,int posX, int posY);
    List<LifeForm> identifyNeighbours(LifeForm[][] grid);
}
