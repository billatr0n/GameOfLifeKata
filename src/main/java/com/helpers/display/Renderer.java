package com.helpers.display;

import com.LifeForm;

/**
 * Created by vasilis on 14-6-17.
 */
public interface Renderer {
     String renderWorld(LifeForm[][] world);
     String renderLifeForm(LifeForm lifeForm);
}
