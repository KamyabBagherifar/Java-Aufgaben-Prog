package Check;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * ## Generische `check()`-Methode
 * <p>
 * Entwickeln Sie bitte eine eigenständig generische `check()`-Methode,
 * die Werte einer Liste anhand eines Kriteriums
 * (`Predicate`) in eine `Partition`  aufteilt.
 * <p>
 * Eine Partition teilt eine Liste in eine Liste gültiger (`valids()`) und ungültiger
 * (`invalids()`) Einträge. null Einträge sind dabei immer ungültig. Die Reihenfolge der
 * Einträge bleibt dabei erhalten.
 * <p>
 * Aufruf-Beispiele zur Erzeugung von `Partition`en und Nutzung
 * der `check()`-Methode finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweis:__
 * <p>
 * - Wenn Sie die `Partition`-Klasse geeignet implementieren,
 * ist die `check()`-Methode wesentlich einfacher
 * als Sie auf den ersten Blick aussehen mag.
 * - Bei Lambda-Funktionen arbeiten Sie bitte immer mit den
 * spezifischeren Typen. Also bspw. mit `Predicate<String>`
 * anstelle des allgemeineren Typs `Function<String, Boolean>`.
 */
class Main {

    // Entwickeln Sie hier bitte die check()-Methode

    public static void main(String[] args) {
        // Beispiel für eine Partitionserstellung
        // - alle Strings mit weniger als vier Zeichen sind gültig
        // - alle Strings mit mehr als vier Zeichen sind ungültig
        //
        List<String> strings = Arrays.asList(
                "Dies", "ist", "mal", "wieder", "nur", "so", "ein", "Beispiel"
        );
        Partition<String> p = check(strings, s -> s.length() < 4);
        List<String> valids = p.valids();
        List<String> invalids = p.invalids();

        System.out.println(valids); // => [ist, mal, nur, so, ein]
        System.out.println(invalids); // => [Dies, wieder, Beispiel]

        // Weiteres Beispiel auf Basis eines anderen Datentyps:
        // Wir teilen nun eine Liste ganzer Zahlen in gerade (gültige)
        // und ungerade (ungültige) Zahlen.
        //
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(check(values, i -> i % 2 == 0).valids()); // => [2, 4]
        System.out.println(check(values, i -> i % 2 == 0).invalids()); // => [1, 3, 5]
    }

    public static <T> Partition<T> check(List<T> list, Predicate<T> pre) {
        List<T> resultValids = new LinkedList<>();
        List<T> resultInvalids = new LinkedList<>();
        for (T element : list) {
            if (element == null) {
                resultInvalids.add(element);
            } else {
                if (pre.test(element)) {
                    resultValids.add(element);
                } else {
                    resultInvalids.add(element);
                }
            }

        }
        return new Partition<T>(resultValids, resultInvalids);
    }


}
