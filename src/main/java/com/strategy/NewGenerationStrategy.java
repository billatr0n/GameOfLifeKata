package com.strategy;

import com.LifeForm;

import java.util.List;

/**
 * Created by vasilis on 12-6-17.
 */
public class NewGenerationStrategy {
    private List<NextGenStrategy> rules;
    private LifeForm[][] world;

    public NewGenerationStrategy(LifeForm[][] world, List<NextGenStrategy> rules) {
        this.world = world;
        this.rules = rules;
    }

    public final LifeForm generateNextGen(LifeForm oldLifeForm) {
        if (oldLifeForm == null) {
            return null;
        }
        LifeForm newLifeForm = oldLifeForm;
        for (NextGenStrategy rule : rules) {
            if (rule.strategyApplies(world, oldLifeForm.getLocation().x, oldLifeForm.getLocation().y)) {
                newLifeForm = new LifeForm(rule.getNextGen());
            }
        }
        return newLifeForm;
    }

}
