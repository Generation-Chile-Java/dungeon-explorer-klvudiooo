package main.java.com.onepiece.adventure.islands;

import main.java.com.onepiece.adventure.player.Pirate;

public class DesertIsland extends BaseIsland {

    /**
     * Constructor de la isla desierta
     */
    public DesertIsland() {
        super("Una isla desierta con palmeras y playas de arena blanca. El viento marino susurra entre las hojas.");
    }

    @Override
    public void explore(Pirate pirate) {
        System.out.println("Exploras " + description);
        if (!explored) {
            System.out.println("Caminas por la playa pero solo encuentras conchas marinas...");
            System.out.println("Al menos es un lugar perfecto para descansar.");
            pirate.heal(5); // Pequeña recuperación por el descanso
            setExplored(true);
        } else {
            System.out.println("Ya has explorado esta isla pacífica anteriormente.");
        }
    }
}
