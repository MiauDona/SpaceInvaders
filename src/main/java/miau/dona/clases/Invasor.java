package miau.dona.clases;

import miau.dona.UtilsJava;

import static miau.dona.UtilsJava.RANDOM;

public class Invasor extends Jugador{


    public Invasor(int id) {
        super.setId(id);
        super.setDanoArma(RANDOM.nextInt(0, 100));
    }

    public String toString() {
        return "Invasor: " + super.getId() + " vida:" + super.getVida() + " dano arma: " + danoArma;
    }

    @Override
    void recibirDano(Humano humano, Invasor invasor) {
        if (invasor.isEstaVivo()) {
            invasor.setVida(invasor.getVida() - humano.getDanoArma() * disparoACuerpo());
            if (getVida() <= 0) {
                invasor.setEstaVivo(false);
                System.out.println("Muerto");
            }
        }
        System.out.println(invasor);
    }

    public void miRecibirDano(Humano humano, Invasor invasor) {
        recibirDano(humano, invasor);
    }
}
