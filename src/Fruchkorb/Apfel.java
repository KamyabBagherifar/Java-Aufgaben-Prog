package Fruchkorb;

public class Apfel extends Frucht {

    public Apfel(int g) {
        super(g, 52);
    }

    public Apfel() {
        super(100, 200, 52);

    }

    public String toString() {
        return "Apfel, " + super.getGewicht() + " g, " + super.kalorien() + " kcal";
    }


}
