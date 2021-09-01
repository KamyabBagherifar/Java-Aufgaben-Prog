package Compact;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * ## Generische `compact()`-Methode
 * <p>
 * Entwickeln Sie bitte eine eigenständig generische `compact()`-Methode,
 * die in beliebigen Listen alle `null` Einträge herausfiltert.
 * <p>
 * Aufruf-Beispiele finden Sie in der `main()`-Methode.
 */
class Main {

    public static void main(String[] args) {
        List<Integer> is = Arrays.asList(1, 2, 3, null, 4, 5, 6);
        List<Integer> cis = compact(is);
        System.out.println(cis); // [1, 2, 3, 4, 5, 6]
        List<String> strings = Arrays.asList("Hello", null, "World");
        System.out.println(compact(strings)); // ["Hello", "World"]
    }

    public static <T> List<T> compact(List<T> list) {
        //return list.stream().filter(e-> e != null).collect(Collectors.toList());
        List<T> result = new LinkedList<>();
        for (T elemet : list) {
            if (elemet != null) {
                result.add(elemet);
            }

        }
        return result;
    }

}
