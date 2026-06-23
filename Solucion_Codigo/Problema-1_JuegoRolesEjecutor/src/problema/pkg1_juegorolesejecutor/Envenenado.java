
package problema.pkg1_juegorolesejecutor;

public class Envenenado implements IEstadoAlterado {
    private int turnosRestantes;
    private int danoPorTurno;

    public Envenenado(int turnosRestantes, int danoPorTurno) {
        this.turnosRestantes = turnosRestantes;
        this.danoPorTurno = danoPorTurno;
    }

    @Override
    public void aplicarEfecto(Personaje p) {
        if (turnosRestantes > 0) {
            System.out.println("  [ESTADO] " + p.getNombre() + " sufre " + danoPorTurno + " de dano por Veneno.");
            p.recibirDaño(danoPorTurno);
            turnosRestantes--;
        }
    }

    @Override
    public boolean haTerminado() {
        return turnosRestantes <= 0;
    }

    @Override
    public String getNombre() {
        return "Envenenado (" + turnosRestantes + " turnos)";
    }
}
    
