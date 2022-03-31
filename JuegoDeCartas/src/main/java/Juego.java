import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {
    private ArrayList<Carta> mano1 = new ArrayList<>();
    private ArrayList<Carta> mano2 = new ArrayList<>();
    Scanner leer = new Scanner(System.in);
    Random azar = new Random();
    //CONSTRUCTOR
    public Juego(Persona p1, Persona p2, Baraja baraja) {
        //inicializar puntajes----------------------------------------------------------------------------------------
        p1.setPuntaje(0);
        p2.setPuntaje(0);
        //------------------------------------------------------------------------------------------------------------
        int respuesta1 = 1;
        int respuesta2 = 1;
        //comenzar juego.------------------------------------------------------------------------------------------
        System.out.println("Comienza el juego");
        //indices de posición de cartas en mano 1 y mano 2.
        int i = 0;
        int j = 0;

        while (respuesta1 == 1 && respuesta2 == 1) {

            //preguntar si quiere sacar (s/n)--------------------------------------------------------------------------

            System.out.println(p1.getNombre() + " ¿desea sacar una carta?");
            System.out.println("1: si" + "\n2: no");
            respuesta1 = leer.nextInt();
            if (respuesta1 < 1 || respuesta1 > 2) {
                System.out.println("valor de elección inválido, espere el siguiente turno");
                respuesta1 = 2;
            }

            //corroborar que puede sacar-----------------------------------------------------------------------------
            if (respuesta1 == 1 && mano1.size() > 2) {
                System.out.println("no puede tomar más cartas");
                respuesta1 = 2;
            }
            //-------------------------------------------------------------------------------------------------------
            System.out.println(p2.getNombre() + " ¿desea sacar una carta?");
            System.out.println("1: si" + "\n2: no");
            respuesta2 = leer.nextInt();

            if (respuesta2 < 1 || respuesta2 > 2) {
                System.out.println("valor de elección inválido, espere el siguiente turno");
                respuesta2 = 2;
            }

            if (respuesta2 == 1 && mano2.size() > 2) {
                System.out.println("no puede tomar más cartas");
                respuesta2 = 2;
            }

            //agregar a la mano de cada persona según corresponda------------------------------------------------------            }
            if (respuesta1 == 1 && respuesta2 == 1) {


                this.mano1.add(baraja.getBaraja().get(this.azar.nextInt(baraja.getBaraja().size())));
                p1.setPuntaje(p1.getPuntaje() + this.mano1.get(i).getValor());

                System.out.println(p1.getNombre() + " su carta es: " + this.mano1.get(i) + " y su valor total es: " + p1.getPuntaje() + ".");
                i++;

                this.mano2.add(baraja.getBaraja().get(this.azar.nextInt(baraja.getBaraja().size())));
                p2.setPuntaje(p2.getPuntaje() + this.mano2.get(j).getValor());
                System.out.println(p2.getNombre() + " su carta es: " + mano2.get(j) + " y su valor total es: " + p2.getPuntaje() + ".");
                j++;


            } else if (respuesta1 == 1) {

                this.mano1.add(baraja.getBaraja().get(this.azar.nextInt(baraja.getBaraja().size())));
                p1.setPuntaje(p1.getPuntaje() + this.mano1.get(i).getValor());

                System.out.println(p1.getNombre() + " su carta es: " + this.mano1.get(i) + " y su valor total es: " + p1.getPuntaje() + ".");
                i++;
                respuesta2 = 1;
            } else if (respuesta2 == 1) {

                mano2.add(baraja.getBaraja().get(this.azar.nextInt(baraja.getBaraja().size())));
                p2.setPuntaje(p2.getPuntaje() + this.mano2.get(j).getValor());
                System.out.println(p2.getNombre() + " su carta es: " + this.mano2.get(j) + " y su valor total es: " + p2.getPuntaje() + ".");
                j++;
                respuesta1 = 1;
            } else {
                respuesta1 = 2;
                respuesta2 = 2;
            }
        }
        //cuando ya no puedan o quieran tomar mas cartas

        //si pierden los dos-----------------------------------------------
        if (p1.getPuntaje() > 20 && p2.getPuntaje() > 20) {
            System.out.println("los dos jugadores pierden por pasarse de 20");
            System.out.println("los puntajes son: ");
            System.out.println(p1.getPuntaje());
            System.out.println(p2.getPuntaje());
        }
        //--------------------------------------------------------------------------------
        else {

            //si pierde jugador 1--------------------------------------------------------------
            if (p1.getPuntaje() > 20) {
                System.out.println(p1.getNombre() + " se pasó de 20 puntos, gana " + p2.getNombre());
                System.out.println("mano de " + p1.getNombre() + ": " + this.mano1);
                System.out.println("mano de " + p2.getNombre() + ": " + this.mano2);
            }
            //----------------------------------------------------------------------------------

            //si gana jugador 1-----------------------------------------------------------------
            else if (p1.getPuntaje() - 20 > p2.getPuntaje() - 20) {
                System.out.println("gana " + p1.getNombre() + " con puntaje de " + p1.getPuntaje());
                System.out.println("vs un puntaje de " + p2.getPuntaje() + " de " + p2.getNombre());
                System.out.println("las manos de cada jugador fueron: ");
                System.out.println("mano de " + p1.getNombre() + ": " + this.mano1);
                System.out.println("mano de " + p2.getNombre() + ": " + this.mano2);
            }
            //-----------------------------------------------------------------------------------

            //si pierde jugador 2----------------------------------------------------------------
            if (p2.getPuntaje() > 20) {
                System.out.println(p2.getNombre() + " se pasó de 20 puntos, gana " + p1.getNombre());
                System.out.println("mano de " + p1.getNombre() + ": " + mano1);
                System.out.println("mano de " + p2.getNombre() + ": " + mano2);
            }
            //------------------------------------------------------------------------------------

            //si gana jugador 2-------------------------------------------------------------------
            else if (p2.getPuntaje() - 20 > p1.getPuntaje() - 20) {
                System.out.println("gana " + p2.getNombre() + " con puntaje de " + p2.getPuntaje());
                System.out.println("vs un puntaje de " + p1.getPuntaje() + " de " + p1.getNombre());
                System.out.println("mano de " + p1.getNombre() + ": " + this.mano1);
                System.out.println("mano de " + p2.getNombre() + ": " + this.mano2);
            }
            //-------------------------------------------------------------------------------------
        }
    }



    //setters y getters que no se estan usando pero no está de mas ponerlos---------------------------------------
    public ArrayList<Carta> getMano1() {
        return mano1;
    }

    public void setMano1(ArrayList<Carta> mano1) {
        this.mano1 = mano1;
    }

    public ArrayList<Carta> getMano2() {
        return mano2;
    }

    public void setMano2(ArrayList<Carta> mano2) {
        this.mano2 = mano2;
    }
}
