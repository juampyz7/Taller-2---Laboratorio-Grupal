package problema.pkg1_juegorolesejecutor;

public class Guerrero extends Personaje {

    private int fuerza;
    private boolean escudoActivo;
    private int cooldownHabilidad;

    public Guerrero(String nombre, int puntosDeVida, int ataque, int defensa, int fuerza) {
        super(nombre, puntosDeVida, ataque, defensa, 50);
        this.fuerza = fuerza;
        this.escudoActivo = false;
        this.cooldownHabilidad = 0;
    }

    @Override
    public int calcularAtaque() {
        // Cambiado a ataqueBase para que coincida con tu clase Personaje
        return this.ataqueBase + this.fuerza;
    }

    @Override
    public int calcularDefensa() {
        // Cambiado a defensaBase para que coincida con tu clase Personaje
        int defensaTotal = this.defensaBase;
        if (escudoActivo) {
            defensaTotal += 15;
            escudoActivo = false;
        }
        return defensaTotal;
    }

    @Override
    public void procesarTurno() {
        super.procesarTurno();
        if (cooldownHabilidad > 0) {
            cooldownHabilidad--;
        }
    }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        if (cooldownHabilidad > 0) {
            System.out.println("Habilidad en enfriamiento. Faltan " + cooldownHabilidad + " turnos.");
            return;
        }

        try {
            usarEnergia(30);
            System.out.println(nombre + " ejecuta Golpe Devastador.");
            int dañoEspecial = this.calcularAtaque() * 2;
            objetivo.recibirDaño(dañoEspecial);
            this.cooldownHabilidad = 3;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
