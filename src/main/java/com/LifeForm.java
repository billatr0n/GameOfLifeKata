package com;

import java.awt.*;

/**
 * Created by vasilis on 2-6-17.
 */
public class LifeForm {
    private boolean alive;
    private String aliveRepresentation;
    private String deadRepresentation;
    private Point location;

    public LifeForm() {
    }

    public LifeForm(boolean alive, String aliveRepresentation, String deadRepresentation) {
        setAlive(alive);
        setAliveRepresentation(aliveRepresentation);
        setDeadRepresentation(deadRepresentation);
        setLocation(location);
    }

    public boolean isAlive() {
        return alive;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getAliveRepresentation() {
        return aliveRepresentation;
    }

    private void setAliveRepresentation(String aliveRepresentation) {
        this.aliveRepresentation = aliveRepresentation;
    }

    public String getDeadRepresentation() {
        return deadRepresentation;
    }

    private void setDeadRepresentation(String deadRepresentation) {
        this.deadRepresentation = deadRepresentation;
    }

    public String printExistence() {
        String print;
        if (isAlive())
            print = getAliveRepresentation();
        else
            print = getDeadRepresentation();
        return print;
    }
}
