package problema.pkg1_juegorolesejecutor;

public abstract class Objeto {
    protected String nombre;

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
}