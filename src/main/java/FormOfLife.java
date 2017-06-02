/**
 * Created by vasilis on 2-6-17.
 */
public class FormOfLife {
    private boolean alive;
    private String aliveRepresentation;
    private String deadRepresentation;

    public FormOfLife(boolean alive, String aliveRepresentation, String deadRepresentation) {
        setAlive(alive);
        setAliveRepresentation(aliveRepresentation);
        setDeadRepresentation(deadRepresentation);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getAliveRepresentation() {
        return aliveRepresentation;
    }

    public void setAliveRepresentation(String aliveRepresentation) {
        this.aliveRepresentation = aliveRepresentation;
    }

    public String getDeadRepresentation() {
        return deadRepresentation;
    }

    public void setDeadRepresentation(String deadRepresentation) {
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
