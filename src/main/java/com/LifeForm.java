package com;

import java.awt.*;

/**
 * Created by vasilis on 2-6-17.
 */
public class LifeForm {
    private boolean alive;
    private Point location;

    public LifeForm() {
    }

    public LifeForm(boolean alive) {
        this.alive = alive;
    }

    public final boolean isAlive() {
        return alive;
    }

    public final Point getLocation() {
        return location;
    }

    public final void setLocation(Point location) {
        this.location = location;
    }
}
