package problema.pkg1_juegorolesejecutor;

public class SistemaCombate {

    public void iniciarCombate(Personaje jugador1, Personaje jugador2) {
        System.out.println("--- INICIO DEL COMBATE ---");
        System.out.println(jugador1.getNombre() + " VS " + jugador2.getNombre());
        System.out.println("--------------------------\n");

        int turnoActual = 1;

        while (jugador1.getVidaActual() > 0 && jugador2.getVidaActual() > 0) {
            System.out.println("=== TURNO " + turnoActual + " ===");

            ejecutarTurnoPersonaje(jugador1, jugador2);

            if (jugador2.getVidaActual() <= 0) {
                break;
            }

            System.out.println();

            ejecutarTurnoPersonaje(jugador2, jugador1);

            System.out.println("\n--------------------------------------------------");
            turnoActual++;
        }

        mostrarGanador(jugador1, jugador2);
    }

    private void ejecutarTurnoPersonaje(Personaje activo, Personaje objetivo) {
        System.out.println("Turno de: " + activo.getNombre());

        activo.procesarTurno();

        if (activo.getVidaActual() > 0) {
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

    private void mostrarGanador(Personaje jugador1, Personaje jugador2) {
        System.out.println("\n=== FIN DEL COMBATE ===");
        if (jugador1.getVidaActual() <= 0) {
            System.out.println("¡" + jugador2.getNombre() + " ha ganado el combate!");
        } else {
            System.out.println("¡" + jugador1.getNombre() + " ha ganado el combate!");
        }
    }
}

