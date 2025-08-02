package main.java.com.onepiece.adventure.encounters.enemies;

import main.java.com.onepiece.adventure.player.Pirate;

public class PirateBountyHunter extends Enemy {

    /**
     * Constructor del cazarrecompensas
     */
    public PirateBountyHunter() {
        super("Cazarrecompensas",
                "Un peligroso cazarrecompensas con múltiples espadas",
                25, 50, 100000);
    }

    @Override
    public void attack(Pirate pirate) {
        System.out.println("¡El " + name + " desenvaína sus espadas y ataca sin piedad!");
        System.out.println("'¡Tu recompensa será mía!' grita mientras ataca.");
        pirate.takeDamage(damage);
    }
}
