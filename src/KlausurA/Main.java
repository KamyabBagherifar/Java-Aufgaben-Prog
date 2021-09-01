package KlausurA;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 * ## Generische `valueFilter()`-Methode
 * <p>
 * Entwickeln Sie bitte eine eigenständig generische `valueFilter()`-Methode,
 * die in Maps nach Value-Elementen mit spezifischen Eigenschaften sucht
 * und die Treffer als Liste zurück gibt.
 * <p>
 * Beachten Sie, dass Maps leer oder `null` sein können und
 * auch Values `null`-Werte enthalten können.
 * <p>
 * Aufruf-Beispiele zur Nutzung von `valueFilter()` finden Sie in der `main()`-Methode.
 */
class Main {

    // Entwickeln Sie hier bitte die valueFilter()-Methode

    public static void main(String[] args) {

        Map<String, Integer> msi = new TreeMap<>();
        msi.put("a", 1);
        msi.put("b", 2);
        msi.put("d", 10);

        List<Integer> vis = valueFilter(msi, v -> v < 10);
        System.out.println(vis);
        // => [1, 2]

        Map<Character, String> mcs = new TreeMap<>();
        mcs.put('1', "Hello");
        mcs.put('2', "fantastic");
        mcs.put('3', "World");

        List<String> vss = valueFilter(mcs, v -> v.length() > 5);
        System.out.println(vss);
        // => [fantastic]
    }

    public static <T, U> List<T> valueFilter(Map<U, T> tree, Predicate<T> pre) {
        List<T> resultList = new LinkedList<>();
        if (tree == null) return resultList;
        if (tree.isEmpty()) return resultList;
        for (T element : tree.values()) {
            if (element != null) {
                if (pre.test(element)) {
                    resultList.add(element);
                }

            }
        }


        return resultList;
    }
}
