package miau.dona.entidades;

import miau.dona.UtilsJava;

public abstract class Jugador {
    protected int danoArma = 0;
    private int vida = 100;
    private boolean estaVivo = true;
    private int id = 0;
    private String[] partesCuerpo = {"cabeza", "brazos", "pies", "pecho"};
    private final float[] multiplicadorCuerpo = {2.5f, 0.9f, 0.5f, 1.4f};

    public Jugador(int id) {
        this.id = id;
    }

    public String[] getPartesCuerpo() {
        return partesCuerpo;
    }

    public EntityType getTipo() {
        return EntityType.UNKNOWN;
    }

    public void setPartesCuerpo(String[] partesCuerpo) {
        this.partesCuerpo = partesCuerpo;
    }

    public float[] getMultiplicadorCuerpo() {
        return multiplicadorCuerpo;
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

    public void setId(int id) {
        this.id = id;
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

    public String getNombre() {
        return getTipo() + " " + getId();
    }

    float disparoACuerpo() {
        return multiplicadorCuerpo[UtilsJava.RANDOM.nextInt(0, getMultiplicadorCuerpo().length)];
    }

    public void recibirDano(Jugador inflictor) {
        if (isEstaVivo() && inflictor.isEstaVivo()) {
            int danoArma = inflictor.getDanoArma();
            float disparoCuerpo = disparoACuerpo();

            System.out.println(inflictor.getNombre() + " inflinge: " + (int) (danoArma * disparoCuerpo));
            System.out.println("Vida restante de " + getNombre() + ": " + (int) (getVida() - danoArma * disparoCuerpo));
            setVida((int) (getVida() - danoArma * disparoCuerpo));
            
            if (getVida() <= 0) {
                setEstaVivo(false);
                System.out.println(getNombre() + " ha muerto");
            }
        }
    }
}
