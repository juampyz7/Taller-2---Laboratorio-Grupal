
package problema.pkg1_juegorolesejecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Personaje {

    protected String nombre;
    protected int puntosDeVida;
    protected int nivelExperiencia;
    protected int ataque;
    protected int defensa;
    protected List<IEstadoAlterado> estados;
    protected boolean puedeAtacar;

    public Personaje(String nombre, int puntosDeVida, int ataque, int defensa) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.nivelExperiencia = 1;
        this.ataque = ataque;
        this.defensa = defensa;
        this.estados = new ArrayList<>();
        this.puedeAtacar = true;
    }
    public void agregarEstado(IEstadoAlterado estado) {
        this.estados.add(estado);
        System.out.println(">>> " + this.nombre + " ha sido afectado por: " + estado.getNombre());
    }

    public void procesarEstados() {
        this.puedeAtacar = true; // Se reinicia cada turno
        
        Iterator<IEstadoAlterado> iter = estados.iterator();
        while (iter.hasNext()) {
            IEstadoAlterado estado = iter.next();
            estado.aplicarEfecto(this);
            if (estado.haTerminado()) {
                System.out.println("  [ESTADO] El efecto de " + estado.getNombre() + " sobre " + this.nombre + " ha terminado.");
                iter.remove();
            }
        }
    }

    public boolean isPuedeAtacar() {
        return puedeAtacar;
    }

    public void setPuedeAtacar(boolean puedeAtacar) {
        this.puedeAtacar = puedeAtacar;
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