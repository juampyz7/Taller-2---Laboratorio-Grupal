package problema.pkg2_restauranteejecutor;

import java.util.ArrayList;

public class Cuenta {

    private static final double PORCENTAJE_IVA = 12.0;

    private String nombreCliente;
    private ArrayList<Menu> menus;

    public Cuenta(String nombreCliente) {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio.");
        }
        this.nombreCliente = nombreCliente;
        this.menus = new ArrayList<>();
    }

    public void agregarMenu(Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("No se puede agregar un menu nulo.");
        }
        menus.add(menu);
    }

    public boolean eliminarMenu(int indice) {
        if (indice >= 0 && indice < menus.size()) {
            menus.remove(indice);
            return true;
        }
        return false;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Menu menu : menus) {
            subtotal += menu.getValorMenu();
        }
        return subtotal;
    }

    public double calcularIva() {
        return calcularSubtotal() * (PORCENTAJE_IVA / 100);
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIva();
    }

    public static double getPorcentajeIva() {
        return PORCENTAJE_IVA;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public int getCantidadMenus() {
        return menus.size();
    }

    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio.");
        }
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("        CUENTA DEL RESTAURANTE\n");
        sb.append("========================================\n");
        sb.append("Cliente: ").append(nombreCliente).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("DETALLE DE MENUS:\n");
        if (menus.isEmpty()) {
            sb.append("  Sin menus registrados.\n");
        } else {
            for (int i = 0; i < menus.size(); i++) {
                sb.append("  ").append(i + 1).append(". ").append(menus.get(i).toString()).append("\n");
            }
        }
        sb.append("----------------------------------------\n");
        sb.append("Subtotal : $").append(String.format("%.2f", calcularSubtotal())).append("\n");
        sb.append("IVA (").append(PORCENTAJE_IVA).append("%): $").append(String.format("%.2f", calcularIva())).append("\n");
        sb.append("TOTAL    : $").append(String.format("%.2f", calcularTotal())).append("\n");
        sb.append("========================================");
        return sb.toString();
    }
}
