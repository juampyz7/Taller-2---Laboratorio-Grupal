/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema.pkg2_restauranteejecutor;

public class MenuNiños extends Menu {

    private double valorHelado;
    private double valorPastel;

    public MenuNiños(String nombrePlato, double valorInicial, double valorHelado, double valorPastel) {
        super(nombrePlato, valorInicial);
        validarNoNegativo(valorHelado, "valor de helado");
        validarNoNegativo(valorPastel, "valor de pastel");
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public double calcularValorMenu() {
        if (valorInicial == 0) {
            return 0;
        }
        return valorInicial + valorHelado + valorPastel;
    }

    public double getValorHelado() {
        return valorHelado;
    }

    public double getValorPastel() {
        return valorPastel;
    }

    public void setValorHelado(double valorHelado) {
        validarNoNegativo(valorHelado, "valor de helado");
        this.valorHelado = valorHelado;
        this.valorMenu = calcularValorMenu();
    }

    public void setValorPastel(double valorPastel) {
        validarNoNegativo(valorPastel, "valor de pastel");
        this.valorPastel = valorPastel;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public String toString() {
        return "[Menu Ninos] " + super.toString()
                + " | Helado: $" + String.format("%.2f", valorHelado)
                + " | Pastel: $" + String.format("%.2f", valorPastel);
    }
}
