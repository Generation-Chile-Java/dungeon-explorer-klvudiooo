package main.java.com.onepiece.adventure.player;


import main.java.com.onepiece.adventure.interfaces.Encounter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa al jugador pirata
 * Encapsula todos los datos y comportamientos del personaje principal
 */
public class Pirate {
    private String name;
    private int health;
    private int maxHealth;
    private long bounty;
    private List<Encounter> treasures;
    private String devilFruit;

    /**
     * Constructor del pirata
     * @param name Nombre del pirata
     * @param initialHealth Vida inicial del pirata
     */
    public Pirate(String name, int initialHealth) {
        this.name = name;
        this.health = initialHealth;
        this.maxHealth = initialHealth;
        this.bounty = 0;
        this.treasures = new ArrayList<>();
        this.devilFruit = "Ninguna";
    }

    // Métodos públicos para acceder a los atributos privados (Encapsulación)

    /**
     * Obtiene el nombre del pirata
     * @return Nombre del pirata
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la vida actual del pirata
     * @return Vida actual
     */
    public int getHealth() {
        return health;
    }

    /**
     * Obtiene la vida máxima del pirata
     * @return Vida máxima
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Obtiene la recompensa actual del pirata
     * @return Recompensa en berries
     */
    public long getBounty() {
        return bounty;
    }

    /**
     * Obtiene la Akuma no Mi del pirata
     * @return Poder de la Devil Fruit o "Ninguna"
     */
    public String getDevilFruit() {
        return devilFruit;
    }

    /**
     * Establece la Akuma no Mi del pirata
     * @param devilFruit Poder de la Devil Fruit
     */
    public void setDevilFruit(String devilFruit) {
        this.devilFruit = devilFruit;
    }

    /**
     * Obtiene una copia de la lista de tesoros (mantiene encapsulación)
     * @return Lista de tesoros del pirata
     */
    public List<Encounter> getTreasures() {
        return new ArrayList<>(treasures);
    }

    /**
     * El pirata recibe daño
     * @param damage Cantidad de daño recibido
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " recibe " + damage + " puntos de daño! Vida restante: " + health);
    }

    /**
     * El pirata se cura
     * @param healAmount Cantidad de vida recuperada
     */
    public void heal(int healAmount) {
        health += healAmount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println(name + " se recupera " + healAmount + " puntos de vida! Vida actual: " + health);
    }

    /**
     * Añade un tesoro al inventario del pirata
     * @param treasure Tesoro a añadir
     */
    public void addTreasure(Encounter treasure) {
        treasures.add(treasure);
        System.out.println("¡" + treasure.getName() + " añadido a tu tesoro!");
    }

    /**
     * Aumenta la recompensa del pirata
     * @param amount Cantidad a aumentar
     */
    public void increaseBounty(long amount) {
        bounty += amount;
        System.out.println("¡Tu recompensa ha aumentado en ฿" + amount + "! Recompensa total: ฿" + bounty);
    }

    /**
     * Verifica si el pirata está vivo
     * @return true si está vivo, false si no
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Muestra el estado completo del pirata
     */
    public void showStatus() {
        System.out.println("\n=== Estado del Pirata ===");
        System.out.println("Nombre: " + name);
        System.out.println("Vida: " + health + "/" + maxHealth);
        System.out.println("Recompensa: ฿" + bounty);
        System.out.println("Akuma no Mi: " + devilFruit);
        System.out.println("Tesoros (" + treasures.size() + " objetos):");
        if (treasures.isEmpty()) {
            System.out.println("  - Sin tesoros");
        } else {
            for (Encounter treasure : treasures) {
                System.out.println("  - " + treasure.getName());
            }
        }
        System.out.println("========================\n");
    }
}
