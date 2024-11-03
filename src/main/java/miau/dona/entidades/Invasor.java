package miau.dona.entidades;

import miau.dona.UtilsJava;

public class Invasor extends Jugador {
    public Invasor(int id) {
        super(id);
        this.danoArma = UtilsJava.RANDOM.nextInt(10, 60);
    }

    @Override
    public EntityType getTipo() {
        return EntityType.INVASOR;
    }

    @Override
    public String toString() {
        return "Invasor: " + getId() + " Vida:" + getVida() + " Daño: " + danoArma + " Vivo: " + isEstaVivo();
    }
}
