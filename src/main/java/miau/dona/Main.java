package miau.dona;

import miau.dona.entidades.Humano;
import miau.dona.entidades.Invasor;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Humano[] humanos = new Humano[3];
        Invasor[] invasores = new Invasor[3];

        for (int i = 0; i < humanos.length; i++) {
            humanos[i] = new Humano(i);
            System.out.println(humanos[i]);

        }

        for (int i = 0; i < invasores.length; i++) {
            invasores[i] = new Invasor(i);
            System.out.println(invasores[i]);
        }

        int anteriorVivo = 0;
        for (int i = 0; i < humanos.length; i++) {
            System.out.println("--------Ronda " + i + "-------");

            while (humanos[i].isEstaVivo() && invasores[i].isEstaVivo()) {
                humanos[i].recibirDano(invasores[i]);
                invasores[i].recibirDano(humanos[i]);

                tiempoEntreAtaques();
            }

        }
        System.out.println("FIN DE LA PARTIDA");
    }

    public static void tiempoEntreAtaques() {
        int espera = 8;

        while (espera > 0) {
            System.out.print("\rSiguiente ataque en " + espera +" segundos...");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Error en la espera de cambio de ronda.");
                throw new RuntimeException(e);
            }

            espera--;
        }

        System.out.println("\rEl siguiente ataque comienza ya.\n\n");
    }
}