package main.java.com.onepiece.adventure.islands;

import main.java.com.onepiece.adventure.encounters.enemies.Enemy;
import main.java.com.onepiece.adventure.encounters.enemies.PirateBountyHunter;
import main.java.com.onepiece.adventure.player.Pirate;

public class DangerousIsland extends BaseIsland {
    private Enemy enemy;

    /**
     * Constructor de la isla peligrosa
     * @param enemy Enemigo que habita la isla
     */
    public DangerousIsland(Enemy enemy) {
        super("Una isla peligrosa con un ambiente hostil. Sientes una presencia amenazante acechando.");
        this.enemy = enemy;
    }

    @Override
    public void explore(Pirate pirate) {
        System.out.println("Exploras " + description);
        if (!explored && enemy != null) {
            System.out.println("¡De repente, aparece un enemigo!");
            enemy.interact(pirate);
            if (pirate.isAlive()) {
                enemy = null; // El enemigo ya fue derrotado
                setExplored(true);
            }
        } else if (explored) {
            System.out.println("Los restos de tu batalla anterior están esparcidos. La isla ahora está en calma.");
        }
    }
}
