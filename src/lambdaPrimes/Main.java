package lambdaPrimes;


import java.util.List;


import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * ## Primzahlen mit Lambdas bestimmen (und ausgeben)
 * <p>
 * Entwickeln Sie nun bitte mehrere Lambda-Funktionen und machen Sie diese
 * in `public static` Datenfeldern außerhalb der `main()`-Methode
 * für die Auto-Evaluierung bekannt.
 * <p>
 * - `isPrim` (bestimmt eine Primzahl)
 * - `primes` (liefert eine Liste aller Primzahlen bis zu einer oberen Schranke, exklusiv)
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - https://de.wikipedia.org/wiki/Primzahl
 * - Nutzen Sie jeweils den konkretesten Lambda Typ
 * (also bspw. `Predicate<String>` anstatt `Function<String, Boolean>`).
 * - Achten Sie darauf, dass Sie Streams limitieren (ansonsten haben Sie Endlosberechnungen).
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind nur Lambda Funktionen erlaubt, keine Methoden (bis auf die `main()`).
 * - Es sind keine Schleifen oder bedingten Anweisungen erlaubt.
 */
class Main {

    public static void main(String[] args) {
        System.out.println(isPrime.test(4)); // => false
        System.out.println(isPrime.test(7)); // => true

        List<Integer> result = primes.apply(20);
        System.out.println(result); // => [2, 3, 5, 7, 11, 13, 17, 19]
        System.out.println(primes.apply(3)); // => [2]
    }

    public static IntPredicate isPrime;

    static {
        isPrime = i -> i >= 2 && IntStream.rangeClosed(2, i / 2).noneMatch(e -> i % e == 0);
    }

    public static Function<Integer, List<Integer>> primes;

    static {
        primes = i -> IntStream.range(2, i).filter(e -> isPrime.test(e)).boxed().collect(Collectors.toList());
    }
}
