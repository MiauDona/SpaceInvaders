package miau.dona.clases;

import static miau.dona.UtilsJava.RANDOM;

public abstract class Jugador {
    private int vida = 100;
    private boolean estaVivo = true;
    protected int danoArma = 0;
    private int id = 0;
    private String[] partesCuerpo = { "cabeza", "brazos", "pies", "pecho"};
    private float[] multiplicadorCuerpo = { 2.5f, 0.9f, 0.5f, 1.4f};

    public String[] getPartesCuerpo() {
        return partesCuerpo;
    }

    public float[] getMultiplicadorCuerpo() {
        return multiplicadorCuerpo;
    }

    public void setPartesCuerpo(String[] partesCuerpo) {
        this.partesCuerpo = partesCuerpo;
    }

    public int getDanoArma() {
        return danoArma;
    }

    public void setDanoArma(int danoArma) {
        this.danoArma = danoArma;
    }

    public int getId() {
        return id;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setId(int id) {
        this.id = id;
    }

    Jugador() {
    }
    int disparoACuerpo() {
        return RANDOM.nextInt(0,getMultiplicadorCuerpo().length);
    }

    abstract void recibirDano(Humano humano, Invasor invasor);
}
