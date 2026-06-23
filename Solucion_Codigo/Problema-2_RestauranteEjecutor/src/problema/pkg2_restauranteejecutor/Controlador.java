package problema.pkg2_restauranteejecutor;

import java.util.ArrayList;

public class Controlador {

    private Cuenta cuenta;

    public Controlador() {
        this.cuenta = null;
    }

    public void iniciarCuenta(String nombreCliente) {
        this.cuenta = new Cuenta(nombreCliente);
    }

    public boolean existeCuentaActiva() {
        return cuenta != null;
    }

    public String getNombreCliente() {
        validarCuentaActiva();
        return cuenta.getNombreCliente();
    }

    public void agregarMenuCarta(String nombre, double valorInicial, double guarnicion,
                                  double bebida, double porcentajeServicio) {
        validarCuentaActiva();
        cuenta.agregarMenu(new MenuCarta(nombre, valorInicial, guarnicion, bebida, porcentajeServicio));
    }

    public void agregarMenuDia(String nombre, double valorInicial, double postre, double bebida) {
        validarCuentaActiva();
        cuenta.agregarMenu(new MenuDia(nombre, valorInicial, postre, bebida));
    }

    public void agregarMenuNinos(String nombre, double valorInicial, double helado, double pastel) {
        validarCuentaActiva();
<<<<<<< HEAD
        cuenta.agregarMenu(new MenuNinos(nombre, valorInicial, helado, pastel));
        cuenta.agregarMenu(new MenuNinos(nombre, valorInicial, helado, pastel));
=======
        cuenta.agregarMenu(new MenuNiños(nombre, valorInicial, helado, pastel));
        cuenta.agregarMenu(new MenuNiños(nombre, valorInicial, helado, pastel));
>>>>>>> b908045114f4f209fb88538acd377b348bcab441
    }

    public void agregarMenuEco(String nombre, double valorInicial, double porcentajeDescuento) {
        validarCuentaActiva();
        cuenta.agregarMenu(new MenuEco(nombre, valorInicial, porcentajeDescuento));
    }

    public boolean eliminarMenuPorPosicion(int posicionVisible) {
        validarCuentaActiva();
        return cuenta.eliminarMenu(posicionVisible - 1);
    }

    public int obtenerCantidadMenus() {
        validarCuentaActiva();
        return cuenta.getCantidadMenus();
    }

    public ArrayList<Menu> obtenerMenus() {
        validarCuentaActiva();
        return cuenta.getMenus();
    }

    public double obtenerSubtotal() {
        validarCuentaActiva();
        return cuenta.calcularSubtotal();
    }

    public double obtenerIva() {
        validarCuentaActiva();
        return cuenta.calcularIva();
    }

    public double obtenerTotal() {
        validarCuentaActiva();
        return cuenta.calcularTotal();
    }

    public String generarReporteCuenta() {
        validarCuentaActiva();
        return cuenta.toString();
    }

    public Menu[] generarMenusDemostracion() {
        return new Menu[] {
            new MenuCarta("Filete de res", 15.00, 3.50, 2.00, 10),
            new MenuDia("Sopa del dia + seco", 8.00, 1.50, 1.00),
<<<<<<< HEAD
            new MenuNinos("Nuggets con papas", 6.00, 1.50, 2.00),
            new MenuNinos("Nuggets con papas", 6.00, 1.50, 2.00),
=======
            new MenuNiños("Nuggets con papas", 6.00, 1.50, 2.00),
            new MenuNiños("Nuggets con papas", 6.00, 1.50, 2.00),
>>>>>>> b908045114f4f209fb88538acd377b348bcab441
            new MenuEco("Arroz con pollo", 7.00, 20)
        };
    }

    private void validarCuentaActiva() {
        if (cuenta == null) {
            throw new IllegalStateException(
                "No existe una cuenta activa. Debe iniciarla antes de continuar.");
        }
    }
}

