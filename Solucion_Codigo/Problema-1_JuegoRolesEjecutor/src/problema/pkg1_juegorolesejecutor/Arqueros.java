package problema.pkg1_juegorolesejecutor;
//clase Arqueros

public class Arqueros extends Personaje {

    private int precision;
    private int flechas;

    public Arqueros(String nombre, int puntosDeVida, int ataque, int defensa,
            int precision, int flechas) {
        super(nombre, puntosDeVida, ataque, defensa);
        this.precision = precision;
        this.flechas = flechas;
    }

    @Override
    public int calcularAtaque() {
        if (flechas > 0) {
            flechas--;
            int bonusPrecision = (precision / 10) * nivelExperiencia;
            return ataque + bonusPrecision;
        }
        return ataque / 2;
    }

    @Override
    public int calcularDefensa() {
        return defensa + (precision / 5) + nivelExperiencia;
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
