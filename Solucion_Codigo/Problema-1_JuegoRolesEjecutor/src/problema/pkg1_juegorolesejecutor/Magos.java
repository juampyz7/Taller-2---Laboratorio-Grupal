
package problema.pkg1_juegorolesejecutor;

public class Magos extends Personaje {

    private int intelecto;
    private int cooldownHabilidad;

    public Magos(String nombre, int puntosDeVida, int ataque, int defensa, int intelecto) {
        // Usamos 100 como energiaMax heredada en lugar de crear una variable de maná propia
        super(nombre, puntosDeVida, ataque, defensa, 100);
        this.intelecto = intelecto;
        this.cooldownHabilidad = 0;
    }

    @Override
    public int calcularAtaque() {
        return this.ataqueBase + this.intelecto;
    }

    @Override
    public int calcularDefensa() {
  
        return this.defensaBase;
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
            usarEnergia(40);
            System.out.println(nombre + " lanza Explosion Arcana.");
            int defensaReducida = objetivo.calcularDefensa() / 2;
            int dañoEspecial = this.calcularAtaque() - defensaReducida;
            if (dañoEspecial < 0) {
                dañoEspecial = 0;
            }

            objetivo.recibirDaño(dañoEspecial);
            this.cooldownHabilidad = 3;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
