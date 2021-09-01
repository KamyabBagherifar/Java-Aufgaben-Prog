package Combine;

import Combine.Combination;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/**
 * ## Generic `combine()`
 * <p>
 * Entwickeln Sie nun bitte eine generische Klasse `Combination`
 * und eine eigenständig generische Methode `combine()`.
 * `combine()` soll alle Elemente zweier Listen beliebigen Typs
 * paarweise kombinieren und als Liste von
 * `Combination`s zurück geben.
 * <p>
 * Aufrufbeispiele zur Erzeugung einer `Combination` und
 * dem Aufruf der Methode `combine()`  finden Sie in der
 * `main()`-Methode.
 * <p>
 * Achten Sie auf eine sinnvolle Behandlung von null-Pointern.
 */
class Main {

    // Bitte hier die Methode combine() entwicklen.

    public static void main(String[] args) {
        // Combination-Beispiele
        Combination<String, Integer> c = new Combination<>("Hello", 42);
        System.out.println(c.toString()); // => (Hello, 42)
        System.out.println(c.getFirst()); // => Hello
        System.out.println(c.getSecond()); // => 42

        List<String> strs = Arrays.asList("A", "B", "C");
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> doubles = Arrays.asList(0.0);
        List<Boolean> bools = Arrays.asList();
        List<Character> nil = null;

        List<Combination<Integer, Double>> result = combine(ints, doubles);
        System.out.println(result);
        // => [(1, 0.0), (2, 0.0)]

        System.out.println(combine(doubles, ints)); // => [(0.0, 1), (0.0, 2)]
        System.out.println(combine(strs, bools)); // => []
        System.out.println(combine(nil, strs)); // => []
    }

    public static <T, U> List<Combination<T, U>> combine(List<T> list1, List<U> list2) {
        List<Combination<T, U>> result = new LinkedList<>();
        if (list1 == null || list2 == null) return result;
        for (T element1 : list1) {
            for (U element2 : list2) {
                result.add(new Combination<>(element1, element2));
            }

        }
        return result;
    }


}

