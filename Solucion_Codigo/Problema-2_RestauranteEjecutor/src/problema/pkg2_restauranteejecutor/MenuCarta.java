/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema.pkg2_restauranteejecutor;

public class MenuCarta extends Menu {

    private double valorGuarnicion;
    private double valorBebida;
    private double porcentajeServicio;

    public MenuCarta(String nombrePlato, double valorInicial, double valorGuarnicion,
                      double valorBebida, double porcentajeServicio) {
        super(nombrePlato, valorInicial);
        validarNoNegativo(valorGuarnicion, "valor de guarnicion");
        validarNoNegativo(valorBebida, "valor de bebida");
        validarPorcentaje(porcentajeServicio, "porcentaje de servicio");
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public double calcularValorMenu() {
        if (valorInicial == 0) return 0;
        double adicionalServicio = valorInicial * (porcentajeServicio / 100);
        return valorInicial + adicionalServicio + valorGuarnicion + valorBebida;
    }

    public double getValorGuarnicion() {
        return valorGuarnicion;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public double getPorcentajeServicio() {
        return porcentajeServicio;
    }

    public void setValorGuarnicion(double valorGuarnicion) {
        validarNoNegativo(valorGuarnicion, "valor de guarnicion");
        this.valorGuarnicion = valorGuarnicion;
        this.valorMenu = calcularValorMenu();
    }

    public void setValorBebida(double valorBebida) {
        validarNoNegativo(valorBebida, "valor de bebida");
        this.valorBebida = valorBebida;
        this.valorMenu = calcularValorMenu();
    }

    public void setPorcentajeServicio(double porcentajeServicio) {
        validarPorcentaje(porcentajeServicio, "porcentaje de servicio");
        this.porcentajeServicio = porcentajeServicio;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public String toString() {
        return "[Menu a la Carta] " + super.toString() +
               " | Guarnicion: $" + String.format("%.2f", valorGuarnicion) +
               " | Bebida: $" + String.format("%.2f", valorBebida) +
               " | Servicio: " + porcentajeServicio + "%";
    }
}
