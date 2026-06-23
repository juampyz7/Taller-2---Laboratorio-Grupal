package problema.pkg1_juegorolesejecutor;

public abstract class Personaje {

    protected String nombre;
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

    // Lógica de combate base usando Polimorfismo
    public void atacar(Personaje objetivo) {
        // Preparación para Alumno 2: Verificar si está congelado antes de atacar
        if (tieneEstado("Congelado")) {
            System.out.println(nombre + " está congelado y no puede atacar este turno.");
            return;
        }

        int daño = this.calcularAtaque() - objetivo.calcularDefensa();
        if (daño < 0) {
            daño = 0;
        }

        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " causando " + daño + " de daño.");
        objetivo.recibirDaño(daño);
    }

    public void recibirDaño(int cantidad) {
        this.vidaActual -= cantidad;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
        System.out.println(nombre + " ahora tiene " + vidaActual + "/" + vidaMax + " de HP.");
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
            throw new Exception("¡No hay suficiente energía/maná!");
        }
        this.energiaActual -= cantidad;
    }

    // El Alumno 3 heredará esto para implementar habilidades específicas
    public abstract void usarHabilidadEspecial(Personaje objetivo);
}
