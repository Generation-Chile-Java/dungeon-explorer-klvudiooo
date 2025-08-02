package main.java.com.onepiece.adventure.interfaces;


import main.java.com.onepiece.adventure.player.Pirate;

/**
 * Interfaz que representa una isla en la Grand Line
 * Define el comportamiento común de todas las islas
 */
public interface Island {
    /**
     * Permite al pirata explorar la isla
     * @param pirate El pirata que explora la isla
     */
    void explore(Pirate pirate);

    /**
     * Obtiene la descripción de la isla
     * @return Descripción textual de la isla
     */
    String getDescription();

    /**
     * Verifica si la isla ya fue explorada
     * @return true si ya fue explorada, false si no
     */
    boolean isExplored();

    /**
     * Marca la isla como explorada o no explorada
     * @param explored Estado de exploración de la isla
     */
    void setExplored(boolean explored);
}