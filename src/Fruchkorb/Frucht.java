package Fruchkorb;

public class Frucht implements Energie {
    private int gewicht;
    private int kalorien;

    public Frucht(int min, int max, int kcal) {
        kalorien = kcal;
        gewicht = (int) ((Math.random() * (max - min)) + min);
    }

    public Frucht(int gew, int kcal) {
        kalorien = kcal;
        gewicht = gew;
    }

    public String toString() {
        return "";
    }

    public long kalorien() {
        return Math.round((gewicht * kalorien) / 100);
    }

    public int getGewicht() {
        return gewicht;
    }


}
