package problema.pkg1_juegorolesejecutor;

public class SistemaCombate {

    // Método principal que recibe los modelos y controla el bucle del juego
    public void iniciarCombate(Personaje jugador1, Personaje jugador2) {
        System.out.println("--- INICIO DEL COMBATE ---");
        System.out.println(jugador1.getNombre() + " VS " + jugador2.getNombre());
        System.out.println("--------------------------\n");

        int turnoActual = 1;

        while (jugador1.getVidaActual() > 0 && jugador2.getVidaActual() > 0) {
            System.out.println("=== TURNO " + turnoActual + " ===");

            // Turno del jugador 1
            ejecutarTurnoPersonaje(jugador1, jugador2);

            // Verificar si el jugador 2 murió
            if (jugador2.getVidaActual() <= 0) {
                break;
            }

            System.out.println();

            // Turno del jugador 2
            ejecutarTurnoPersonaje(jugador2, jugador1);

            System.out.println("\n--------------------------------------------------");
            turnoActual++;
        }

        mostrarGanador(jugador1, jugador2);
    }

    // Método interno encargado de procesar la lógica de cada personaje por turno
    private void ejecutarTurnoPersonaje(Personaje activo, Personaje objetivo) {
        System.out.println("Turno de: " + activo.getNombre());
        
        // Se procesan los estados alterados y se reducen los cooldowns
        activo.procesarTurno();

        if (activo.getVidaActual() > 0) {
            // El controlador evalúa de forma polimórfica la energía para decidir la acción
            if (activo instanceof Guerrero && activo.getEnergiaActual() >= 30) {
                activo.usarHabilidadEspecial(objetivo);
            } else if (activo instanceof Arqueros && activo.getEnergiaActual() >= 25) {
                activo.usarHabilidadEspecial(objetivo);
            } else if (activo instanceof Magos && activo.getEnergiaActual() >= 40) {
                activo.usarHabilidadEspecial(objetivo);
            } else {
                activo.atacar(objetivo);
            }
        }
    }

    // Método interno para evaluar y mostrar el desenlace
    private void mostrarGanador(Personaje jugador1, Personaje jugador2) {
        System.out.println("\n=== FIN DEL COMBATE ===");
        if (jugador1.getVidaActual() <= 0) {
            System.out.println("¡" + jugador2.getNombre() + " ha ganado el combate!");
        } else {
            System.out.println("¡" + jugador1.getNombre() + " ha ganado el combate!");
        }
    }
}
