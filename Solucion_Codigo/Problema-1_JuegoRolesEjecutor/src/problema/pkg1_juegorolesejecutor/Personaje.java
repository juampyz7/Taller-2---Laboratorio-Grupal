
package problema.pkg1_juegorolesejecutor;

public abstract class Personaje {

    protected String nombre;
    protected int puntosDeVida;
    protected int nivelExperiencia;
    protected int ataque;
    protected int defensa;

    public Personaje(String nombre, int puntosDeVida, int ataque, int defensa) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.nivelExperiencia = 1;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public abstract int calcularAtaque();
    public abstract int calcularDefensa();
    public abstract String usarHabilidadEspecial();

    public void recibirDano(int dano) {
        int danoReal = Math.max(0, dano - calcularDefensa());
        this.puntosDeVida = Math.max(0, this.puntosDeVida - danoReal);
    }

    public void subirNivel() {
        this.nivelExperiencia++;
        this.ataque += 5;
        this.defensa += 3;
        this.puntosDeVida += 20;
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               " | Tipo: " + getClass().getSimpleName() +
               " | HP: " + puntosDeVida +
               " | Nivel: " + nivelExperiencia +
               " | Ataque: " + ataque +
               " | Defensa: " + defensa;
    }
}