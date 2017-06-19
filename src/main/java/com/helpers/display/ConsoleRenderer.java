package com.helpers.display;

import com.LifeForm;
import com.helpers.constants.RepresentationsConstants;

/**
 * Created by vasilis on 14-6-17.
 */
public class ConsoleRenderer implements Renderer {

    public ConsoleRenderer() {

    }

    public final String renderWorld(LifeForm[][] world) {
        StringBuffer buffer = new StringBuffer();
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[0].length; y++) {
                buffer.append(renderLifeForm(world[x][y]));
            }
            buffer.append("\n");
        }
        String gridString = buffer.toString();
        System.out.println(gridString);
        return gridString;
    }

    public final String renderLifeForm(LifeForm lifeForm) {
        String resultString;
        if (lifeForm.isAlive()) {
            resultString = RepresentationsConstants.ALIVE_LIFEFORM_REPRESENTATION;
        } else {
            resultString = RepresentationsConstants.DEAD_LIFEFORM_REPRESENTATION;
        }
        return resultString;
    }
}