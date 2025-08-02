package main.java.com.onepiece.adventure.encounters.treasures;

import main.java.com.onepiece.adventure.interfaces.Encounter;
import main.java.com.onepiece.adventure.player.Pirate;

public class Meat implements Encounter {
    private String name;
    private String description;
    private int healAmount;

    /**
     * Constructor de la carne
     * @param name Nombre del tipo de carne
     * @param healAmount Cantidad de vida que restaura
     */
    public Meat(String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
        this.description = "Deliciosa carne que restaura " + healAmount + " puntos de vida";
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
     * Obtiene la cantidad de vida que restaura
     * @return Puntos de vida que cura
     */
    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void interact(Pirate pirate) {
        System.out.println("¡Has encontrado " + name + "! " + description);
        System.out.println("¡" + pirate.getName() + " devora la carne con ganas!");
        pirate.heal(healAmount);
        pirate.addTreasure(this);
    }
}
