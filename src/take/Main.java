package take;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * ## Generische `take()` Methode
 * <p>
 * Schreiben Sie eine eigenständig generische `take()`-Methode,
 * die aus einer Liste alle Einträge übernimmt, die einer
 * Filterbedingung genügen.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 */
class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("Dies", "ist", "nur", "ein", "Beispiel");

        List<Integer> ints = take(numbers, (n) -> n % 2 == 0);
        System.out.println(ints); // => [2, 4, 6]

        List<String> strs = take(strings, (s) -> s.length() % 2 == 1);
        System.out.println(strs); // => [ist, nur, ein]
    }

    public static <T> List<T> take(List<T> list, Predicate<T> p) {
        List<T> result = new LinkedList<>();
        if (list.isEmpty()) return result;
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }

        }
        return result;
    }

}




