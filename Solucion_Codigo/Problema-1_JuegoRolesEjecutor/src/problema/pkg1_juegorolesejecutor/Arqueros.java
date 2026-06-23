package problema.pkg1_juegorolesejecutor;

public class Arqueros extends Personaje {

    private int precision;
    private int flechas;
    private int cooldownHabilidad;

    public Arqueros(String nombre, int puntosDeVida, int ataque, int defensa, int precision, int flechas) {

        super(nombre, puntosDeVida, ataque, defensa, 60);
        this.precision = precision;
        this.flechas = flechas;
        this.cooldownHabilidad = 0;
    }

    @Override
    public int calcularAtaque() {
        return this.ataqueBase + this.precision;
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

        if (this.flechas < 2) {
            System.out.println(nombre + " no tiene suficientes flechas para la habilidad.");
            return;
        }

        try {
            usarEnergia(25);
            this.flechas -= 2; 
            System.out.println(nombre + " ejecuta Lluvia de Flechas gastando 2 flechas.");

            int dañoPrimerImpacto = (int) (this.calcularAtaque() * 0.8);
            int dañoSegundoImpacto = (int) (this.calcularAtaque() * 0.8);

            objetivo.recibirDaño(dañoPrimerImpacto);
            if (objetivo.getVidaActual() > 0) {
                objetivo.recibirDaño(dañoSegundoImpacto);
            }
            this.cooldownHabilidad = 2;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getPrecision() {
        return precision;
    }

    public int getFlechas() {
        return flechas;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Precision: " + precision + " | Flechas: " + flechas;
    }
}
