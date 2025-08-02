package main.java.com.onepiece.adventure.utils;

public class GameUtils {

    /**
     * Crea una línea separadora con el carácter especificado
     * @param character Carácter para la línea
     * @param length Longitud de la línea
     * @return String con la línea separadora
     */
    public static String createSeparatorLine(String character, int length) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append(character);
        }
        return line.toString();
    }

    /**
     * Crea el header decorativo para las islas
     * @param islandNumber Número de la isla actual
     * @param totalIslands Total de islas
     * @return String con el header formateado
     */
    public static String createIslandHeader(int islandNumber, int totalIslands) {
        String separator = createSeparatorLine(GameConstants.ANCHOR_SEPARATOR, 25);
        String header = "🏝️  ISLA " + islandNumber + " de " + totalIslands + " - GRAND LINE  🏝️";
        return "\n" + separator + "\n" + header + "\n" + separator;
    }

    /**
     * Crea el header de victoria
     * @return String con el header de victoria
     */
    public static String createVictoryHeader() {
        String separator = createSeparatorLine(GameConstants.TROPHY_SEPARATOR, 25);
        String header = "🏆  ¡VICTORIA EN LA GRAND LINE!  🏆";
        return "\n" + separator + "\n" + header + "\n" + separator;
    }

    /**
     * Crea el header de derrota
     * @return String con el header de derrota
     */
    public static String createDefeatHeader() {
        String separator = createSeparatorLine(GameConstants.SKULL_SEPARATOR, 25);
        String header = "💀  GAME OVER - FIN DE LA AVENTURA  💀";
        return "\n" + separator + "\n" + header + "\n" + separator;
    }

    /**
     * Formatea el estado de salud del pirata con barra visual
     * @param currentHealth Vida actual
     * @param maxHealth Vida máxima
     * @return String con la barra de vida formateada
     */
    public static String formatHealthBar(int currentHealth, int maxHealth) {
        int barLength = 20;
        int filledBars = (int) ((double) currentHealth / maxHealth * barLength);

        StringBuilder healthBar = new StringBuilder("❤️ ");
        healthBar.append("[");

        for (int i = 0; i < barLength; i++) {
            if (i < filledBars) {
                if (currentHealth > maxHealth * 0.6) {
                    healthBar.append("█"); // Verde/lleno
                } else if (currentHealth > maxHealth * 0.3) {
                    healthBar.append("▓"); // Amarillo/medio
                } else {
                    healthBar.append("░"); // Rojo/bajo
                }
            } else {
                healthBar.append(" ");
            }
        }

        healthBar.append("] ");
        healthBar.append(currentHealth).append("/").append(maxHealth);
        return healthBar.toString();
    }

    /**
     * Formatea la recompensa con el símbolo de berries
     * @param bounty Cantidad de la recompensa
     * @return String con la recompensa formateada
     */
    public static String formatBounty(long bounty) {
        return GameConstants.CURRENCY_SYMBOL + String.format("%,d", bounty);
    }

    /**
     * Crea un mensaje de combate formateado
     * @param attackerName Nombre del atacante
     * @param defenderName Nombre del defensor
     * @param damage Daño infligido
     * @return String con el mensaje de combate
     */
    public static String formatCombatMessage(String attackerName, String defenderName, int damage) {
        return "⚔️ " + attackerName + " ataca a " + defenderName + " causando " + damage + " de daño!";
    }

    /**
     * Crea un título centrado con decoración
     * @param title Título a mostrar
     * @param width Ancho total del título
     * @return String con el título decorado y centrado
     */
    public static String createCenteredTitle(String title, int width) {
        int padding = Math.max(0, (width - title.length()) / 2);
        StringBuilder centeredTitle = new StringBuilder();

        for (int i = 0; i < padding; i++) {
            centeredTitle.append(" ");
        }
        centeredTitle.append(title);

        return centeredTitle.toString();
    }

    /**
     * Valida si una entrada numérica está en el rango válido
     * @param input Entrada a validar
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return true si está en rango, false si no
     */
    public static boolean isValidChoice(int input, int min, int max) {
        return input >= min && input <= max;
    }

    /**
     * Crea un mensaje de tesoro encontrado
     * @param treasureName Nombre del tesoro
     * @param pirateeName Nombre del pirata
     * @return String with formatted treasure message
     */
    public static String formatTreasureFound(String treasureName, String pirateeName) {
        return "💎 ¡" + pirateeName + " ha encontrado: " + treasureName + "! 💎";
    }

    /**
     * Crea una pausa dramática en el juego
     * @param seconds Segundos de pausa
     */
    public static void dramaticPause(int seconds) {
        try {
            for (int i = 0; i < seconds; i++) {
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Genera un efecto de escritura letra por letra
     * @param text Texto a mostrar
     * @param delayMs Delay en milisegundos entre caracteres
     */
    public static void typewriterEffect(String text, int delayMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println();
    }
}