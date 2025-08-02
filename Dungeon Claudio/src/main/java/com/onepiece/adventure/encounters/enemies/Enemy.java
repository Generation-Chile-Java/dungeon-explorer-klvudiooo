package main.java.com.onepiece.adventure.encounters.enemies;

import main.java.com.onepiece.adventure.interfaces.Encounter;
import main.java.com.onepiece.adventure.player.Pirate;

public abstract class Enemy implements Encounter {
    protected String name;
    protected String description;
    protected int damage;
    protected int health;
    protected long bountyReward;

    /**
     * Constructor del enemigo
     * @param name Nombre del enemigo
     * @param description Descripción del enemigo
     * @param damage Daño que inflige
     * @param health Vida del enemigo
     * @param bountyReward Recompensa por derrotarlo
     */
    public Enemy(String name, String description, int damage, int health, long bountyReward) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.health = health;
        this.bountyReward = bountyReward;
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
     * Método abstracto que define el ataque único de cada enemigo
     * @param pirate El pirata que recibe el ataque
     */
    public abstract void attack(Pirate pirate);

    @Override
    public void interact(Pirate pirate) {
        System.out.println("¡Te enfrentas a " + name + "! " + description);
        attack(pirate);
        if (pirate.isAlive()) {
            System.out.println("¡Has derrotado a " + name + "!");
            pirate.increaseBounty(bountyReward);
        }
    }

    /**
     * Obtiene la recompensa por derrotar al enemigo
     * @return Cantidad de berries de recompensa
     */
    public long getBountyReward() {
        return bountyReward;
    }
}
