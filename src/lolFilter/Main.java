package lolFilter;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ## Generische `lolFilter()`-Methode
 * <p>
 * Entwickeln Sie bitte eine eigenständig generische `lolFilter()`-Methode,
 * die in zweidimensionalen Listen (List of Lists) nach Elementen
 * mit spezifischen Eigenschaften sucht und die Treffer als Liste zurück gibt.
 * <p>
 * Beachten Sie, dass Listen leer sein können und `null`-Werte enthalten können.
 * <p>
 * Aufruf-Beispiele zur Nutzung von `lolFilter()` finden Sie in der `main()`-Methode.
 */
class Main {

    // Entwickeln Sie hier bitte die lolFilter()-Methode

    public static void main(String[] args) {

        List<List<Integer>> ints = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6)
        );
        List<Integer> results = lolFilter(ints, (i) -> i > 2 && i < 6);
        System.out.println(results);
        // => [3, 4, 5]

        List<List<String>> strings = Arrays.asList(
                Arrays.asList("Dies", "ist", "mal"),
                Arrays.asList("wieder", "nur", "so", "ein"),
                Arrays.asList("Kruse"),
                Arrays.asList("Beispiel")
        );
        System.out.println(lolFilter(strings, (s) -> s.length() <= 3));
        // => [ist, mal, nur, so, ein, .]
    }

    public static <T> List<T> lolFilter(List<List<T>> list, Predicate<T> pre) {
        List<T> result = new LinkedList<>();
        if (list.isEmpty()) return result;
        for (List<T> element1 : list) {
            for (T element2 : element1) {
                if (element2 != null) {
                    if (pre.test(element2)) result.add(element2);


                }
            }

        }
        return result;
    }


}

