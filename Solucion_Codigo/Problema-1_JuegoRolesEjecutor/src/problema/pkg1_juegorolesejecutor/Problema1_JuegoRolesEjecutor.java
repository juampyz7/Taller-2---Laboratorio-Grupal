package problema.pkg1_juegorolesejecutor;

import java.util.Scanner;

public class Problema1_JuegoRolesEjecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaCombate sistema = new SistemaCombate();

        System.out.println("========================================");
        System.out.println("        JUEGO DE ROL - COMBATE");
        System.out.println("========================================");
        System.out.println("Seleccione su personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Opcion: ");
        int opcionJugador = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el nombre de su personaje: ");
        String nombreJugador = sc.nextLine();

        Personaje jugador = crearPersonaje(opcionJugador, nombreJugador);

        System.out.println("\nSeleccione el tipo de enemigo:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Opcion: ");
        int opcionEnemigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el nombre del enemigo: ");
        String nombreEnemigo = sc.nextLine();

        Personaje enemigo = crearPersonaje(opcionEnemigo, nombreEnemigo);

        System.out.println("\n--- Personajes creados ---");
        System.out.println(jugador.toString());
        System.out.println(enemigo.toString());
        
        System.out.println("\n--- APLICANDO ESTADOS ALTERADOS ---");
        
        jugador.agregarEstado(new FuerzaAumentada(3, 20));
        enemigo.agregarEstado(new Envenenado(4, 15));
        enemigo.agregarEstado(new Congelado(1));

        System.out.println("\nPresione Enter para iniciar la batalla...");
        sc.nextLine();

        String resultadoBatalla = sistema.ejecutarBatalla(jugador, enemigo);
        System.out.println(resultadoBatalla);

        System.out.println("\n--- Demostracion de polimorfismo ---");
        Personaje[] arena = {
            new Guerrero("Thor", 150, 30, 20, 40),
            new Magos("Gandalf", 100, 20, 10, 80, 50),
            new Arqueros("Legolas", 120, 25, 15, 90, 30)
        };

        System.out.println("\nTodos los personajes del torneo:");
        for (Personaje p : arena) {
            System.out.println(p.toString());
        }

        System.out.println("\nHabilidades especiales de cada personaje:");
        for (Personaje p : arena) {
            System.out.println(p.usarHabilidadEspecial());
        }

        System.out.println("\nAtaque calculado de cada personaje:");
        for (Personaje p : arena) {
            System.out.println(p.getNombre() + " -> " + p.calcularAtaque() + " de ataque");
        }

        sc.close();
    }

    private static Personaje crearPersonaje(int opcion, String nombre) {
        switch (opcion) {
            case 1:
                return new Guerrero(nombre, 150, 30, 20, 40);
            case 2:
                return new Magos(nombre, 100, 20, 10, 80, 50);
            case 3:
                return new Arqueros(nombre, 120, 25, 15, 90, 30);
            default:
                System.out.println("Opcion no valida, se crea Guerrero por defecto.");
                return new Guerrero(nombre, 150, 30, 20, 40);
        }
    }
}