package problema.pkg1_juegorolesejecutor;

public class Guerrero extends Personaje {

    private int fuerza;
    private boolean escudoActivo;

    public Guerrero(String nombre, int puntosDeVida, int ataque, int defensa, int fuerza) {
        super(nombre, puntosDeVida, ataque, defensa);
        this.fuerza = fuerza;
        this.escudoActivo = false;
    }

    @Override
    public int calcularAtaque() {
        return ataque + fuerza + (nivelExperiencia * 3);
    }

    @Override
    public int calcularDefensa() {
        int defensaTotal = defensa + (nivelExperiencia * 2);
        if (escudoActivo) {
            defensaTotal += 15;
            escudoActivo = false;
        }
        return defensaTotal;
    }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        try {
            // El Alumno 3 programará la lógica de cooldowns y costes aquí
            usarEnergia(20);
            System.out.println(nombre + " usa Golpe Devastador (Requiere integración de Cooldowns).");
        } catch (Exception e) {
            System.out.println(nombre + " intentó usar su habilidad especial pero: " + e.getMessage());
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public String toString() {
        return super.toString() + " | Fuerza: " + fuerza;
    }
}
