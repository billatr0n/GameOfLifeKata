package com.strategy;

import com.LifeForm;


/**
 * Created by vasilis on 6-6-17.
 */
public interface NextGenStrategy {
     boolean strategyApplies(LifeForm[][] grid,int posX, int posY);
     boolean getNextGen();
     String getReason();
}
