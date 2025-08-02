package main.java.com.onepiece.adventure.islands;

import main.java.com.onepiece.adventure.interfaces.Encounter;
import main.java.com.onepiece.adventure.player.Pirate;

public class TreasureIsland extends BaseIsland {
    private Encounter treasure;

    /**
     * Constructor de la isla del tesoro
     * @param treasure Tesoro que contiene la isla
     */
    public TreasureIsland(Encounter treasure) {
        super("Una isla misteriosa con una cueva oculta. Leyendas hablan de grandes tesoros enterrados aquí.");
        this.treasure = treasure;
    }

    @Override
    public void explore(Pirate pirate) {
        System.out.println("Exploras " + description);
        if (!explored && treasure != null) {
            System.out.println("¡Sigues un mapa del tesoro y encuentras algo increíble!");
            treasure.interact(pirate);
            treasure = null; // El tesoro ya fue recogido
            setExplored(true);
        } else if (explored) {
            System.out.println("Ya has saqueado esta isla. Solo quedan hoyos vacíos donde estaba el tesoro.");
        }
    }
}
