package miau.dona.entidades;

import miau.dona.UtilsJava;

public class Humano extends Jugador {
    boolean escudo = true;

    public Humano(int id) {
        super(id);
        this.danoArma = UtilsJava.RANDOM.nextInt(10, 40);
    }

    @Override
    public EntityType getTipo() {
        return EntityType.HUMANO;
    }

    @Override
    public String toString() {
        return "Humano: " + getId() + " Vida:" + getVida() + " Escudo: " + escudo + " Daño: " + danoArma + " Vivo: " + isEstaVivo();
    }

    @Override
    public void recibirDano(Jugador inflictor) {
        if (!escudo) {
            super.recibirDano(inflictor);
        } else {
            escudo = false;
            System.out.println(inflictor.getNombre() + " ha disparado a " + getNombre() + " y ha perdido el escudo");
        }
    }
}
