package problema.pkg1_juegorolesejecutor;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {

    protected String nombre;
    protected int vidaMax;
    protected int vidaActual;
    protected int ataqueBase;
    protected int defensaBase;
    protected int energiaActual;
    protected int energiaMax;
    protected List<IEstadoAlterado> estadosActivos;
    protected Object objetoEquipado;

    public Personaje(String nombre, int vidaMax, int ataqueBase, int defensaBase, int energiaMax) {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vidaActual = vidaMax;
        this.ataqueBase = ataqueBase;
        this.defensaBase = defensaBase;
        this.energiaMax = energiaMax;
        this.energiaActual = energiaMax;
        this.estadosActivos = new ArrayList<>();
        this.objetoEquipado = null;
    }

    public int calcularAtaque() {
        return this.ataqueBase;
    }

    public int calcularDefensa() {
        return this.defensaBase;
    }

    public void atacar(Personaje objetivo) {
        if (tieneEstado("Congelado")) {
            System.out.println(nombre + " está congelado y no puede actuar.");
            return;
        }

        int daño = this.calcularAtaque() - objetivo.calcularDefensa();
        if (daño < 0) {
            daño = 0;
        }

        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " causando " + daño + " de daño.");
        objetivo.recibirDaño(daño);

        if (daño > 0) {
            this.setEnergiaActual(this.energiaActual + 10);
            System.out.println(nombre + " genera 10 de energía por infligir daño. (Energía: " + energiaActual + "/" + energiaMax + ")");
        }
    }

    public void recibirDaño(int cantidad) {
        this.vidaActual -= cantidad;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
        System.out.println(nombre + " recibe " + cantidad + " de daño. Vida actual: " + vidaActual + "/" + vidaMax);

        if (cantidad > 0 && vidaActual > 0) {
            this.setEnergiaActual(this.energiaActual + 15);
            System.out.println(nombre + " genera 15 de energía por recibir un impacto. (Energía: " + energiaActual + "/" + energiaMax + ")");
        }
    }

    public void procesarTurno() {
        for (int i = estadosActivos.size() - 1; i >= 0; i--) {
            IEstadoAlterado estado = estadosActivos.get(i);
            estado.aplicarEfecto(this);
            if (estado.haTerminado()) {
                System.out.println("El estado " + estado.getNombre() + " ha expirado en " + nombre);
                estadosActivos.remove(i);
            }
        }
    }

    public void usarEnergia(int cantidad) throws Exception {
        if (this.energiaActual < cantidad) {
            throw new Exception("¡No hay suficiente energía!");
        }
        this.energiaActual -= cantidad;
    }

    public abstract void usarHabilidadEspecial(Personaje objetivo);

    public void agregarEstado(IEstadoAlterado estado) {
        this.estadosActivos.add(estado);
    }

    public boolean tieneEstado(String nombreEstado) {
        return estadosActivos.stream().anyMatch(e -> e.getNombre().equalsIgnoreCase(nombreEstado));
    }

    public void equiparObjeto(Object objeto) {
        this.objetoEquipado = objeto;
    }

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
}
