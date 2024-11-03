package miau.dona;

import miau.dona.entidades.EntityType;
import miau.dona.entidades.Humano;
import miau.dona.entidades.Invasor;
import miau.dona.entidades.Jugador;

import java.util.concurrent.TimeUnit;

public class Main {
    public static Humano[] humanos = new Humano[3];
    public static Invasor[] invasores = new Invasor[3];

    public static void main(String[] args) {
        declararJugadores();
        ronda();
    }

    public static void declararJugadores() {
        for (int i = 0; i < humanos.length; i++) {
            humanos[i] = new Humano(i+1);
            System.out.println(humanos[i]);
        }

        for (int i = 0; i < invasores.length; i++) {
            invasores[i] = new Invasor(i+1);
            System.out.println(invasores[i]);
        }
    }

    public static void ronda() {
        int killHumanos = 0;
        int killInvasores = 0;

        int ronda = 1;
        for (;;) {
            int humano = elPrimerVivo(humanos);
            int invasor = elPrimerVivo(invasores);

            if (humano == -1 || invasor == -1) {
                break;
            }

            System.out.println("--------Ronda " + ronda + "-------");

            boolean primerAtaque = true;
            while (humanos[humano].isEstaVivo() && invasores[invasor].isEstaVivo()) {
                if (primerAtaque) {
                    primerAtaque = false;
                } else {
                    tiempoDeEspera(3, "ataque");
                }

                humanos[humano].recibirDano(invasores[invasor]);
                invasores[invasor].recibirDano(humanos[humano]);
            }

            EntityType tipo = EntityType.UNKNOWN;
            if (humanos[humano].isEstaVivo()) {
                killHumanos++;
                tipo = EntityType.HUMANO;
            } else if (invasores[invasor].isEstaVivo()) {
                killInvasores++;
                tipo = EntityType.INVASOR;
            }

            System.out.println("\nRonda ganada por " + tipo);
            tiempoDeEspera(10, "ronda");
            ronda++;
        }

        System.out.println("Humanos - Invasores");
        System.out.println(killHumanos + " - " + killInvasores);
        System.out.println("Fin de la partida en " + (ronda - 1) + " rondas.");
    }

    public static int elPrimerVivo(Jugador[] jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.isEstaVivo()) {
                return jugador.getId() - 1;
            }
        }

        return -1;
    }

    public static void tiempoDeEspera(int espera, String motivo) {
        while (espera > 0) {
            System.out.print("\rSiguiente " + motivo + " en " + espera +" segundos...");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Error en la espera de cambio de " + motivo + ".");
                throw new RuntimeException(e);
            }

            espera--;
        }

        System.out.println("\rSiguiente " + motivo + " comienza ya.          \n");
    }
}