package problema.pkg1_juegorolesejecutor;

public class Congelado implements IEstadoAlterado {

    private int turnosRestantes;

    public Congelado(int turnosRestantes) {
        this.turnosRestantes = turnosRestantes;
    }

    @Override
    public void aplicarEfecto(Personaje p) {
        if (turnosRestantes > 0) {
            System.out.println("[ESTADO] " + p.getNombre() + " está congelado y pierde su turno.");
            turnosRestantes--;
        }
    }

    @Override
    public boolean haTerminado() {
        return turnosRestantes <= 0;
    }

    @Override
    public String getNombre() {
        return "Congelado (" + turnosRestantes + " turnos)";
    }
}
