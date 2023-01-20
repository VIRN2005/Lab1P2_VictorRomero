package lab1p2_victorromero;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lab1P2_VictorRomero {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();

    public static void main(String[] args) throws ParseException {
        System.out.println("Victor Romero - 12211079");

        int opcion;

        do {
            System.out.println("_____________________________________________________________ ");
            System.out.println(" ");
            System.out.println(">> MENU <<");
            System.out.println("----------------------- ");

            System.out.println("1 -> EJERCICIO 1 - TORRES DE HANOI");
            System.out.println("2 -> EJERCICIO 2 - IDENTIFICADOR FECHAS");
            System.out.println("3 -> EJERCICIO 3 - SUMATORIA PI");

            System.out.println("4 -> SALIDA");
            System.out.println(" ");
            System.out.println(" ");

            System.out.print("Ingrese su Opcion: ");
            opcion = leer.nextInt();
            System.out.println("=> La Opcion escojida es: " + opcion);
            System.out.println(" ");

            switch (opcion) {

                case 1: {
                    System.out.println("==> HAN0I <== \n");
                    leer.nextLine();
                    System.out.println(">> Ingrese los ciclos: ");
                    int Ciclos_Hanoi = leer.nextInt();

                    Hanoi(Ciclos_Hanoi, 1, 2, 3);
                }

                break;

                case 2: {
                    System.out.println("==> ENCONTRAR FECHA <== \n");
                    leer.nextLine();
                    System.out.println(">> Ingrese una cadena (SIN ESPACIOS ENTRE LAS COMAS): ");
                    String FindFecha = leer.nextLine();
                    System.out.println("\n");
                    EncontrarFecha(FindFecha);
                }
                break;

                case 3: {
                    System.out.println("==> ENCONTRAR PI <== \n");
                    leer.nextLine();
                    System.out.println(">> Ingrese los ciclos: ");
                    int Ciclos = leer.nextInt();
                    System.out.println("\n");
                    System.out.println(Sum_pi(Ciclos, 0, 0));
                }
                break;
            }

        } while (opcion
                != 4);

    }

    public static void Hanoi(int n, int origen, int auxiliar, int destino) {
        if (n == 1) {
            System.out.println("Mover Disco " + n + " de " + origen + " a " + destino);
        } else {
            Hanoi(n - 1, origen, destino, auxiliar);
            System.out.println("Mover Disco " + n + " de " + origen + " a " + destino);
            Hanoi(n - 1, auxiliar, origen, destino);
        }
    }

    public static void EncontrarFecha(String Find_Date) throws ParseException {
        String Fechas[] = Find_Date.split(",");

        System.out.println("\n>>Fechas Identificadas en la Cadena:");
        for (int i = 0; i < Fechas.length; i++) {
            if (Fechas[i].charAt(2) == '/') {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date Fecha = df.parse(Fechas[i]);
                System.out.println(Fecha);
            }

            if (Fechas[i].charAt(2) == '*') {
                DateFormat df = new SimpleDateFormat("dd*MM*yyyy");
                Date Fecha = df.parse(Fechas[i]);
                System.out.println(Fecha);
            }

            if (Fechas[i].charAt(2) == '-') {
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date Fecha = df.parse(Fechas[i]);
                System.out.println(Fecha);
            }

        }
    }

    public static double Sum_pi(int k, int n, double resp) {
        double pi;
        double num = Math.pow(-1, n);
        double den = (2 * n)+ 1;
        resp += num / den;
        
        if (k == n) {
            resp = 4 * resp;
            return resp;
        } else {
            return Sum_pi(k, n + 1, resp);
        }

    }
}
