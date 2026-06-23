package problema.pkg1_juegorolesejecutor;

public class Problema1_JuegoRolesEjecutor {

    public static void main(String[] args) {
        Personaje guerrero = new Guerrero("Arturo el Guerrero", 150, 25, 15, 10);
        Personaje arquero = new Arqueros("Robin el Arquero", 120, 20, 10, 12, 15);

        SistemaCombate controlador = new SistemaCombate();

        controlador.iniciarCombate(guerrero, arquero);
    }
}
