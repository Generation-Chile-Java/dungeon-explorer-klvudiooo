package main.java.com.onepiece.adventure.utils;

public class GameConstants {

    // Configuración del pirata
    public static final int INITIAL_PIRATE_HEALTH = 100;
    public static final int DESERT_ISLAND_HEAL = 5;

    // Configuración de las islas
    public static final int TOTAL_ISLANDS = 8;

    // Símbolos y texto
    public static final String CURRENCY_SYMBOL = "฿";
    public static final String ANCHOR_SEPARATOR = "⚓";
    public static final String TROPHY_SEPARATOR = "🏆";
    public static final String SKULL_SEPARATOR = "💀";

    // Recompensas por Devil Fruits
    public static final long DEVIL_FRUIT_FIRST_REWARD = 500000;
    public static final long DEVIL_FRUIT_SELL_REWARD = 1000000;

    // Clasificaciones de recompensas
    public static final long SUPERNOVA_BOUNTY = 1000000;
    public static final long RESPECTED_PIRATE_BOUNTY = 500000;

    // Mensajes del juego
    public static final String GAME_TITLE = "ONE PIECE: GRAND LINE ADVENTURE";
    public static final String WELCOME_MESSAGE = "¡Bienvenido a la Grand Line, futuro Rey de los Piratas!";
    public static final String ROGER_QUOTE = "'¡El One Piece existe!' - Gol D. Roger";
    public static final String TEACH_QUOTE = "'¡Los sueños de las personas nunca terminan!' - Marshall D. Teach";

    // Opciones del menú
    public static final String OPTION_NAVIGATE = "⛵ Navegar a la siguiente isla";
    public static final String OPTION_STATUS = "📊 Ver estado del pirata";
    public static final String OPTION_QUIT = "🚪 Abandonar la aventura";

    // Prevenir instanciación
    private GameConstants() {
        throw new AssertionError("No se debe instanciar GameConstants");
    }
}