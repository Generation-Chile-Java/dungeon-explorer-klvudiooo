package main.java.com.onepiece.adventure.interfaces;

import main.java.com.onepiece.adventure.player.Pirate;

/**
 * Interfaz que representa un encuentro en las islas
 * Puede ser un tesoro, enemigo, o cualquier objeto interactuable
 */
public interface Encounter {
    /**
     * Obtiene el nombre del encuentro
     * @return Nombre del encuentro
     */
    String getName();

    /**
     * Obtiene la descripción del encuentro
     * @return Descripción textual del encuentro
     */
    String getDescription();

    /**
     * Maneja la interacción del pirata con el encuentro
     * @param pirate El pirata que interactúa
     */
    void interact(Pirate pirate);
}