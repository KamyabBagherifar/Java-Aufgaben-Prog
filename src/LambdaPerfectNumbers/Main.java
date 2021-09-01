package LambdaPerfectNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ## Vollkommene Zahlen mittels Lambdas bestimmen
 * <p>
 * Eine natürliche Zahl $n$ wird vollkommene Zahl (auch perfekte Zahl) genannt,
 * wenn sie gleich der Summe aller ihrer (positiven) Teiler außer sich selbst ist.
 * <p>
 * Die kleinsten drei vollkommenen Zahlen sind:
 * <p>
 * - $6   = 1 + 2 + 3 = 6$
 * - $28  = 1 + 2 + 4 + 7 = 28$
 * - $496 = 1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248 = 496$
 * <p>
 * Entwickeln Sie nun bitte mehrere Lambda-Funktionen, um perfekte Zahlen bis zu einer
 * oberen Schranke zu bestimmen und machen Sie diese
 * in `public static` Datenfeldern außerhalb der `main()`-Methode
 * für die Auto-Evaluierung bekannt.
 * <p>
 * Zerlegen Sie das Problem so in folgende Lambdafunktionen (Teilprobleme).
 * <p>
 * - Entwickeln Sie ein Prädikat `perfect`, dass bestimmt, ob eine Zahl eine vollkommene Zahl ist.
 * - Entwickeln Sie eine Lambdafunktion `perfectNumbers`, die `perfect` nutzt, um eine Liste aller
 * aufsteigend sortierten vollkommenen Zahlen bis zu einer gegebenen Schranke zu bestimmen.
 * <p>
 * Entsprechende Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - https://de.wikipedia.org/wiki/Vollkommene_Zahl
 * - Vergleichen Sie den Wert von `Integer` (nicht `int`) in Streams mittels `equals()` oder
 * casten Sie mittels `(int)` auf den primitiven Datentyp `int`, der mittels `==` verglichen werden kann.
 * - Sie können auch `IntStream` nutzen, um einen Stream primitiver Datentypen zu erzeugen und
 * diese Vergleichsprobleme zu vermeiden.
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

        System.out.println(perfect.test(4)); // => false
        System.out.println(perfect.test(496)); // => true

        int[] perfects = perfectNumbers.apply(1000);
        System.out.println(Arrays.toString(perfects)); // => [6, 28, 496]
    }

    public static IntPredicate perfect;

    static {
        perfect = i -> IntStream.rangeClosed(1, i / 2).filter(e -> i % e == 0).sum() == i;
    }

    public static Function<Integer, int[]> perfectNumbers;

    static {
        perfectNumbers = i -> IntStream.rangeClosed(1, i).filter(perfect).toArray();
    }

}