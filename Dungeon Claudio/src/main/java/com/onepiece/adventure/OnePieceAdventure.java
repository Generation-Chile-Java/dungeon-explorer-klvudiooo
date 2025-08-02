package main.java.com.onepiece.adventure;

import main.java.com.onepiece.adventure.encounters.enemies.Enemy;
import main.java.com.onepiece.adventure.encounters.enemies.MarineSoldier;
import main.java.com.onepiece.adventure.encounters.enemies.PirateBountyHunter;
import main.java.com.onepiece.adventure.encounters.enemies.SeaKing;
import main.java.com.onepiece.adventure.encounters.treasures.DevilFruit;
import main.java.com.onepiece.adventure.encounters.treasures.Meat;
import main.java.com.onepiece.adventure.encounters.treasures.Treasure;
import main.java.com.onepiece.adventure.interfaces.Island;
import main.java.com.onepiece.adventure.islands.DangerousIsland;
import main.java.com.onepiece.adventure.islands.DesertIsland;
import main.java.com.onepiece.adventure.islands.TreasureIsland;
import main.java.com.onepiece.adventure.player.Pirate;
import main.java.com.onepiece.adventure.utils.GameConstants;
import main.java.com.onepiece.adventure.utils.GameUtils;

import java.util.Scanner;
import java.util.Random;

