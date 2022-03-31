public class Carta {
    private String pinta;
    private String simbolo;
    private int valor;

    public Carta(String pinta, String simbolo, int valor) {
        this.pinta = pinta;
        this.simbolo = simbolo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "pinta='" + pinta + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", valor=" + valor +
                '}';
    }

    public String getPinta() {
        return pinta;
    }

    public void setPinta(String pinta) {
        this.pinta = pinta;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
