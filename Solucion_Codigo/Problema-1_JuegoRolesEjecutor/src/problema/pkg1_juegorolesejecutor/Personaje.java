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
    protected int vidaMax;
    protected int vidaActual;
    protected int ataqueBase;
    protected int defensaBase;

    // Preparación para Alumno 3: Energía/Maná para habilidades
    protected int energiaActual;
    protected int energiaMax;

    // Preparación para Alumno 2: Lista de estados alterados
    protected List<IEstadoAlterado> estadosActivos;

    // Preparación para Alumno 1: Objeto equipado (puede iniciar en null)
    // Nota: Temporalmente usamos Object o una clase vacía hasta que se cree 'Objeto'
    protected Object objetoEquipado;

    public Personaje(String nombre, int vidaMax, int ataqueBase, int defensaBase, int energiaMax) {
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
        this.vidaMax = vidaMax;
        this.vidaActual = vidaMax;
        this.ataqueBase = ataqueBase;
        this.defensaBase = defensaBase;
        this.energiaMax = energiaMax;
        this.energiaActual = energiaMax;
        this.estadosActivos = new ArrayList<>();
        this.objetoEquipado = null;
    }

    // Métodos dinámicos listos para ser modificados por el Alumno 1 (Inventario)
    public int calcularAtaque() {
        int total = this.ataqueBase;
        if (objetoEquipado instanceof Arma) {
            total += ((Arma) objetoEquipado).getBonificadorAtaque(); // [cite: 21]
        }
        return total;
    }

    public int calcularDefensa() {
        int total = this.defensaBase;
        if (objetoEquipado instanceof Armadura) {
            total += ((Armadura) objetoEquipado).getBonificadorDefensa();
        }
        return total;
    }

    public void atacar(Personaje objetivo) {
        if (tieneEstado("Congelado")) {
            System.out.println(nombre + " está congelado y no puede atacar.");
            return;
        }
        int daño = this.calcularAtaque() - objetivo.calcularDefensa();
        if (daño < 0) {
            daño = 0;
        }

        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " causando " + daño + " de daño.");
        objetivo.recibirDaño(daño);

        // NUEVA MECÁNICA: Recuperar energía al infligir daño (Genera 10 de energía)
        if (daño > 0) {
            this.setEnergiaActual(this.energiaActual + 10);
            System.out.println("¡" + nombre + " recupera 10 de energía por atacar! (" + energiaActual + "/" + energiaMax + ")");
        }
    }

    public void recibirDaño(int cantidad) {
        this.vidaActual -= cantidad;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
        System.out.println(nombre + " ahora tiene " + vidaActual + "/" + vidaMax + " de HP.");

        // NUEVA MECÁNICA: Recuperar energía al recibir daño (Genera 15 de energía por el impacto)
        if (cantidad > 0 && vidaActual > 0) {
            this.setEnergiaActual(this.energiaActual + 15);
            System.out.println("¡" + nombre + " acumula 15 de energía por el impacto recibido! (" + energiaActual + "/" + energiaMax + ")");
        }
    }

    // Preparación para Alumno 2: Procesamiento de estados al inicio del turno
    public void procesarTurno() {
        // Aplicar efectos (como veneno que quita vida)
        for (int i = estadosActivos.size() - 1; i >= 0; i--) {
            IEstadoAlterado estado = estadosActivos.get(i);
            estado.aplicarEfecto(this);
            estado.reducirTurno();
            if (!estado.estaActivo()) {
                System.out.println("El estado " + estado.getNombre() + " ha expirado en " + nombre);
                estadosActivos.remove(i);
            }
        }
    }

    // Métodos auxiliares requeridos por las ramas
    public void agregarEstado(IEstadoAlterado estado) {
        this.estadosActivos.add(estado);
    }

    public boolean tieneEstado(String nombreEstado) {
        return estadosActivos.stream().anyMatch(e -> e.getNombre().equalsIgnoreCase(nombreEstado));
    }

    public void equiparObjeto(Object objeto) {
        this.objetoEquipado = objeto;
    }

    // Getters y Setters fundamentales
    public String getNombre() {
        return nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = Math.min(vidaActual, vidaMax);
    }

    public int getEnergiaActual() {
        return energiaActual;
    }

    public void setEnergiaActual(int energiaActual) {
        this.energiaActual = Math.min(energiaActual, energiaMax);
    }

    // Excepción sugerida para el Alumno 3
    public void usarEnergia(int cantidad) throws Exception {
        if (this.energiaActual < cantidad) {
            throw new Exception("¡No hay suficiente energía!");
        }
        this.energiaActual -= cantidad;
    }

    // El Alumno 3 heredará esto para implementar habilidades específicas
    public abstract void usarHabilidadEspecial(Personaje objetivo);
}
