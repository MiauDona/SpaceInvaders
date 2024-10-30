package miau.dona.clases;

import static miau.dona.UtilsJava.RANDOM;

public class Humano extends Jugador {
    boolean escudo = true;
    public Humano(int id) {
        super.setId(id);
        super.setDanoArma(RANDOM.nextInt(10,70));
    }

    public String toString() {
        return "Humano: " + super.getId() + " vida:" + super.getVida() + " escudo: " + escudo + " Está vivo: " + super.isEstaVivo();
    }

    @Override
    void recibirDano(Humano humano, Invasor invasor) {
        if (humano.isEstaVivo()) {
            humano.setVida(humano.getVida() - invasor.getDanoArma() * disparoACuerpo());
            if (getVida() <= 0) {
                humano.setEstaVivo(false);
                System.out.println("Muerto");
            }
        }
        System.out.println(humano);
    }

    public void miRecibirDano(Humano humano, Invasor invasor) {
        recibirDano(humano, invasor);
    }



}
