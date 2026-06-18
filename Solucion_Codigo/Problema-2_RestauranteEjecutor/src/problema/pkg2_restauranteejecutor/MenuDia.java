/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema.pkg2_restauranteejecutor;

public class MenuDia extends Menu {

    private double valorPostre;
    private double valorBebida;

    public MenuDia(String nombrePlato, double valorInicial, double valorPostre, double valorBebida) {
        super(nombrePlato, valorInicial);
        validarNoNegativo(valorPostre, "valor de postre");
        validarNoNegativo(valorBebida, "valor de bebida");
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public double calcularValorMenu() {
        if (valorInicial == 0) return 0;
        return valorInicial + valorPostre + valorBebida;
    }

    public double getValorPostre() {
        return valorPostre;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public void setValorPostre(double valorPostre) {
        validarNoNegativo(valorPostre, "valor de postre");
        this.valorPostre = valorPostre;
        this.valorMenu = calcularValorMenu();
    }

    public void setValorBebida(double valorBebida) {
        validarNoNegativo(valorBebida, "valor de bebida");
        this.valorBebida = valorBebida;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public String toString() {
        return "[Menu del Dia] " + super.toString() +
               " | Postre: $" + String.format("%.2f", valorPostre) +
               " | Bebida: $" + String.format("%.2f", valorBebida);
    }
}
