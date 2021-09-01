package JoinAndSum;

import java.util.List;
import java.util.Arrays;

/**
 * ## Listen rekursiv verarbeiten
 * <p>
 * Schreiben Sie nun bitte zwei __rekursive__ Methoden
 * `join()` und `sum()`.
 * <p>
 * `join()` soll eine Liste von Integer Werten mit einem Trennzeichnen
 * verknüpfen und eine Zeichenkette zurückgeben.
 * <p>
 * `sum()` soll eine Liste von Integer Werten aufaddieren und einen
 * `int` Wert zurückgeben.
 * <p>
 * Sie finden Aufrufbeispiele für beide Methoden in der `main()`-Methode.
 * <p>
 * __Hinweis:__
 * <p>
 * - Sehen Sie sich noch einmal in Unit 05 an, wie sequenzbasierte
 * Rekursionen formuliert werden können.
 * - Wiederholen Sie noch einmal das Überladen von Methoden.
 * <p>
 * __Verbote:__
 * <p>
 * - Sie sollen rekursiv programmieren, d.h. Schleifen aller Art sind
 * verboten.
 */
class Main {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3);
        String operation = join(values, "+");
        System.out.println(operation); // => 1+2+3

        int sum = sum(values);
        System.out.println(operation + "=" + sum); // => 1+2+3=6
    }

    public static String join(List<Integer> ints, String str) {
        if (ints.isEmpty()) return "";
        if (ints.size() == 1) return ints.get(0) + "";
        return ints.get(0) + str + join(ints.subList(1, ints.size()), str);
    }

    public static int sum(List<Integer> ints) {
        if (ints.isEmpty()) return 0;
        return ints.get(0) + sum(ints.subList(1, ints.size()));
    }

}
