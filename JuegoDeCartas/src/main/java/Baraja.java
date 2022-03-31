import java.util.ArrayList;

public class Baraja {
//crear baraja

    private ArrayList<Carta> baraja = new ArrayList<>();

    public Baraja(int nMazo) {
        String[] pinta = {"Trebol", "Diamante", "Corazon", "Pica"};
        String[] simbolo = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] valor = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        //----------------------------------------------------------
        for (int k = 0; k < nMazo; k++) {
            for (String s : pinta) {
                for (int j = 0; j < simbolo.length; j++) {
                    baraja.add(new Carta(s, simbolo[j], valor[j]));
                }
            }
        }
        System.out.println(baraja);
    }

    public ArrayList<Carta> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<Carta> baraja) {
        this.baraja = baraja;
    }
}



