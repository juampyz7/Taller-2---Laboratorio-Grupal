
package problema.pkg1_juegorolesejecutor;

public interface IEstadoAlterado {
    void aplicarEfecto(Personaje p);
    boolean haTerminado();
    String getNombre();

public interface IEstadoAlterado {

    String getNombre();

    void aplicarEfecto(Personaje personaje);

    void reducirTurno();

    boolean estaActivo();
}
