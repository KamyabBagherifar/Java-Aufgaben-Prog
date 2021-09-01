package lambdaOccurrences;

import java.util.function.BiFunction;


/**
 * ## Vorkommen von Zeichenketten mittels Lambdas zählen
 * <p>
 * Schreiben Sie nun eine Lambda-Funktion `occurrences` die zählt,
 * wie häufig eine Zeichenkette *a* in einer
 * anderen Zeichenkette *b* vorkommt. Sich überlagernde Zeichenketten sind erlaubt.
 * D.h. "xx" ist als zweimal in "xxx" vorkommend zu zählen.
 * Leere Zeichenketten sind nicht zu zählen.
 * Machen Sie `occurrences` in einem `public static` Datenfeld außerhalb der
 * `main()`-Methode für die Auto-Evaluierung bekannt.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind nur Lambda Funktionen erlaubt, keine Methoden (bis auf die `main()`).
 * - Vermeiden Sie Blöcke in Lambda-Definitionen.
 * - Es sind keine Schleifen oder bedingten Anweisungen erlaubt.
 */
class Main {

    public static void main(String[] args) {
        int n = occurrences.apply("Hello", "Hello World");
        System.out.println(n); // => 1
        System.out.println(occurrences.apply("abc", "abc abc abc")); // => 3
        System.out.println(occurrences.apply("xx", "xxx")); // => 2
    }

    public static BiFunction<String, String, Integer> occurrences;

    static {
        occurrences = (str2, str1) -> str2.isEmpty() || str1.isEmpty() ? 0
                : str1.startsWith(str2) ? 1 + occurrences.apply(str2, str1.substring(1))
                : occurrences.apply(str2, str1.substring(1));
    }


}