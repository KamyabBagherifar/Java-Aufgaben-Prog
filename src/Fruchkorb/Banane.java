package Fruchkorb;

public class Banane extends Frucht {


    public Banane(int g) {
        super(g, 93);
    }

    public Banane() {
        super(75, 200, 93);

    }

    public String toString() {
        return "Banana, " + super.getGewicht() + " g, " + super.kalorien() + " kcal";
    }
}
