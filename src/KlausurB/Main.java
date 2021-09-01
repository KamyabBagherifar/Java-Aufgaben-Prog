package KlausurB;

import java.util.LinkedList;
import java.util.List;

/**
 * ## Rekursive Generierung von Primzahlen
 * <p>
 * Gegeben seien die beiden rekursiven Methoden
 * <p>
 * - `boolean test(int)` und
 * - `boolean test(int, int)`.
 * <p>
 * Fragen Sie sich, welche Eigenschaft diese Methoden wohl testen?
 * <p>
 * Entwickeln Sie nun eine rekursive Methode `primes()`,
 * die eine Liste aller Primzahlen von einer unteren bis zu einer
 * oberen Schranke als aufsteigend sortierte Liste liefert.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind keine Schleifen erlaubt.
 * - Es sind keine Lambda-Funktionen oder Streams erlaubt.
 * - Es sind keine Datenfelder außerhalb der rekursiven Methode erlaubt.
 */
class Main {

    // Gegeben
    public static boolean test(int n) {
        return n < 2 ? false : test(n, 2);
    }

    // Gegeben
    public static boolean test(int n, int t) {
        if (t > n / 2) return true;
        return n % t == 0 ? false : test(n, t + 1);
    }

    // Entwickeln Sie hier bitte Ihre Methode primes()

    public static void main(String[] args) {
        List<Integer> primes = primes(100, 113);
        System.out.println(primes);
        // [101, 103, 107, 109, 113]
    }

    public static List<Integer> primes(Integer i1, Integer i2) {
        List<Integer> resutl = new LinkedList<>();
        return primes(i1, i2,resutl);
    }
    public static List<Integer> primes(int i1, int i2, List<Integer> list){
        if(i1 > i2) return list;
        if(!test(i1)) return primes(i1 + 1, i2, list);
        list.add(i1); return primes(i1 + 1, i2, list);
    }





}
