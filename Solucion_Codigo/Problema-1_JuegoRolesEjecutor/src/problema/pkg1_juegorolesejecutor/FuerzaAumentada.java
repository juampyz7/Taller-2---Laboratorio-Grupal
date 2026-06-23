package problema.pkg1_juegorolesejecutor;

public class FuerzaAumentada implements IEstadoAlterado {

    private int turnosRestantes;
    private int bonoAtaque;
    private boolean buffAplicado;

    public FuerzaAumentada(int turnosRestantes, int bonoAtaque) {
        this.turnosRestantes = turnosRestantes;
        this.bonoAtaque = bonoAtaque;
        this.buffAplicado = false;
    }

    @Override
    public void aplicarEfecto(Personaje p) {
        if (!buffAplicado) {
            System.out.println("[BUFF] " + p.getNombre() + " se enfurece y aumenta su ataque en " + bonoAtaque + "!");
            p.ataqueBase += bonoAtaque;
            buffAplicado = true;
        }

        turnosRestantes--;

        if (turnosRestantes <= 0) {
            System.out.println("[BUFF] El aumento de fuerza de " + p.getNombre() + " se ha desvanecido.");
            p.ataqueBase -= bonoAtaque;
        }
    }

    @Override
    public boolean haTerminado() {
        return turnosRestantes <= 0;
    }

    @Override
    public String getNombre() {
        return "Fuerza Aumentada (" + turnosRestantes + " turnos)";
    }
}
