package main.java.com.onepiece.adventure.encounters.enemies;

import main.java.com.onepiece.adventure.player.Pirate;

public class SeaKing extends Enemy {

    /**
     * Constructor del Rey del Mar
     */
    public SeaKing() {
        super("Rey del Mar",
                "Una enorme criatura marina con dientes afilados como cuchillas",
                35, 70, 200000);
    }

    @Override
    public void attack(Pirate pirate) {
        System.out.println("¡El " + name + " emerge del agua y trata de devorarte con sus enormes fauces!");
        System.out.println("¡Sus rugidos hacen temblar toda la isla!");
        pirate.takeDamage(damage);
    }
}
