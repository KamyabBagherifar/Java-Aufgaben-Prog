package Selector;


import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ## Eigenständig generische `selector()` Methode
 * <p>
 * Entwickeln Sie nun bitte eine __generische__ Methode `selector()`,
 * die aus einer Liste von Werten beliebigen Typs `T` diejenigen Werte selektiert,
 * die einer booleschen Bedingung genügen.
 * <p>
 * - Wird in `selector()` keine boolesche Bedingung als zweiter Parameter angegeben,
 * so soll `selector()` alle von `null` verschiedenen Werte zurückgeben.
 * - Ist der zweite Parameter `null`, so soll `selector()` ebenfalls alle von `null`
 * verschiedenen Werte zurückgeben.
 * - Ist der erste Parameter `null`, so soll `selector()` eine leere Liste zurückgeben.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - __ALLE__ `selector()`-Methoden müssen eigenständig generisch implementiert sein.
 * - Erinnerung: Optionale Parameter (hier der zweite Parameter) lassen sich mittels
 * überladenen Methoden (Methoden gleichen Namens mit unterschiedlichen Parametersätzen)
 * realisieren.
 */
class Main {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = selector(values, i -> i % 2 == 0);
        System.out.println(result);
        // => [2, 4, 6, 8]

        List<String> words = Arrays.asList(
                "Dies", "ist", "nur", "ein", "dummes", "Beispiel"
        );
        System.out.println(selector(words, w -> w.length() <= 3));
        // => [ist, nur, ein]

        List<Boolean> withNulls = Arrays.asList(
                true, null, false, null, true, null, false, null
        );
        System.out.println(selector(withNulls));
        // => [true, false, true, false]
    }

    public static <T> List<T> selector(List<T> list, Predicate<T> pre){
        List<T> result = new LinkedList<>();
        for (T element: list) {
            if(pre.test(element)) result.add(element);

        }
        return result;
    }

    public static <T> List<T> selector(List<T> list){
        return selector(list, x-> x != null);
    }
}
