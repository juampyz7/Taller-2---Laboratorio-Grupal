package problema.pkg1_juegorolesejecutor;

public class PocionEspecial extends Objeto {
    private int curacion;
    private int bonoAtaqueTemporal;

    public PocionEspecial(String nombre, int curacion, int bonoAtaqueTemporal) {
        super(nombre);
        this.curacion = curacion;
        this.bonoAtaqueTemporal = bonoAtaqueTemporal;
    }

    public void consumir(Personaje p) {
        p.setVidaActual(p.getVidaActual() + curacion);
        // Otorga una ventaja aumentando temporalmente el ataque base
        p.ataqueBase += bonoAtaqueTemporal;
        System.out.println(p.getNombre() + " consumió " + nombre + ". Recuperó " + curacion + " HP y su ataque aumentó en " + bonoAtaqueTemporal + "!");
    }
}