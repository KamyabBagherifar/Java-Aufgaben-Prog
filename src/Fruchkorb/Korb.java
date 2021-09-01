package Fruchkorb;

import java.util.LinkedList;
import java.util.List;

public class Korb implements Energie {
    private List<Frucht> fruechte = new LinkedList<>();

    public Korb() {

    }

    public Korb(List<Frucht> k) {
        fruechte = k;
    }

    public void add(Frucht... f) {
        for (Frucht i : f) {
            fruechte.add(i);

        }


    }

    public String toString() {
        String result = "Fruchtkorb mit insgeasmt " + this.kalorien() + " kcal \n";
        for (Frucht f : fruechte) {
            result = result + "+ " + f.toString() + "\n";

        }
        return this.kalorien() == 0 ? result : result.substring(0, result.length() - 1);

    }


    @Override
    public long kalorien() {
        long result = 0;
        for (Frucht f : fruechte) {
            result = result + f.kalorien();

        }
        return result;
    }
}
