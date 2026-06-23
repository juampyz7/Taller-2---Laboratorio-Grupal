package problema.pkg2_restauranteejecutor;

public abstract class Menu {

    protected String nombrePlato;
    protected double valorMenu;
    protected double valorInicial;

    public Menu(String nombrePlato, double valorInicial) {
        if (nombrePlato == null || nombrePlato.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del plato no puede estar vacio.");
        }
        validarNoNegativo(valorInicial, "valor inicial");
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
        this.valorMenu = 0; 
    }

    public abstract double calcularValorMenu();

    protected static void validarNoNegativo(double valor, String nombreCampo) {
        if (valor < 0) {
            throw new IllegalArgumentException("El " + nombreCampo + " no puede ser negativo.");
        }
    }

    protected static void validarPorcentaje(double valor, String nombreCampo) {
        if (valor < 0 || valor > 100) {
            throw new IllegalArgumentException("El " + nombreCampo + " debe estar entre 0 y 100.");
        }
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public double getValorMenu() {
        return valorMenu;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setNombrePlato(String nombrePlato) {
        if (nombrePlato == null || nombrePlato.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del plato no puede estar vacio.");
        }
        this.nombrePlato = nombrePlato;
    }

    public void setValorInicial(double valorInicial) {
        validarNoNegativo(valorInicial, "valor inicial");
        this.valorInicial = valorInicial;
        this.valorMenu = calcularValorMenu();
    }

    @Override
    public String toString() {
        return "Plato: " + nombrePlato +
               " | Valor inicial: $" + String.format("%.2f", valorInicial) +
               " | Valor menu: $" + String.format("%.2f", valorMenu);
    }
}
