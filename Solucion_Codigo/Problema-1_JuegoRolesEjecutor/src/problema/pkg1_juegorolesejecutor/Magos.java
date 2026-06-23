package problema.pkg1_juegorolesejecutor;

public class Magos extends Personaje {

    private int mana;
    private int poderMagico;

    public Magos(String nombre, int puntosDeVida, int ataque, int defensa, int mana, int poderMagico) {
        super(nombre, puntosDeVida, ataque, defensa);
        this.mana = mana;
        this.poderMagico = poderMagico;
    }

    @Override
    public int calcularAtaque() {
        if (mana >= 20) {
            mana -= 20;
            return ataque + poderMagico + (nivelExperiencia * 5);
        }
        return ataque + (nivelExperiencia * 2);
    }

    @Override
    public int calcularDefensa() {
        if (mana >= 10) {
            mana -= 10;
            return defensa + (poderMagico / 2) + nivelExperiencia;
        }
        return defensa;
    }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        try {
            // El Alumno 3 programará la lógica de cooldowns y costes aquí
            usarEnergia(20);
            System.out.println(nombre + " usa Golpe Devastador (Requiere integración de Cooldowns).");
        } catch (Exception e) {
            System.out.println(nombre + " intentó usar su habilidad especial pero: " + e.getMessage());
        }
    }

    public int getMana() {
        return mana;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    @Override
    public String toString() {
        return super.toString() + " | Mana: " + mana + " | Poder Magico: " + poderMagico;
    }
}
