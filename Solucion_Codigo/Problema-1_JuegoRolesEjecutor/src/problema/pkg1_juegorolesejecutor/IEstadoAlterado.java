
package problema.pkg1_juegorolesejecutor;

public interface IEstadoAlterado {
    void aplicarEfecto(Personaje p);
    boolean haTerminado();
    String getNombre();
}
