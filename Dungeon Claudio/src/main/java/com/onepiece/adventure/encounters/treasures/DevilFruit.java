package main.java.com.onepiece.adventure.encounters.treasures;

import main.java.com.onepiece.adventure.interfaces.Encounter;
import main.java.com.onepiece.adventure.player.Pirate;

public class DevilFruit implements Encounter {
    private String name;
    private String description;
    private String power;
    private int healAmount;

    /**
     * Constructor de la Devil Fruit
     * @param name Nombre de la fruta
     * @param power Poder que otorga
     * @param healAmount Cantidad de vida que restaura al comerla
     */
    public DevilFruit(String name, String power, int healAmount) {
        this.name = name;
        this.power = power;
        this.healAmount = healAmount;
        this.description = "Una misteriosa Akuma no Mi que otorga el poder de " + power;
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
     * Obtiene el poder que otorga la fruta
     * @return Descripción del poder
     */
    public String getPower() {
        return power;
    }

    @Override
    public void interact(Pirate pirate) {
        System.out.println("¡Has encontrado una " + name + "! " + description);
        if (pirate.getDevilFruit().equals("Ninguna")) {
            System.out.println("¡Has comido la Akuma no Mi y ganado nuevos poderes!");
            pirate.setDevilFruit(power);
            pirate.heal(healAmount);
            pirate.increaseBounty(500000);
        } else {
            System.out.println("Ya tienes poderes de Akuma no Mi, pero la vendes por una gran suma!");
            pirate.increaseBounty(1000000);
        }
        pirate.addTreasure(this);
    }
}

