package miau.dona;

import miau.dona.entidades.Humano;
import miau.dona.entidades.Invasor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* No entiendo como va a ser el juego*/
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

            while (humanos[i].isEstaVivo() && invasores[i].isEstaVivo()) {
                humanos[i].recibirDano(invasores[i]);
                invasores[i].recibirDano(humanos[i]);
                System.out.println();
            }
        }

        System.out.println("FIN DE LA PARTIDA");
    }
}