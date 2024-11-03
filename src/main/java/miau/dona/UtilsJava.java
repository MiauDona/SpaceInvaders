package miau.dona;

import java.util.Random;
import java.util.Scanner;

public class UtilsJava {
    // Crea un random
    public static final Random RANDOM = new Random();

    /**
     * Pide una String por consola al usuario
     *
     * @param mensaje Mensaje que se va a introducir para pedir el String
     * @return Devuelve la String que introduce el usuario
     */
    public static String pedir(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    /**
     * Pide un numero Int por consola al usuario
     *
     * @param mensaje Mensaje que se va a introducir para pedir el String
     * @return Devuelve el Int que introduce el usuario
     */
    public static int pedirInt(String mensaje) {
        return Integer.parseInt(pedir(mensaje));
    }

    /**
     * Pide un Double por consola al usuario
     *
     * @param mensaje Mensaje que se va a introducir para pedir el Double
     * @return Devuelve un Double que introduce el usuario
     */
    public static double pedirDouble(String mensaje) {
        return Double.parseDouble(pedir(mensaje));
    }

    /**
     * Pide un Float por consola al usuario
     *
     * @param mensaje Mensaje que se va a introducir para pedir el Double
     * @return Devuelve un Double que introduce el usuario
     */
    public static float pedirFloat(String mensaje) {
        return Float.parseFloat(pedir(mensaje));
    }

    /**
     * Pide 2 numeros, el mínimo y el máximo al usuario por consola
     *
     * @return Devuelve el número random entre los 2 numeros introducidos, minimos y maximos incluidos
     */
    public static int pedirNumerosParaRandom() {
        int min = pedirInt("Vamos a hacer un número aleatorio en un rango entre 2 numeros. Dime el número mínimo");
        int max = pedirInt("Dime el número máximo");

        // return Math.random() * (max - min) + min;
        return RANDOM.nextInt(min, max + 1);
    }

    /**
     * Comprueba si el numero introducido es primo
     *
     * @param numeroIntroducido Numero Int a comprobar que sea primo
     * @return Devuelve un boolean, true si es primo y si no lo es, false
     */
    public static boolean esNumeroPrimo(int numeroIntroducido) {
        boolean esPrimo = true;

        for (int i = numeroIntroducido - 1; i > 1; i--) {
            if (numeroIntroducido % i == 0) {
                esPrimo = false;
                System.out.println("El número no es primo");
                break;
            }
        }

        return esPrimo;
    }

    /**
     * Muestra el array entero de int
     *
     * @param array Array de Int para mostrar
     */
    public static void mostrarArrayInts(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
    }

    /**
     * Muestra el array entero de String
     *
     * @param array Array de String para mostrar
     */
    public static void mostrarArrayStrings(String[] array) {
        for (String valor : array) {
            System.out.print(valor + " ");
        }
    }

    /**
     * Muestra el array entero de boolean
     *
     * @param array Array de boolean para mostrar
     */
    public static void mostrarArrayBooleans(boolean[] array) {
        for (boolean valor : array) {
            System.out.print(valor + " ");
        }
    }

    /**
     * Convierte una String a un Array de Char y lo muestra
     *
     * @param string String que quieres mostrar en forma de Char
     * @return Array de Char proveniente de la String introducida
     */
    public static char[] mostrarStringConvertidoACharArray(String string) {
        for (char valor : string.toCharArray()) {
            System.out.print(valor + " ");
        }
        return string.toCharArray();
    }

    /**
     * Crea un array con numeros aleatorios entre 2 números
     *
     * @param tamanio El tamaño del array (int)
     * @param min     El numero minimo para los aleatorios (int)
     * @param max     El numero maximo para los aleatorios (int)
     * @return El array con los numeros aleatorios (int[])
     */
    public static int[] crearArrayIntsAleatoriosEntreNumeros(int tamanio, int min, int max) {
        int[] array = new int[tamanio];

        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(min, max + 1);
        }

        return array;
    }
}
