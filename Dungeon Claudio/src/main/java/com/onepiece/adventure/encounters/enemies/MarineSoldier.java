package main.java.com.onepiece.adventure.encounters.enemies;

import main.java.com.onepiece.adventure.player.Pirate;

public class MarineSoldier extends Enemy {

    /**
     * Constructor del soldado marine
     */
    public MarineSoldier() {
        super("Soldado Marine",
                "Un soldado de la Marina con uniforme azul y rifle",
                15, 30, 50000);
    }

    @Override
    public void attack(Pirate pirate) {
        System.out.println("¡El " + name + " grita '¡En nombre de la justicia!' y dispara su rifle!");
        pirate.takeDamage(damage);
    }
}
