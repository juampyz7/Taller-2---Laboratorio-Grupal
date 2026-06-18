package problema.pkg2_restauranteejecutor;

import java.util.Scanner;

public class Problema2_RestauranteEjecutor {

    private static final Scanner sc = new Scanner(System.in);
    private static final Controlador controlador = new Controlador();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      SISTEMA DE RESTAURANTE");
        System.out.println("========================================");

        String nombreCliente = leerTexto("Ingrese el nombre del cliente: ");
        controlador.iniciarCuenta(nombreCliente);

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    agregarMenuCarta();
                    break;
                case 2:
                    agregarMenuDia();
                    break;
                case 3:
                    agregarMenuNinos();
                    break;
                case 4:
                    agregarMenuEco();
                    break;
                case 5:
                    System.out.println(controlador.generarReporteCuenta());
                    break;
                case 6:
                    eliminarMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        System.out.println("\n===== CUENTA FINAL =====");
        System.out.println(controlador.generarReporteCuenta());

        mostrarDemoPolimorfismo();

        sc.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Agregar Menu a la Carta");
        System.out.println("2. Agregar Menu del Dia");
        System.out.println("3. Agregar Menu de Ninos");
        System.out.println("4. Agregar Menu Economico");
        System.out.println("5. Ver cuenta actual");
        System.out.println("6. Eliminar un menu");
        System.out.println("0. Generar cuenta final y salir");
    }

    private static void agregarMenuCarta() {
        try {
            String nombre = leerTexto("Nombre del plato: ");
            double valorInicial = leerDouble("Valor inicial: ");
            double guarnicion = leerDouble("Valor guarnicion: ");
            double bebida = leerDouble("Valor bebida: ");
            double servicio = leerDouble("Porcentaje de servicio (%): ");
            controlador.agregarMenuCarta(nombre, valorInicial, guarnicion, bebida, servicio);
            System.out.println("Menu a la Carta agregado.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("No se pudo agregar el menu: " + e.getMessage());
        }
    }

    private static void agregarMenuDia() {
        try {
            String nombre = leerTexto("Nombre del plato: ");
            double valorInicial = leerDouble("Valor inicial: ");
            double postre = leerDouble("Valor postre: ");
            double bebida = leerDouble("Valor bebida: ");
            controlador.agregarMenuDia(nombre, valorInicial, postre, bebida);
            System.out.println("Menu del Dia agregado.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("No se pudo agregar el menu: " + e.getMessage());
        }
    }

    private static void agregarMenuNinos() {
        try {
            String nombre = leerTexto("Nombre del plato: ");
            double valorInicial = leerDouble("Valor inicial: ");
            double helado = leerDouble("Valor helado: ");
            double pastel = leerDouble("Valor pastel: ");
            controlador.agregarMenuNinos(nombre, valorInicial, helado, pastel);
            System.out.println("Menu de Ninos agregado.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("No se pudo agregar el menu: " + e.getMessage());
        }
    }

    private static void agregarMenuEco() {
        try {
            String nombre = leerTexto("Nombre del plato: ");
            double valorInicial = leerDouble("Valor inicial: ");
            double descuento = leerDouble("Porcentaje de descuento (%): ");
            controlador.agregarMenuEco(nombre, valorInicial, descuento);
            System.out.println("Menu Economico agregado.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("No se pudo agregar el menu: " + e.getMessage());
        }
    }

    private static void eliminarMenu() {
        if (controlador.obtenerCantidadMenus() == 0) {
            System.out.println("No hay menus para eliminar.");
            return;
        }
        System.out.println(controlador.generarReporteCuenta());
        int indice = leerEntero("Ingrese el numero del menu a eliminar: ");
        if (controlador.eliminarMenuPorPosicion(indice)) {
            System.out.println("Menu eliminado correctamente.");
        } else {
            System.out.println("Numero de menu invalido.");
        }
    }

    private static void mostrarDemoPolimorfismo() {
        System.out.println("\n--- Demo de polimorfismo ---");
        Menu[] demoMenus = controlador.generarMenusDemostracion();
        System.out.println("Valor calculado de cada tipo de menu via polimorfismo:");
        for (Menu m : demoMenus) {
            System.out.println(m.toString());
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Ingrese un numero entero.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Ingrese un numero (ej. 12.50).");
            }
        }
    }
}
