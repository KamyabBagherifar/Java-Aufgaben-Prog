package LambdaDigit;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

/**
 * ## Bestimmen einer Stelle einer Zahl mittels Lambdas
 * <p>
 * Diese Aufgabe haben Sie bereits exakt oder in sehr ähnlicher Form
 * an anderen Stellen im Praktikum gelöst. Diesmal dürfen Sie
 * allerdings nur Streams und Lambdafunktionen nutzen.
 * Innerhalb von Lambdafunktionen sind jegliche Kontrollanweisungen
 * wie Schleifen oder bedingte Anweisungen untersagt.
 * Sie dürfen aber natuerlich Teilprobleme in andere Lambdafunktionen,
 * Operatoren oder Prädikate auslagern.
 * <p>
 * Entwickeln Sie nun bitte eine Lambdafunktion `nthDigit` und machen Sie diese
 * in `public static` Datenfeldern außerhalb der `main()`-Methode
 * für die Auto-Evaluierung bekannt.
 * <p>
 * `nthDigit` soll aus einer ganzen Zahl (Dezimalnotation) den Wert der
 * n.ten Stelle zurückgeben.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - Nutzen Sie jeweils den konkretesten Lambda Typ
 * (also bspw. `Predicate<String>` anstatt `Function<String, Boolean>`).
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind nur Lambda Funktionen erlaubt, keine Methoden (bis auf die `main()`).
 * - Es sind keine Schleifen oder bedingten Anweisungen erlaubt.
 */
class Main {

    public static void main(String[] args) {

        int result = nthDigit.apply(4321, 1);
        System.out.println(result); // => 3
        System.out.println(nthDigit.apply(4321, 5)); // => null
    }

    public static BinaryOperator<Integer> nthDigit;

    static {
        nthDigit = (i1, i2) -> i1 < 0 ? nthDigit.apply(i1 * (-1), i2) : i2 < 0 ? null
                : (i1 + "").length() > i2 ? Integer.parseInt((i1 + "").substring(i2, i2 + 1)) : null;
    }
}