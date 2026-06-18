
package problema.pkg1_juegorolesejecutor;


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
    public String usarHabilidadEspecial() {
        if (flechas >= 3) {
            flechas -= 3;
            int danioLluvia = ataque * 2 + precision;
            return nombre + " usa [Lluvia de Flechas]! Dano: " + danioLluvia + " | Flechas restantes: " + flechas;
        }
        flechas += 10;
        return nombre + " recarga su carcaj. Flechas actuales: " + flechas;
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
