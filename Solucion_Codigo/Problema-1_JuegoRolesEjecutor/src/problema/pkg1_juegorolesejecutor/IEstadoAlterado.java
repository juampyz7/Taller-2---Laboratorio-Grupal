/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema.pkg1_juegorolesejecutor;

/**
 *
 * @author jesudavi
 */

public interface IEstadoAlterado {

    String getNombre();

    void aplicarEfecto(Personaje personaje);

    void reducirTurno();

    boolean estaActivo();
}
