package Fruchkorb;

public class Pfirsich extends Frucht {


    public Pfirsich(int p) {
        super(p, 39);
    }

    public Pfirsich() {
        super(100, 160, 39);
    }

    public String toString() {
        return "Pfirsich, " + super.getGewicht() + " g, " + super.kalorien() + " kcal";
    }


}
