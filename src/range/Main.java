package range;

import java.util.LinkedList;
import java.util.List;

/**
 * ## Rekursive `range()` Methode
 * <p>
 * Entwickeln Sie nun bitte eine __rekursive__ Methode namens `range()` mit
 * der Sie nummerische Aufzählungen erzeugen können.
 * <p>
 * Die `range()` Methode erhält einen Startwert, einen Endwert und
 * eine Schrittweite und erzeugt aus diesen Angaben eine Liste von Werten
 * beginnend ab einem Startwert (inklusive) bis zu einem Endwert (inklusive).
 * <p>
 * Da die `range()` Methode insbesondere in `for`-Schleifen angewendet werden
 * kann, soll eine Schrittweite von 0 immer eine leere Liste liefern,
 * da ansonsten unendlich lange Listen erzeugt würden.
 * <p>
 * Aufrufbeispiele für die `range()` Methode finden Sie in der
 * `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - Gesucht ist nach einer rekursiven Lösung für das Problem.
 * - Sollten Sie dies nicht hinbekommen, können Sie eine iterative
 * Lösung angeben. Für diese gibt es aber maximal die Hälfte der
 * Punkte.
 */
class Main {

    public static void main(String[] args) {

        List<Integer> vs = range(1, 10, 2);
        System.out.println(vs); // [1, 3, 5, 7, 9]

        System.out.println(range(10, 0, -3)); // => [10, 7, 4, 1]
        System.out.println(range(-1, 0, -1)); // => []

        // Da dies hier gilt!
        System.out.println(range(0, 100, 0)); // => []
        for (int i : range(0, 100, 0)) {
            System.out.println("Sollte dies hier nie ausgegeben werden.");
        }
    }

    public static List<Integer> range(int i, int i1, int i2) {
        List<Integer> result = new LinkedList<>();
        return range(i, i1, i2, result);

    }

    public static List<Integer> range(int i, int i1, int i2, List<Integer> result) {
        if ((i < i1 && i2 < 0) || (i > i1 && i2 > 0) || i2 == 0) return result;
        result.add(i);
        return range(i + i2, i1, i2, result);

    }
}
