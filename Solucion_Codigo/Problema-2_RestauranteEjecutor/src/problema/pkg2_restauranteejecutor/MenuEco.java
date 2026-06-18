/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema.pkg2_restauranteejecutor;

public class MenuEco extends Menu {

    private double porcentajeDescuento;

    public MenuEco(String nombrePlato, double valorInicial, double porcentajeDescuento) {
        super(nombrePlato, valorInicial);
        validarPorcentaje(porcentajeDescuento, "porcentaje de descuento");
        this.porcentajeDescuento = porcentajeDescuento;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public double calcularValorMenu() {
        if (valorInicial == 0) return 0;
        double descuento = valorInicial * (porcentajeDescuento / 100);
        return valorInicial - descuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        validarPorcentaje(porcentajeDescuento, "porcentaje de descuento");
        this.porcentajeDescuento = porcentajeDescuento;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public String toString() {
        return "[Menu Economico] " + super.toString() +
               " | Descuento: " + porcentajeDescuento + "%" +
               " | Ahorro: $" + String.format("%.2f", valorInicial - valorMenu);
    }
}
