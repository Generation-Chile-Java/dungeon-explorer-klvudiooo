package main.java.com.onepiece.adventure.encounters.enemies;

import main.java.com.onepiece.adventure.player.Pirate;

public class CPAgent extends Enemy {

    /**
     * Constructor del agente CP9
     */
    public CPAgent() {
        super("Agente CP9",
                "Un agente del Cipher Pol con técnicas de Rokushiki",
                40, 80, 300000);
    }

    @Override
    public void attack(Pirate pirate) {
        System.out.println("¡El " + name + " usa Soru para aparecer detrás de ti!");
        System.out.println("'Tekkai Kenpo!' grita mientras lanza un ataque devastador.");
        pirate.takeDamage(damage);
    }
}