/**
 * Clase principal del juego One Piece Adventure
 * Contiene el método main() y la lógica principal del juego
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class OnePieceAdventure {
    private Pirate pirate;
    private Island[] grandLine;
    private int currentIsland;
    private Scanner scanner;
    private Random random;

    /**
     * Constructor del juego
     * Inicializa los componentes necesarios
     */
    public OnePieceAdventure() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    /**
     * Método principal que inicia la aventura
     */
    public void startAdventure() {
        showGameTitle();
        initializePirate();
        createGrandLine();
        currentIsland = 0;

        showWelcomeMessage();
        adventureLoop();
    }

    /**
     * Muestra el título decorativo del juego
     */
    private void showGameTitle() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     " + GameConstants.GAME_TITLE + "      ║");
        System.out.println("║           🏴‍☠️ ⚓ 🗺️ 💰            ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    /**
     * Inicializa el pirata jugador
     */
    private void initializePirate() {
        System.out.println("\n" + GameConstants.WELCOME_MESSAGE);
        System.out.print("¿Cuál es tu nombre, pirata? ");
        String pirateName = scanner.nextLine();
        pirate = new Pirate(pirateName, GameConstants.INITIAL_PIRATE_HEALTH);
    }

    /**
     * Muestra el mensaje de bienvenida personalizado
     */
    private void showWelcomeMessage() {
        System.out.println("\n¡" + pirate.getName() + ", tu aventura pirata comienza ahora!");
        System.out.println("Has entrado en la Grand Line con " + GameConstants.TOTAL_ISLANDS + " islas misteriosas por explorar.");
        System.out.println("¡Tu sueño de encontrar el One Piece está al alcance de tus manos!");
    }

    /**
     * Crea la ruta de islas de la Grand Line usando polimorfismo
     */
    private void createGrandLine() {
        grandLine = new Island[GameConstants.TOTAL_ISLANDS];

        // Crear diferentes tipos de islas usando polimorfismo
        grandLine[0] = new DesertIsland();
        grandLine[1] = new TreasureIsland(
                new Treasure("Cofre del Tesoro Pirata", "Un cofre lleno de berries brillantes", 100000)
        );
        grandLine[2] = new DangerousIsland(new MarineSoldier());
        grandLine[3] = new TreasureIsland(
                new Meat("Carne de Rey del Mar", 40)
        );
        grandLine[4] = new DangerousIsland(new PirateBountyHunter());
        grandLine[5] = new TreasureIsland(
                new DevilFruit("Gomu Gomu no Mi", "elasticidad", 25)
        );
        grandLine[6] = new DangerousIsland(new SeaKing());
        grandLine[7] = new TreasureIsland(
                new Treasure("Fragmento del Road Poneglyph", "Una piedra antigua que revela secretos del One Piece", 1000000)
        );
    }

    /**
     * Bucle principal del juego
     * Maneja la navegación entre islas y la interacción del usuario
     */
    private void adventureLoop() {
        while (pirate.isAlive() && currentIsland < grandLine.length) {
            // Mostrar header de la isla actual
            System.out.println(GameUtils.createIslandHeader(currentIsland + 1, grandLine.length));

            // Explorar la isla actual
            grandLine[currentIsland].explore(pirate);

            // Verificar si el pirata sigue vivo
            if (!pirate.isAlive()) {
                gameOver();
                return;
            }

            // Mostrar opciones al jugador
            showGameOptions();

            // Procesar la elección del jugador
            int choice = getPirateChoice();
            processPlayerChoice(choice);
        }

        // El juego terminó - verificar condición de victoria
        if (pirate.isAlive()) {
            victory();
        }
    }

    /**
     * Muestra las opciones disponibles para el pirata
     */
    private void showGameOptions() {
        System.out.println("\n🏴‍☠️ ¿Qué deseas hacer, pirata?");
        System.out.println("1. " + GameConstants.OPTION_NAVIGATE);
        System.out.println("2. " + GameConstants.OPTION_STATUS);
        System.out.println("3. " + GameConstants.OPTION_QUIT);
    }

    /**
     * Obtiene y valida la elección del jugador
     * @return Número de opción elegida (1-3)
     */
    private int getPirateChoice() {
        while (true) {
            try {
                System.out.print("Elige tu acción (1-3): ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 3) {
                    return choice;
                }
                System.out.println("¡Elige una opción válida, marinero! (1-3)");
            } catch (NumberFormatException e) {
                System.out.println("¡Ingresa un número válido!");
            }
        }
    }

    /**
     * Procesa la elección del jugador
     * @param choice Opción elegida por el jugador
     */
    private void processPlayerChoice(int choice) {
        switch (choice) {
            case 1:
                navigateToNextIsland();
                break;
            case 2:
                pirate.showStatus();
                break;
            case 3:
                quitGame();
                break;
        }
    }

    /**
     * Navega a la siguiente isla
     */
    private void navigateToNextIsland() {
        if (currentIsland < grandLine.length - 1) {
            System.out.println("⛵ ¡Izas las velas y navegas hacia la siguiente isla!");
            currentIsland++;
        } else {
            System.out.println("🌊 Has alcanzado el final de tu ruta en la Grand Line.");
            currentIsland++;
        }
    }

    /**
     * Maneja la salida voluntaria del juego
     */
    private void quitGame() {
        System.out.println("🏴‍☠️ ¡Decidiste retirarte de la vida pirata!");
        System.out.println("A veces es mejor vivir para luchar otro día...");
        scanner.close();
        System.exit(0);
    }

    /**
     * Maneja el final del juego por derrota
     */
    private void gameOver() {
        String separator = GameUtils.createSeparatorLine(GameConstants.SKULL_SEPARATOR, 25);

        System.out.println("\n" + separator);
        System.out.println("        GAME OVER - DERROTA        ");
        System.out.println(separator);
        System.out.println("😵 " + pirate.getName() + " ha caído en batalla...");
        System.out.println("Tu sueño de ser el Rey de los Piratas termina aquí,");
        System.out.println("pero tu leyenda vivirá para siempre en la Grand Line.");
        System.out.println("\n" + GameConstants.TEACH_QUOTE);
        pirate.showStatus();
        scanner.close();
    }

    /**
     * Maneja el final del juego por victoria
     */
    private void victory() {
        String separator = GameUtils.createSeparatorLine(GameConstants.TROPHY_SEPARATOR, 25);

        System.out.println("\n" + separator);
        System.out.println("      ¡AVENTURA COMPLETADA!      ");
        System.out.println(separator);
        System.out.println("🎉 ¡Felicidades, " + pirate.getName() + "!");
        System.out.println("Has completado tu viaje por esta sección de la Grand Line.");
        System.out.println("Aunque aún no has encontrado el One Piece,");
        System.out.println("¡estás un paso más cerca de convertirte en el Rey de los Piratas!");
        System.out.println("\n" + GameConstants.ROGER_QUOTE);

        // Mensaje especial basado en la recompensa
        showPirateRanking();

        pirate.showStatus();
        scanner.close();
    }

    /**
     * Muestra el ranking del pirata basado en su recompensa
     */
    private void showPirateRanking() {
        long bounty = pirate.getBounty();

        if (bounty >= GameConstants.SUPERNOVA_BOUNTY) {
            System.out.println("\n🌟 ¡Eres considerado un Supernova! Tu recompensa es legendaria.");
        } else if (bounty >= GameConstants.RESPECTED_PIRATE_BOUNTY) {
            System.out.println("\n⭐ ¡Eres un pirata respetado en la Grand Line!");
        } else {
            System.out.println("\n🌱 ¡Eres un pirata novato con gran potencial!");
        }
    }

    /**
     * Método main - Punto de entrada del programa
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        try {
            OnePieceAdventure adventure = new OnePieceAdventure();
            adventure.startAdventure();
        } catch (Exception e) {
            System.err.println("¡Ha ocurrido un error en tu aventura pirata!");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
