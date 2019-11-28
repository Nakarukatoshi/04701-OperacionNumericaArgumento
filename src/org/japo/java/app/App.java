/*
 * Copyright 2019 Javier Monterde - javier.monterde.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

import java.util.Random;

/**
 *
 * @author Javier Monterde - javier.monterde.alum@iescamp.es
 */
public final class App {

    //Instanciamos el objeto Random
    public static final Random RND = new Random();

    //Declaramos mínimos y máximos de los Randoms a utilizar
    public static final int N_MIN = 1;
    public static final int N_MAX = 10;
    public static final int OP_MIN = 0;
    public static final int OP_MAX = 7;

    //Declaramos los tres Randoms
    public static final int N1;
    public static final int N2;
    public static final int OP;

    //Y los inicializamos en la sección "static"
    static {
        N1 = RND.nextInt(N_MAX - N_MIN + 1) + N_MIN;
        N2 = RND.nextInt(N_MAX - N_MIN + 1) + N_MIN;
        OP = RND.nextInt(OP_MAX - OP_MIN + 1) + OP_MIN;
    }

    //Declaramos las constantes de operación
    public static final int OP_SUM = 0;     // Suma
    public static final int OP_RES = 1;     // Resta
    public static final int OP_MUL = 2;     // Producto
    public static final int OP_DIV = 3;     // Cociente
    public static final int OP_MOD = 4;     // Resto
    public static final int OP_MED = 5;     // Media
    public static final int OP_MAY = 6;     // Mayor
    public static final int OP_MEN = 7;     // Menor

    //Declaramos la variable que ostrará el texto final, estático porque
    //se usa en el método "operar", como en el enunciado se indica
    static String mainText = "";

    //Método principal, inicio de la aplicación
    public final void launchApp() {
        //Llamamos al método analizar, con los argumentos del resultado de
        //"operar" y el valor de "mainText", el cual también se obtiene en él
        analizar(operar(N1, N2, OP), mainText);
    }

    //Esta es la salida por consola del programa
    public final void analizar(double result, String mainText) {
        System.out.println("OPERACIÓN NUMÉRICA");
        System.out.println("==================");
        System.out.printf("Número 1 ...............: %d%n", N1);
        System.out.printf("Número 2 ...............: %d%n", N2);
        System.out.println("---");
        //Parseamos "result" a tipo int porque no nos interesan
        //los decimales para la realización de este ejercicio
        System.out.printf(mainText + " %d%n", (int) result);
    }

    //En este método, se hará la operación de este proyecto
    public static final double operar(double n1, double n2, int op) {
        //Declaramos una variable double porque, dependiendo del tipo,
        //pueden (o no) aparecer decimales en el resultado de la operación
        double result;

        //Realizamos la operación dependiendo del Random OP
        switch (op) {
            case OP_SUM:
                mainText = "La SUMA es .............:";
                result = n1 + n2;
                break;
            case OP_RES:
                mainText = "La RESTA es ............:";
                result = n1 - n2;
                break;
            case OP_MUL:
                mainText = "La MULTIPLICACION es ...:";
                result = n1 * n2;
                break;
            case OP_DIV:
                mainText = "La DIVISION es .........:";
                result = n1 / n2;
                break;
            case OP_MOD:
                mainText = "El RESTO es ............:";
                result = n1 % n2;
                break;
            case OP_MED:
                mainText = "La MEDIA es ............:";
                result = (n1 + n2) / 2;
                break;
            case OP_MAY:
                mainText = "El MAYOR es ............:";
                result = n1 > n2 ? n1 : n2;
                break;
            default:
                mainText = "El MENOR es ............:";
                result = n1 < n2 ? n1 : n2;
        }

        //Devolvemos el resultado
        return result;
    }
}
