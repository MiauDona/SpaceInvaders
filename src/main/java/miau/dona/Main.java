package miau.dona;

import miau.dona.clases.Humano;
import miau.dona.clases.Invasor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* No entiendo como va a ser el jeugo*/
        Humano[] humanos = new Humano[3];
        Invasor[] invasores = new Invasor[3];

        for (int i = 0; i < humanos.length; i++) {
            humanos[i] = new Humano(i);
            System.out.println(humanos[i]);

        }

        for (int i = 0; i < invasores.length ; i++) {
            invasores[i] = new Invasor(i);
            System.out.println(invasores[i]);
        }
        System.out.println("-------------");

        int anteriorVivo = 0;
        for (int i = 0; i < humanos.length; i++) {

            while (humanos[i].isEstaVivo() && invasores[i].isEstaVivo()) {
                humanos[i].miRecibirDano(humanos[i], invasores[i]);
                invasores[i].miRecibirDano(humanos[i], invasores[i]);
            }
        }

        //Coger Invasor
        //Dipara
        //veo si escudo o quito vida
        //Cogo Humano
        //Disparo
        //Resto vida
        //REPITO HASTA QUE UNO DE LOS DOS TODOS MUERTOS

        
    }
}