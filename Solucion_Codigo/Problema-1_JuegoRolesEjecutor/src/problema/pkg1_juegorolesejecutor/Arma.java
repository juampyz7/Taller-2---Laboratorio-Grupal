package problema.pkg1_juegorolesejecutor;

public class Arma extends Objeto {
    private int bonificadorAtaque;

    public Arma(String nombre, int bonificadorAtaque) {
        super(nombre);
        this.bonificadorAtaque = bonificadorAtaque;
    }
    public int getBonificadorAtaque() { return bonificadorAtaque; }
}