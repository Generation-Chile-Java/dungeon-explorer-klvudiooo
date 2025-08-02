package main.java.com.onepiece.adventure.islands;

import main.java.com.onepiece.adventure.interfaces.Island;

public abstract class BaseIsland implements Island {
    protected String description;
    protected boolean explored;

    /**
     * Constructor de la isla base
     * @param description Descripción de la isla
     */
    public BaseIsland(String description) {
        this.description = description;
        this.explored = false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isExplored() {
        return explored;
    }

    @Override
    public void setExplored(boolean explored) {
        this.explored = explored;
    }
}
