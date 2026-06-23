package problema.pkg1_juegorolesejecutor;

public class SistemaCombate {

   public String ejecutarRonda(Personaje atacante, Personaje defensor) {
        StringBuilder resultado = new StringBuilder();
        
        atacante.procesarEstados();
        
        if (!atacante.estaVivo()) {
            return atacante.getNombre() + " ha caido por sus estados alterados antes de atacar.";
        }
        
        if (!atacante.isPuedeAtacar()) {
            return atacante.getNombre() + " no puede atacar este turno debido a un estado.";
        }

        int danoAtacante = atacante.calcularAtaque();
        defensor.recibirDano(danoAtacante);
        resultado.append(atacante.getNombre())
                 .append(" ataca a ")
                 .append(defensor.getNombre())
                 .append(" con ")
                 .append(danoAtacante)
                 .append(" de ataque. HP de ")
                 .append(defensor.getNombre())
                 .append(": ")
                 .append(defensor.getPuntosDeVida());
                 
        return resultado.toString();
    }

    public String ejecutarBatalla(Personaje p1, Personaje p2) {
        StringBuilder log = new StringBuilder();
        log.append("===== INICIO DE BATALLA =====\n");
        log.append(p1.toString()).append("\n");
        log.append(p2.toString()).append("\n\n");

        int ronda = 1;
        while (p1.estaVivo() && p2.estaVivo()) {
            log.append("-- Ronda ").append(ronda).append(" --\n");

            if (ronda % 3 == 0) {
                log.append(p1.usarHabilidadEspecial()).append("\n");
                log.append(p2.usarHabilidadEspecial()).append("\n");
            }

            log.append(ejecutarRonda(p1, p2)).append("\n");
            if (!p2.estaVivo()) break;

            log.append(ejecutarRonda(p2, p1)).append("\n");
            ronda++;
        }

        log.append("\n===== FIN DE BATALLA =====\n");
        if (p1.estaVivo()) {
            p1.subirNivel();
            log.append("Ganador: ").append(p1.getNombre()).append(" | Sube al nivel ").append(p1.getNivelExperiencia()).append("\n");
            log.append(p1.toString());
        } else {
            p2.subirNivel();
            log.append("Ganador: ").append(p2.getNombre()).append(" | Sube al nivel ").append(p2.getNivelExperiencia()).append("\n");
            log.append(p2.toString());
        }

        return log.toString();
    }
}