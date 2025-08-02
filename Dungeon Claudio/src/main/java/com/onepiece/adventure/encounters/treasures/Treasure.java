package main.java.com.onepiece.adventure.encounters.treasures;

import main.java.com.onepiece.adventure.interfaces.Encounter;
import main.java.com.onepiece.adventure.player.Pirate;

public class Treasure implements Encounter {
    private String name;
    private String description;
    private long value;

    /**
     * Constructor del tesoro
     * @param name Nombre del tesoro
     * @param description Descripción del tesoro
     * @param value Valor en berries del tesoro
     */
    public Treasure(String name, String description, long value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene el valor del tesoro
     * @return Valor en berries
     */
    public long getValue() {
        return value;
    }

    @Override
    public void interact(Pirate pirate) {
        System.out.println("¡Has encontrado " + name + "! " + description);
        pirate.addTreasure(this);
        pirate.increaseBounty(value);
    }
}

